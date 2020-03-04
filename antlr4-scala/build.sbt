import Dependencies._

ThisBuild / scalaVersion     := "2.13.1"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.dataflowstudio"
ThisBuild / organizationName := "dataflowstudio"

lazy val root = (project in file("."))
  .settings(
    name := "antlr4-scala",
    libraryDependencies += scalaTest % Test
  )
  .enablePlugins(Antlr4Plugin)
  .settings(
    antlr4Version in Antlr4 := "4.7.2",
    antlr4PackageName in Antlr4 := Some("com.dataflowstudio"),
    antlr4GenListener in Antlr4 := true,
    antlr4GenVisitor in Antlr4 := true
  )


// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
