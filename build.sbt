name := "LotsOfNamesApi"

fork := true
(test / javaOptions) ++= Seq(
  "-Xms512M",
  "-Xmx2048M",
  "-XX:MaxPermSize=2048M",
  "-XX:+CMSClassUnloadingEnabled"
)

(test / parallelExecution) := false

version := "1.0"

scalaVersion := "2.12.17"
val akkaVersion = "2.6.20"
val akkaHttpVersion = "10.5.2"
val swaggerVersion = "2.0.8"

libraryDependencies ++=
  Seq(
    "tech.navicore" %% "lotsofnames" % "3.0.4",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
    "com.typesafe" % "config" % "1.4.2",
    "ch.qos.logback" % "logback-classic" % "1.4.7",
    "ch.megard" %% "akka-http-cors" % "1.2.0",
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-stream" % akkaVersion,
    "com.typesafe.akka" %% "akka-cluster" % akkaVersion,
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
    "org.json4s" %% "json4s-native" % "4.0.6",
    "org.json4s" %% "json4s-native" % "4.0.6",
    "com.github.nscala-time" %% "nscala-time" % "2.32.0",
    "org.scalatest" %% "scalatest" % "3.2.15" % "test"
  )

dependencyOverrides ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion
)

(assembly / mainClass) := Some("tech.navicore.lotsofnames.api.Main")
(assembly / assemblyJarName) := "LotsOfNamesApi.jar"

(assembly / assemblyMergeStrategy) := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x                             => MergeStrategy.first
}
