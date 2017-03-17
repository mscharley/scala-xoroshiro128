// Cross-building dependencies.
addSbtPlugin("org.scala-js"     % "sbt-scalajs"              % "0.6.14")
addSbtPlugin("org.scala-native" % "sbt-crossproject"         % "0.1.0")
addSbtPlugin("org.scala-native" % "sbt-scalajs-crossproject" % "0.1.0")
addSbtPlugin("org.scala-native" % "sbt-scala-native"         % "0.1.0")

// Other assorted goodies.
addSbtPlugin("org.scalastyle"  %% "scalastyle-sbt-plugin"    % "0.8.0")
