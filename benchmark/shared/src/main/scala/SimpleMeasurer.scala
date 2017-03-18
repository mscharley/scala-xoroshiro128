import java.util.Date

class SimpleMeasurer(benches: Int) extends Measurer {
  override def measure[V](v: => V): Double = {
    val f = () => v

    val timings: Seq[Double] = Range(0, benches) map { _ =>
      val start = new Date()
      f()
      (new Date().getTime - start.getTime).toDouble
    }
    timings.sum / benches
  }
}
