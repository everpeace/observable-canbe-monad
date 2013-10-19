package jx.lang.scala.scalaz

import java.util.concurrent.{ArrayBlockingQueue, CountDownLatch}
import java.util

import scala.concurrent.duration._

import scalaz._, Scalaz._
import org.specs2.scalaz._

import rx.lang.scala.Observable, Observable._
import rx.lang.scala.concurrency.Schedulers

class ObservableCanBeZipListLikeApplicative extends Spec {

  val scheduler = Schedulers.threadPoolForComputation

  // This produce ZipList like Applicative. (Note: ZipList cannot be a monad.)
  // Observable(f,g,h) <$> Observable(x,y,z) === Observable(f(x), g(y), h(z))
  // Note: point(a) generates an infinite sequence.
  implicit val zipListLikeApplicative = new Applicative[Observable] {
    def point[A](a: => A) = interval(1.nanos) map{_ => a} observeOn(scheduler)

    def ap[A, B](oa: => Observable[A])(of: => Observable[(A) => B]) = of.zip(oa) map {fa => fa._1(fa._2)}
  }

  "_+_ can be lifted to Observable(ZipList style): ^(Observable(1,2),Observable(3,5){_*_} equals to Observable(3,10,...)" in {
    val received = new ArrayBlockingQueue[Int](2)
    val latch = new CountDownLatch(2)
    // Note: this Observable never ends. because point(_+_) produces infinite sequence.
    val subscription = ^(Observable(1,2),Observable(3,5)){_*_}.subscribe(i => {
      received.add(i)
      latch.countDown()
    })

    latch.await()
    subscription.unsubscribe()
    val collected = new util.ArrayList[Int](2)
    received.drainTo(collected)
    collected.size() mustEqual(2)
    collected.get(0) mustEqual(3)
    collected.get(1) mustEqual(10)
  }
}
