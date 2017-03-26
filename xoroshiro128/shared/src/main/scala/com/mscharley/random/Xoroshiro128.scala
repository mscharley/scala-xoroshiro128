package com.mscharley
package random

object Xoroshiro128 {
  def apply(seedLo : Long, seedHi : Long) : Xoroshiro128 = new Xoroshiro128(seedLo, seedHi)
  def apply(seed : Array[Long]) : Xoroshiro128 = new Xoroshiro128(seed(0), seed(1))
  def apply(seed : Long) : Xoroshiro128 = {
    val r = SplitMix64(seed)
    new Xoroshiro128(r.next(), r.next())
  }
  def apply() : Xoroshiro128 = {
    val r = SplitMix64()
    new Xoroshiro128(r.next(), r.next())
  }
}

class Xoroshiro128 private(private var seedLo : Long, private var seedHi : Long) {
  import java.lang.Long.{signum => signLong}

  @inline
  private def generate(): Long = {
    val out = seedLo + seedHi
    val s1 : Long = seedHi ^ seedLo

    // scalastyle:off magic.number
    seedLo = ((seedLo << 55) | (seedLo >>> -55)) ^ s1 ^ (s1 << 14)
    seedHi = (s1 << 36) | (s1 >>> -36)
    // scalastyle:on magic.number
    out
  }

  def nextLong() : Long = generate()

  def nextInt() : Int =
    (generate() >>> 32).toInt

  def nextShort() : Short =
    (generate() >>> 48).toShort

  def nextByte() : Byte =
    (generate() >>> 56).toByte

  def nextBytes(bytes : Array[Byte]) : Unit = {
    var i = 0
    val l = bytes.length
    while (i < l) {
      bytes(i) = nextByte()
      i += 1
    }
  }

  def nextBoolean(): Boolean =
    signLong(generate()) == 1
}
