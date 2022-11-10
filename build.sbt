import sbt.project
ThisBuild / version := "0.1.0"
ThisBuild / scalaVersion := "2.13.10"
ThisBuild / organization :="megallink"

val projectName = "TestSbtScala"

addCommandAlias("format",";project TestSbtScala ;scalafmtAll ;scalastyle")

val sparkVersion = "3.2.2"
val log4jVersion= "2.19.0"

lazy val commondDependencies = Seq(
  "org.apache.logging.log4j" % "log4j-core" % log4jVersion,
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-mllib" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "net.codingwell" %% "scala-guice" % "5.1.0",
  "com.crealytics" % "spark-excel_2.13" % "3.3.1_0.18.5"
)

lazy val overrides = Seq(
  "com.fasterxml,jackson.core" % "jackson-core" % "2.6.7",
  "com.fasterxml,jackson.core" % "jackson-databind" % "2.6.7",
  "com.fasterxml,jackson.core" % "jackson-module-scala" % "2.6.7.1",
)

lazy val root = (project in file("."))
  .settings(
    name := projectName,
    idePackagePrefix := Some("sbt.megallink"),
    libraryDependencies ++= commondDependencies,
    dependencyOverrides ++= overrides
  )

