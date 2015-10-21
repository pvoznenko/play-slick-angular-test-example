name := """PlaySlickAngularBootstrapH2TestsExample"""

version := "0.1.4"

scalaVersion := "2.11.7"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

libraryDependencies ++= Seq(
  filters,ws,
  cache,
  // WebJars (i.e. client-side) dependencies
  "org.webjars" % "requirejs" % "2.1.20",
  "org.webjars" % "underscorejs" % "1.8.3",
  "org.webjars" % "jquery" % "2.1.4",
  "org.webjars" % "bootstrap" % "3.3.5" exclude("org.webjars", "jquery"),
  "org.webjars" % "angularjs" % "1.4.7" exclude("org.webjars", "jquery"),
  "org.webjars" % "angular-ui-bootstrap" % "0.14.0" exclude("org.webjars", "jquery"),
  "org.webjars" % "ng-table" % "0.3.3" exclude("org.webjars", "angularjs"),
  "org.scala-lang.modules" %% "scala-async" % "0.9.5",
  "joda-time" % "joda-time" % "2.8.2",
  // Database
  "com.typesafe.play" %% "play-slick" % "0.8.1",
  "mysql" % "mysql-connector-java" % "5.1.37",
  // test
  "org.scalatest" %% "scalatest" % "2.2.5" % "test",
  "com.h2database" % "h2" % "1.4.190" % "test"
)

scalacOptions ++= Seq(
  "-target:jvm-1.8",
  "-encoding", "UTF-8",
  "-deprecation", // warning and location for usages of deprecated APIs
  "-feature", // warning and location for usages of features that should be imported explicitly
  "-unchecked", // additional warnings where generated code depends on assumptions
  "-Xlint", // recommended additional warnings
  "-Ywarn-adapted-args", // Warn if an argument list is modified to match the receiver
  "-Ywarn-inaccessible",
  "-Ywarn-dead-code"
)
 
// Configure the steps of the asset pipeline (used in stage and dist tasks)
// rjs = RequireJS, uglifies, shrinks to one file, replaces WebJars with CDN
// digest = Adds hash to filename
// gzip = Zips all assets, Asset controller serves them automatically when client accepts them
pipelineStages := Seq(rjs, digest, gzip)

// RequireJS with sbt-rjs (https://github.com/sbt/sbt-rjs#sbt-rjs) 
RjsKeys.paths += ("jsRoutes" -> ("/jsroutes" -> "empty:"))

includeFilter in (Assets, LessKeys.less) := "*.less"

excludeFilter in (Assets, LessKeys.less) := "_*.less"
