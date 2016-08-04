import java.lang.Long.rotateLeft

class xoroshiro128(private var seedLo : Long, private var seedHi : Long) {
  // TODO: Default constructor could be a lot better.
  // From the original implementation:
  // The state must be seeded so that it is not everywhere zero. If you have
  // a 64-bit seed, we suggest to seed a splitmix64 generator and use its
  // output to fill s.
  def this() = this(0, java.time.ZonedDateTime.now().toEpochSecond)

  def this(seed : Array[Long]) = this(seed(0), seed(1))

  def nextLong() : Long = {
    val s0     : Long = seedLo
    val result : Long = s0 + seedHi
    val s1     : Long = seedHi ^ s0

    seedLo = rotateLeft(s0, 55) ^ s1 ^ (s1 << 14)
    seedHi = rotateLeft(s1, 36)

    result
  }

  def nextBoolean() : Boolean = nextLong >= 0
}
