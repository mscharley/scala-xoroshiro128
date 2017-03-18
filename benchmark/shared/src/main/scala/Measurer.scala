
trait Measurer {
  /** Benchmark a function.
    *
    * @param v the function to benchmark.
    * @return Time taken in fractional milliseconds.
    */
  def measure[V](v: =>V): Double
}
