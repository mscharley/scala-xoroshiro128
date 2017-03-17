import com.typesafe.sbt.pgp.PgpKeys._
import sbtcrossproject.{CrossType, crossProject}

lazy val commonSettings = Seq(
  organization := "com.mscharley",
  version := "0.2.0-SNAPSHOT",
  scalaVersion := "2.11.8",
  scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature", "-Xlint")
)

lazy val testingSettings = Seq(
  libraryDependencies ++= Seq(
    // Testing libraries.
    "org.scalatest" %%% "scalatest" % "3.0.1" % "test"
  )
)

lazy val xoroshiro128 =
  crossProject(JVMPlatform, JSPlatform, NativePlatform)
    .crossType(CrossType.Full)
    .settings(
      commonSettings,
      name := "xoroshiro128"
    )
    .jvmSettings(testingSettings)
    .jsSettings(testingSettings)

lazy val xoroshiro128JVM    = xoroshiro128.jvm
lazy val xoroshiro128JS     = xoroshiro128.js
lazy val xoroshiro128Native = xoroshiro128.native

lazy val benchmark =
  crossProject(JVMPlatform, JSPlatform, NativePlatform)
    .crossType(CrossType.Full)
    .settings(
      commonSettings,
      name := "xoroshiro128-benchmark",
      mainClass in Compile := Some("Benchmark")
    )
    .jsSettings(
      mainClass in Compile := Some("JsBenchmark")
    )
    .nativeSettings(
      mainClass in Compile := Some("NativeBenchmark")
    )
    .jvmSettings(
      mainClass in Compile := Some("JvmBenchmark"),

      // Scalameter for speed testing.
      resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/releases",
      libraryDependencies += "com.storm-enroute" %% "scalameter-core" % "0.7"
    )
    .dependsOn(xoroshiro128)

lazy val benchmarkJVM    = benchmark.jvm
lazy val benchmarkJS     = benchmark.js
lazy val benchmarkNative = benchmark.native

lazy val `scala-xoroshiro128` =
  (project in file("."))
    .settings(commonSettings, publish := {}, publishSigned := {})
    .aggregate(xoroshiro128JVM, xoroshiro128JS, xoroshiro128Native)
