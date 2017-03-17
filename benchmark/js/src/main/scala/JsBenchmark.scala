

// scalastyle:off
object JsBenchmark extends Benchmark {
  private val sm =
    config(
      Key.exec.benchRuns -> BENCHES
    ) withWarmer {
      new Warmer.Default
    } withMeasurer {
      new Measurer.IgnoringGC
    }

  val measurer : Measurer = new Measurer {
    override def measure[V](v: =>V): Double =
      sm.measure(v).value
  }
}
