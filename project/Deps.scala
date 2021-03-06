
import sbt._
import sbt.Def.setting
import sbt.Keys.scalaVersion

object Deps {

  object Versions {
    def ammonite = "1.6.3"
  }

  def ammoniteRepl = ("com.lihaoyi" % "ammonite-repl" % Versions.ammonite).cross(CrossVersion.full)
  def ammoniteSpark = "sh.almond" %% "ammonite-spark" % "0.3.0"
  def argonautShapeless = "com.github.alexarchambault" %% "argonaut-shapeless_6.2" % "1.2.0-M9"
  def caseAppAnnotations = "com.github.alexarchambault" %% "case-app-annotations" % "2.0.0-M5"
  def caseApp = "com.github.alexarchambault" %% "case-app" % "2.0.0-M5"
  def directories = "io.github.soc" % "directories" % "11"
  def fs2 = "co.fs2" %% "fs2-core" % "1.0.3"
  def jeromq = "org.zeromq" % "jeromq" % "0.5.0"
  def jvmRepr = "com.github.jupyter" % "jvm-repr" % "0.4.0"
  def metabrowseServer = "org.scalameta" %% "metabrowse-server" % "0.2.2"
  def scalaReflect = setting("org.scala-lang" % "scala-reflect" % scalaVersion.value)
  def scalaRx = "com.lihaoyi" %% "scalarx" % "0.4.0"
  def scalatags = "com.lihaoyi" %% "scalatags" % "0.6.7"
  def slf4jNop = "org.slf4j" % "slf4j-nop" % "1.7.26"

  def sparkSql20 = "org.apache.spark" %% "spark-sql" % "2.0.2" // no need to bump that version much, to ensure we don't rely on too new stuff
  def sparkSql24 = "org.apache.spark" %% "spark-sql" % "2.4.0" // that version's required for scala 2.12
  def sparkSql = setting {
    if (Settings.isAtLeast212.value)
      sparkSql24
    else
      sparkSql20
  }

  def utest = "com.lihaoyi" %% "utest" % "0.6.6"

}
