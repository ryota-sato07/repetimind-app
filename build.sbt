name := """scala-play-angular-seed"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala).settings(
  watchSources ++= (baseDirectory.value / "ui/src" ** "*").get
)

resolvers += Resolver.sonatypeRepo("snapshots")

scalaVersion := "2.13.11"

libraryDependencies ++= Seq(

  // --[ Play ]-----------------------------------------------------------------
  "com.typesafe.play"      %% "play-slick"            % "5.0.0",
  "com.typesafe.play"      %% "play-slick-evolutions" % "5.0.0",
  "org.scalatestplus.play" %% "scalatestplus-play"    % "5.1.0" % Test,
  ws, guice,

  // --[ OSS ]------------------------------------------------------------------
  "mysql"         % "mysql-connector-java"  % "8.0.33",
  "com.chuusai"  %% "shapeless"             % "2.3.3",
  "com.beachape" %% "enumeratum"            % "1.6.1",

)
