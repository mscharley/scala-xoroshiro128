
class SimpleMeasurer(benches: Int) extends Measurer {
  override def measure[V](v: => V): Double = {
    val f = () => v

    val timings: Seq[Double] = Range(0, benches) map { _ =>
      val start = System.nanoTime()
      f()
      (System.nanoTime() - start) / 1000000.0
    }
    timings.sum / benches
  }
}
