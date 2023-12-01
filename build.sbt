name := "LotsOfNamesApi"

fork := true
javaOptions in test ++= Seq(
  "-Xms512M",
  "-Xmx2048M",
  "-XX:MaxPermSize=2048M",
  "-XX:+CMSClassUnloadingEnabled"
)

parallelExecution in test := false

version := "1.0"

scalaVersion := "2.12.18"
val akkaVersion = "2.8.5"
val akkaHttpVersion = "10.1.8"
val swaggerVersion = "2.0.8"

libraryDependencies ++=
  Seq(
    "ch.megard" %% "akka-http-cors" % "0.4.3",
    "ch.qos.logback" % "logback-classic" % "1.2.3",
    "com.typesafe" % "config" % "1.4.3",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
    "tech.navicore" %% "lotsofnames" % "3.0.6",
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-stream" % akkaVersion,
    "com.typesafe.akka" %% "akka-cluster" % akkaVersion,
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
    "org.json4s" %% "json4s-native" % "3.6.12",
    "com.github.nscala-time" %% "nscala-time" % "2.32.0",
    "org.scalatest" %% "scalatest" % "3.0.5" % "test"
  )

dependencyOverrides ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion
)

mainClass in assembly := Some("tech.navicore.lotsofnames.api.Main")
assemblyJarName in assembly := "LotsOfNamesApi.jar"
