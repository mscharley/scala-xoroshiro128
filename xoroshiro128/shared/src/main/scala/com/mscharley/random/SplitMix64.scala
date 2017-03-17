package com.mscharley
package random

object SplitMix64 {
  def apply() : SplitMix64 = apply(java.time.ZonedDateTime.now().toEpochSecond)
  def apply(seed : Long) : SplitMix64 = new SplitMix64(seed)
}

class SplitMix64 private(private var seed : Long) extends Iterator[Long] {
  override def hasNext: Boolean = true

  override def next(): Long = {
    seed += 0x9E3779B97F4A7C15L
    var z = (seed ^ (seed >>> 30)) * 0xBF58476D1CE4E5B9L
    z = (z ^ (z >>> 27)) * 0x94D049BB133111EBL
    z ^ (z >>> 31)
  }
}
