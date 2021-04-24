ThisBuild / scalaVersion     := "2.13.3"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "sets"

lazy val root = (project in file("."))
  .settings(name := "Enum Benchmarks")
  .enablePlugins(JmhPlugin)

