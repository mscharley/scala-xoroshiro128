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

  private var remainingBytes : Int = 0
  private var remaining : Long = _

  @inline
  private def generate(): Unit = {
    remaining = seedLo + seedHi
    val s1 : Long = seedHi ^ seedLo

    // scalastyle:off magic.number
    seedLo = ((seedLo << 55) | (seedLo >>> -55)) ^ s1 ^ (s1 << 14)
    seedHi = (s1 << 36) | (s1 >>> -36)
    remainingBytes = 8
    // scalastyle:on magic.number
  }

  def nextLong() : Long = {
    generate()
    remainingBytes = 0
    remaining
  }

  def nextInt() : Int = {
    if (remainingBytes < 4) { generate() }

    remainingBytes -= 4
    val result : Int = remaining.toInt
    remaining = remaining >>> 32

    result
  }

  def nextShort() : Short = {
    if (remainingBytes < 2) { generate() }

    remainingBytes -= 2
    val result : Short = remaining.toShort
    remaining = remaining >>> 16

    result
  }

  def nextByte() : Byte = {
    if (remainingBytes < 1) { generate() }

    remainingBytes -= 1
    val result : Byte = remaining.toByte
    remaining = remaining >>> 32

    result
  }

  def nextBytes(bytes : Array[Byte]) : Unit = {
    var i = 0
    val l = bytes.length
    while (i < l) {
      bytes(i) = nextByte()
      i += 1
    }
  }

  def nextBoolean(): Boolean = {
    generate()
    remainingBytes = 0
    signLong(remaining) == 1
  }
}
