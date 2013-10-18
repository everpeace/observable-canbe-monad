package rx.lang.scala.scalaz

import scalaz._, Scalaz._
import scalaz.scalacheck.ScalazProperties._
import org.scalacheck.Arbitrary
import org.specs2.scalaz._

import rx.lang.scala.Observable

class ObservableCanBeMonad extends Spec{
  // observable monad object by standard flatMapping.
  // this provides List monad like semantics.
  implicit val observableMonad = new Monad[Observable]{
    def point[A](a: => A) = Observable(a)
    def bind[A, B](oa: Observable[A])(f: (A) => Observable[B]) = oa.flatMap(f)
  }

  // Equality between two Observables
  // Assume two observable is equal if generated sequences by the two is identical.
  implicit def observableEqual[A](implicit eqA: Equal[A]) = new Equal[Observable[A]]{
    def equal(a1: Observable[A], a2: Observable[A]) = {
      var result = false
      a1.zip(a2).forall(p => p._1 === p._2).firstOrElse(false).subscribe(v => result = v)
      result
    }
  }

  // verify above monad object to satisfy monad law
  implicit def ObservableArbitrary[A](implicit a: Arbitrary[A]):Arbitrary[Observable[A]] = Arbitrary( for( r <- a.arbitrary ) yield Observable(r) )
  checkAll(monad.laws[Observable])

  "_*_ can be lifted to Observable: ^(Observable(1,2),Observable(3,5){_*_} === Observable(3,4,6,8)" in {
    val o1 = Observable(1, 2)
    val o2 = Observable(3, 4)
    ^(o1,o2){_*_} === Observable(3,4,6,8) must_== true
  }
}
