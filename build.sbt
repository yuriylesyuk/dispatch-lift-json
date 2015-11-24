scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "net.databinder" %% "dispatch-core" % "0.8.10",
  "net.liftweb" %% "lift-json" % "2.6",
  "net.databinder" %% "dispatch-http" % "0.8.10" % "test",
  "org.specs2" %% "specs2-core" % "3.6.5" % "test",
  "org.specs2" %% "specs2-junit" % "3.6.5" % "test"
)
