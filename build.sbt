import sbt.Keys._
import sbt._
import sbtrelease.Version

name := "hello"

resolvers += Resolver.sonatypeRepo("public")
scalaVersion := "2.12.2"
releaseNextVersion := { ver => Version(ver).map(_.bumpMinor.string).getOrElse("Error") }
assemblyJarName in assembly := "hello.jar"
dependencyOverrides += "org.scala-lang" % "scala-compiler" % scalaVersion.value

libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.1.3",
  "com.amazonaws" % "aws-lambda-java-events" % "2.0.1",
  "com.amazonaws" % "aws-lambda-java-core" % "1.1.0",
  "com.amazonaws" % "aws-lambda-java-log4j" % "1.0.0",
  "org.scalatest" %% "scalatest" % "3.0.4" % "test"
)

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-feature",
  "-Xfatal-warnings")