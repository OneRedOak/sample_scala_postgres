name := "scala"

version := "0.99.5"

scalaVersion := "2.11.0"

crossScalaVersions := Seq("2.11.0", "2.10.3")

libraryDependencies ++= Seq(
  "junit"                      % "junit"                   % "4.5",
  "org.scalatest"              % "scalatest_2.11"          % "2.2.0-RC2",
  "org.scalatest"              %% "scalatest"              % "2.1.6"            % "test",
  "org.mongodb"                % "casbah_2.11"             % "2.7.1"
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
