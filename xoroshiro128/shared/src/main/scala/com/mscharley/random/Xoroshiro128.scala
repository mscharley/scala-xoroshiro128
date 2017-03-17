package com.mscharley
package random

import java.lang.Long.{rotateLeft, signum => signLong}

import scala.collection.AbstractIterator

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

class Xoroshiro128 private(private var seedLo : Long, private var seedHi : Long) extends AbstractIterator[Long] {
  self =>

  override def hasNext : Boolean = true
  override def next() : Long = {
    val result : Long = seedLo + seedHi
    val s1     : Long = seedHi ^ seedLo

    seedLo = rotateLeft(seedLo, 55) ^ s1 ^ (s1 << 14)
    seedHi = rotateLeft(s1, 36)

    result
  }

  def asInt : Iterator[Int] = new AbstractIterator[Int] {
    private var intProgress : Long = 0

    override def hasNext : Boolean = self.hasNext
    override def next() : Int = {
      if (intProgress == 0) { intProgress = self.next() }

      val result : Int = (intProgress & 0xffffffff).toInt
      intProgress = intProgress >>> 32

      result
    }
  }

  private var byteProgress : Long = 0
  protected def nextByte() : Byte = {
    if (byteProgress == 0) { byteProgress = next() }

    val result : Byte = (byteProgress & 0xff).toByte
    byteProgress = byteProgress >>> 8

    result
  }

  def nextBytes(bytes : Array[Byte]) : Unit =
    for (i <- bytes.indices) { bytes(i) = nextByte() }

  def asByte : Iterator[Byte] = new AbstractIterator[Byte] {
    override def hasNext: Boolean = self.hasNext
    override def next(): Byte = self.nextByte()
  }

  def asBoolean : Iterator[Boolean] = new AbstractIterator[Boolean] {
    override def hasNext: Boolean = self.hasNext
    override def next(): Boolean = signLong(self.next()) == 1
  }
}
