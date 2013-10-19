### RxJava's Observable can be a List like Monad and ZipList like Applicative functor.
* see [src/test/scala/jx/lang/scala/scalaz/ObservableCanBeMonad.scala](https://github.com/everpeace/observable-canbe-monad/blob/master/src/test/scala/jx/lang/scala/scalaz/ObservableCanBeMonad.scala).
* see [src/test/scala/jx/lang/scala/scalaz/ObservableCanBeZipListLikeApplicative.scala](https://github.com/everpeace/observable-canbe-monad/blob/master/src/test/scala/jx/lang/scala/scalaz/ObservableCanBeZipListLikeApplicative.scala).

<pre>
$ sbt test
[info] Loading global plugins from /Users/everpeace/.sbt/plugins
[info] Set current project to default-be8178 (in build file:/Users/everpeace/Documents/githubs/observable-canbe-monad/)
[info] ObservableCanBeZipListLikeApplicative
[info] 
[info] + _+_ can be lifted to Observable(ZipList style): ^(Observable(1,2),Observable(3,5){_*_} equals to Observable(3,10,...)
[info]  
[info] Total for specification ObservableCanBeZipListLikeApplicative
[info] Finished in 20 ms
[info] 1 example, 0 failure, 0 error
[info] 
[info] ObservableCanBeMonad
[info] 
[info] monad must satisfy
[info] + monad.applicative.functor.identity
[info] + monad.applicative.functor.composite
[info] + monad.applicative.identity
[info] + monad.applicative.composition
[info] + monad.applicative.homomorphism
[info] + monad.applicative.interchange
[info] + monad.applicative.map consistent with ap
[info] + monad.right identity
[info] + monad.left identity
[info] + monad.associativity
[info] + monad.ap consistent with bind
[info]  
[info] + _*_ can be lifted to Observable: ^(Observable(1,2),Observable(3,5){_*_} === Observable(3,4,6,8)
[info]  
[info] Total for specification ObservableCanBeMonad
[info] Finished in 51 ms
[info] 12 examples, 1101 expectations, 0 failure, 0 error
[info] 
[info] Passed: : Total 13, Failed 0, Errors 0, Passed 13, Skipped 0
[success] Total time: 2 s, completed 2013/10/18 18:46:41
</pre>