
object splitmix64 {
  def apply() : splitmix64 = new splitmix64(java.time.ZonedDateTime.now().toEpochSecond)
  def apply(seed : Long) = new splitmix64(seed)
}

class splitmix64 private (private var seed : Long) extends Iterator[Long] {
  override def hasNext: Boolean = true

  override def next(): Long = {
    seed += 0x9E3779B97F4A7C15L
    var z = (seed ^ (seed >>> 30)) * 0xBF58476D1CE4E5B9L
    z = (z ^ (z >>> 27)) * 0x94D049BB133111EBL
    z ^ (z >>> 31)
  }
}
