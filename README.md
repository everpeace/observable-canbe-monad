see [src/test/scala/jx/lang/scala/scalaz/ObservableCanBeMonad.scala](https://github.com/everpeace/observable-canbe-monad/blob/master/src/test/scala/jx/lang/scala/scalaz/ObservableCanBeMonad.scala).

<pre>
$ sbt test
[info] Loading global plugins from /Users/everpeace/.sbt/plugins
[info] Set current project to default-be8178 (in build file:/Users/everpeace/Documents/githubs/observable-canbe-monad/)
[info] Updating {file:/Users/everpeace/Documents/githubs/observable-canbe-monad/}default-be8178...
[info] Resolving org.scalaz#scalaz-xml_2.10;7.0.4 ...
[info] Done updating.
[info] Compiling 1 Scala source to /Users/everpeace/Documents/githubs/observable-canbe-monad/target/scala-2.10/test-classes...
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
[info] Finished in 22 ms
[info] 12 examples, 1101 expectations, 0 failure, 0 error
[info] 
[info] Passed: : Total 12, Failed 0, Errors 0, Passed 12, Skipped 0
[success] Total time: 16 s, completed 2013/10/18 0:16:28
</pre>
