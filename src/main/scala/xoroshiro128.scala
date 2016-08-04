import java.lang.Long.{rotateLeft, signum => signLong}

object xoroshiro128 {
  def apply(seedLo : Long, seedHi : Long) : xoroshiro128 = new xoroshiro128(seedLo, seedHi)
  def apply(seed : Array[Long]) = new xoroshiro128(seed(0), seed(1))
  def apply(seed : Long) = {
    val r = splitmix64(seed)
    new xoroshiro128(r.nextLong(), r.nextLong())
  }
  def apply() = {
    val r = splitmix64()
    new xoroshiro128(r.nextLong(), r.nextLong())
  }
}

class xoroshiro128 private (private var seedLo : Long, private var seedHi : Long) {
  def nextLong() : Long = {
    val result : Long = seedLo + seedHi
    val s1     : Long = seedHi ^ seedLo

    seedLo = rotateLeft(seedLo, 55) ^ s1 ^ (s1 << 14)
    seedHi = rotateLeft(s1, 36)

    result
  }

  private var intProgress : Long = 0
  def nextInt() : Int = {
    if (intProgress == 0) { intProgress = nextLong() }

    val result : Int = (intProgress & 0xffffffff).toInt
    intProgress = intProgress >>> 32

    result
  }

  private var byteProgress : Long = 0
  def nextByte() : Byte = {
    if (byteProgress == 0) { byteProgress = nextLong() }

    val result : Byte = (byteProgress & 0xff).toByte
    byteProgress = byteProgress >>> 8

    result
  }

  def nextBytes(bytes : Array[Byte]) : Unit =
    for (i <- bytes.indices) { bytes(i) = nextByte() }

  def nextBoolean() : Boolean = signLong(nextLong()) == 1
}
