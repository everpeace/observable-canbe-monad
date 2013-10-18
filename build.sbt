scalaVersion := "2.10.3"

libraryDependencies := Seq( "org.scalaz" %% "scalaz-core" % "7.0.4",
                            "com.netflix.rxjava" % "rxjava-scala" % "0.14.5",
                            "org.typelevel" %% "scalaz-specs2" % "0.1.2",
                            "org.scalaz" %% "scalaz-scalacheck-binding" % "7.0.4"
                        )

scalacOptions += "-feature"

initialCommands in console := "import scalaz._, Scalaz._"
