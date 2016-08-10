
lazy val commonSettings = Seq(
  scalaVersion := "2.11.8",
  scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")
)

lazy val xoroshiro128 = (project in file(".")).
  settings(commonSettings : _*).
  settings(
    organization := "com.scharley",
    name := "xoroshiro128",

    libraryDependencies ++= Seq(
      // Disambiguation.
      "org.scala-lang" % "scala-reflect" % "2.11.8",
      "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.4",
      "org.scala-lang.modules" %% "scala-xml" % "1.0.4"
    )
  )

lazy val benchmark = (project in file("benchmark")).
  settings(commonSettings : _*).
  settings(
    mainClass in Compile := Some("Benchmark"),

    // Scalameter for speed testing.
    resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/releases",
    libraryDependencies += "com.storm-enroute" %% "scalameter-core" % "0.7"
  ).dependsOn(xoroshiro128)
