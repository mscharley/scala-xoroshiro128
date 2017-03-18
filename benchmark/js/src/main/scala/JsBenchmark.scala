import scala.scalajs.js.JSApp

object JsBenchmark extends Benchmark with JSApp {
  val measurer : Measurer = new SimpleMeasurer(BENCHES)

  override def main(): Unit = main(Array())
}
