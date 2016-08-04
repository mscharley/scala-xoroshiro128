import java.lang.Long.{rotateLeft, signum => signLong}

class xoroshiro128(private var seedLo : Long, private var seedHi : Long) {
  // TODO: Default constructor could be a lot better.
  // From the original implementation:
  // The state must be seeded so that it is not everywhere zero. If you have
  // a 64-bit seed, we suggest to seed a splitmix64 generator and use its
  // output to fill the seed.
  def this() = this(0, java.time.ZonedDateTime.now().toEpochSecond)

  def this(seed : Array[Long]) = this(seed(0), seed(1))

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
    intProgress = intProgress >> 32

    result
  }

  private var byteProgress : Long = 0
  def nextByte() : Byte = {
    if (byteProgress == 0) { byteProgress = nextLong() }

    val result : Byte = (byteProgress & 0xff).toByte
    byteProgress = byteProgress >> 8

    result
  }

  def nextBytes(bytes : Array[Byte]) : Unit =
    for (i <- bytes.indices) { bytes(i) = nextByte() }

  def nextBoolean() : Boolean = signLong(nextLong()) == 1
}
