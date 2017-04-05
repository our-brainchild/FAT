name := """FAT"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "5.2.9.Final",
  "org.postgresql" % "postgresql" % "9.3-1102-jdbc4",
  "org.liquibase" % "liquibase-core" % "3.5.3",
  "dom4j" % "dom4j" % "1.6.1"
)