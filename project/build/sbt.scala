import sbt._

class SalesTax(info: ProjectInfo) extends DefaultProject(info) {
   override def javaCompileOptions = super.javaCompileOptions ++ javaCompileOptions("-Xlint:unchecked") ++ javaCompileOptions("-Xlint:deprecation")
}
