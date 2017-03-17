
trait Measurer {
  /** Benchmark a function.
    *
    * @param v the function to benchmark.
    * @return Time taken in fractional seconds.
    */
  def measure[V](v: =>V): Double
}
