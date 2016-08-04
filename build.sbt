organization := "com.scharley"
name := "scala-xoroshiro128"
scalaVersion := "2.11.8"
scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/releases"
libraryDependencies ++= Seq(
  // Disambiguation.
  "org.scala-lang" % "scala-reflect" % "2.11.8",
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.4",
  "org.scala-lang.modules" %% "scala-xml" % "1.0.4",

  // Scalameter for speed testing.
  "com.storm-enroute" %% "scalameter-core" % "0.7"
)

mainClass in Compile := Some("Benchmark")
