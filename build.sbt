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

scalaVersion := "2.12.16"
val akkaHttpVersion = "10.1.15"
val akkaVersion = "2.5.32"
val swaggerVersion = "2.0.8"

libraryDependencies ++=
  Seq(
    "tech.navicore" %% "lotsofnames" % "3.0.3",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
    "com.typesafe" % "config" % "1.3.4",
    "ch.qos.logback" % "logback-classic" % "1.2.11",
    "ch.megard" %% "akka-http-cors" % "1.1.3",
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-stream" % akkaVersion,
    "com.typesafe.akka" %% "akka-cluster" % akkaVersion,
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
    "org.json4s" %% "json4s-native" % "3.6.1",
    "org.json4s" %% "json4s-native" % "3.6.12",
    "com.github.nscala-time" %% "nscala-time" % "2.32.0",
    "org.scalatest" %% "scalatest" % "3.0.9" % "test"
  )

dependencyOverrides ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion
)

mainClass in assembly := Some("tech.navicore.lotsofnames.api.Main")
assemblyJarName in assembly := "LotsOfNamesApi.jar"
