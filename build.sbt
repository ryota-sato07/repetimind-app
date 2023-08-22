name := """scala-play-angular-seed"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala).settings(
  watchSources ++= (baseDirectory.value / "ui/src" ** "*").get
)

resolvers += Resolver.sonatypeRepo("snapshots")

scalaVersion := "2.13.11"

libraryDependencies ++= Seq(
  "mysql"                   % "mysql-connector-java"  % "6.0.6",
  "com.typesafe.play"      %% "play-slick"            % "5.0.0",
  "com.typesafe.play"      %% "play-slick-evolutions" % "5.0.0",
  "org.scalatestplus.play" %% "scalatestplus-play"    % "5.1.0" % Test,
  ws, guice
)
