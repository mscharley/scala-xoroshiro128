
class SimpleMeasurer(benches: Int) extends Measurer {
  override def measure[V](v: => V): Double = {
    val f = () => v

    ???
  }
}
