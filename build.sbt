lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """play-scala-starter-example""",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.13.10",
    libraryDependencies ++= Seq(
      guice,jdbc,ws,ehcache,
      "com.h2database" % "h2" % "1.4.200",
      "com.typesafe.akka" %% "akka-http" % "10.2.6",
      "com.typesafe.play" %% "play-ahc-ws-standalone" % "2.1.10",
      "com.typesafe.play" %% "play-slick" % "5.0.0",
      "com.typesafe.slick" %% "slick-codegen" % "3.3.3",
      "com.typesafe.slick" %% "slick-hikaricp" % "3.3.2",
      "com.typesafe.slick" %% "slick" % "3.3.3",
      "org.postgresql" % "postgresql" % "42.6.0",
      "org.mindrot" % "jbcrypt" % "0.4",
      "org.mockito" % "mockito-core" % "3.12.4" % Test,
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-Xfatal-warnings"
    ),
    Compile / javacOptions ++= Seq(
      "-source", "1.8",
      "-target", "1.8"
    ),
    Compile / herokuAppName := "luna-webapp"
  )
