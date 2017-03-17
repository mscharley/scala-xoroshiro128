publishMavenStyle := true
publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}
sonatypeProfileName := "com.mscharley"

pomExtra in Global := {
  <url>https://github.com/mscharley/scala-xoroshiro128</url>
    <licenses>
      <license>
        <name>CC0</name>
        <url>http://creativecommons.org/publicdomain/zero/1.0/</url>
      </license>
    </licenses>
    <scm>
      <connection>scm:git:github.com/mscharley/scala-xoroshiro128</connection>
      <developerConnection>scm:git:git@github.com:mscharley/scala-xoroshiro128</developerConnection>
      <url>github.com/mscharley/scala-xoroshiro128</url>
    </scm>
    <developers>
      <developer>
        <id>mscharley</id>
        <name>Matthew Scharley</name>
        <url>https://github.com/mscharley</url>
      </developer>
    </developers>
}
