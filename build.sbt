name := "scala"

version := "0.98.5"

scalaVersion := "2.10.2"

crossScalaVersions := Seq("2.10.2", "2.10.3")

libraryDependencies ++= Seq(
  "junit"                      % "junit"                   % "4.5",
  "org.scalatest"              % "scalatest_2.10"          % "2.2.0",
  //"org.scalatest"              % "scalatest_2.11"          % "2.2.0-RC2",
  //"org.scalatest"              %% "scalatest"              % "2.1.6"            % "test",
  "com.github.mauricio"        % "postgresql-async_2.10"   % "0.2.12"
  //"com.github.mauricio"        %% "postgresql-async"       % "0.2.6"
)

testOptions in Test <+= (target in Test) map {
  t => Tests.Argument(TestFrameworks.ScalaTest, "junitxml(directory=\"%s\")" format (t / "../shippable/testresults"))
}

instrumentSettings

ScoverageKeys.minimumCoverage := 70

ScoverageKeys.failOnMinimumCoverage := false

ScoverageKeys.highlighting := {
  if (scalaBinaryVersion.value == "2.10") false
  else false
}
