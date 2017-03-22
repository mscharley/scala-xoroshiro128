import com.mscharley.random._

// scalastyle:off
trait Benchmark {
  val ITERATIONS = 1000000
  val BENCHES = 100
  val SMALL_BYTE_COUNT = 16
  val LARGE_BYTE_COUNT = 4096

  val measurer: Measurer

  def main(args: Array[String]): Unit = {
    println(s"Benchmarking ${ITERATIONS * 8} bytes of data x$BENCHES:")
    println("")

    val scalaRand = new scala.util.Random()
    val javaRand  = new java.util.Random()
    val xoroRand  = Xoroshiro128()

    val timeScalaLong = measurer measure {
      var i = 0; while (i < ITERATIONS) { scalaRand.nextLong(); i += 1 }
    }
    val timeXoroLong = measurer measure {
      var i = 0; while (i < ITERATIONS) { xoroRand.nextLong(); i += 1 }
    }
    val longImprovement = (1 - timeXoroLong / timeScalaLong) * 100
    println(s"Long:     s.u.Random - $timeScalaLong ms, xoroshiro128 - $timeXoroLong ms; $longImprovement% improvement")

    val timeScalaInt = measurer measure {
      var i = 0; while (i < ITERATIONS * 2) { scalaRand.nextInt(); i += 1 }
    }
    val timeXoroInt = measurer measure {
      var i = 0; while (i < ITERATIONS * 2) { xoroRand.nextInt(); i += 1 }
    }
    val intImprovement = (1 - timeXoroInt / timeScalaInt) * 100
    println(s"Int:      s.u.Random - $timeScalaInt ms, xoroshiro128 - $timeXoroInt ms; $intImprovement% improvement")

    val timeScalaShort = measurer measure {
      var i = 0; while (i < ITERATIONS * 4) { scalaRand.nextInt().toShort; i += 1 }
    }
    val timeXoroShort = measurer measure {
      var i = 0; while (i < ITERATIONS * 4) { xoroRand.nextShort(); i += 1 }
    }
    val shortImprovement = (1 - timeXoroShort / timeScalaShort) * 100
    println(s"Short:    s.u.Random - $timeScalaShort ms, xoroshiro128 - $timeXoroShort ms; $shortImprovement% improvement")

    val timeScalaBytes = measurer measure {
      var i = 0
      val l = ITERATIONS / 16 * 8
      while (i < l) {
        val b = Array.ofDim[Byte](SMALL_BYTE_COUNT)
        scalaRand.nextBytes(b)
        i += 1
      }
    }
    val timeXoroBytes = measurer measure {
      var i = 0
      val l = ITERATIONS / 16 * 8
      while (i < l) {
        val b = Array.ofDim[Byte](SMALL_BYTE_COUNT)
        xoroRand.nextBytes(b)
        i += 1
      }
    }
    val bytesImprovement = (1 - timeXoroBytes / timeScalaBytes) * 100
    println(s"Bytes(s): s.u.Random - $timeScalaBytes ms, xoroshiro128 - $timeXoroBytes ms; $bytesImprovement% improvement")

    val timeScalaBytesBig = measurer measure {
      var i = 0
      val l = ITERATIONS / 4096 * 8
      while (i < l) {
        val b = Array.ofDim[Byte](LARGE_BYTE_COUNT)
        scalaRand.nextBytes(b)
        i += 1
      }
    }
    val timeXoroBytesBig = measurer measure {
      var i = 0
      val l = ITERATIONS / 4096 * 8
      while (i < l) {
        val b = Array.ofDim[Byte](LARGE_BYTE_COUNT)
        xoroRand.nextBytes(b)
        i += 1
      }
    }
    val bytesBigImprovement = (1 - timeXoroBytesBig / timeScalaBytesBig) * 100
    println(s"Bytes(l): s.u.Random - $timeScalaBytesBig ms, xoroshiro128 - $timeXoroBytesBig ms; $bytesBigImprovement% improvement")

    val timeScalaBytesSingle = measurer measure {
      val b = Array.ofDim[Byte](ITERATIONS * 8)
      scalaRand.nextBytes(b)
    }
    val timeXoroBytesSingle = measurer measure {
      val b = Array.ofDim[Byte](ITERATIONS * 8)
      xoroRand.nextBytes(b)
    }
    val bytesSingleImprovement = (1 - timeXoroBytesSingle / timeScalaBytesSingle) * 100
    println(s"Bytes:    s.u.Random - $timeScalaBytesSingle ms, xoroshiro128 - $timeXoroBytesSingle ms; $bytesSingleImprovement% improvement")

    val timeScalaBool = measurer measure {
      var i = 0; while (i < ITERATIONS * 8) { scalaRand.nextBoolean(); i += 1 }
    }
    val timeXoroBool = measurer measure {
      var i = 0; while (i < ITERATIONS * 8) { xoroRand.nextBoolean(); i += 1 }
    }
    val boolImprovement = (1 - timeXoroBool / timeScalaBool) * 100
    println(s"Boolean:  s.u.Random - $timeScalaBool ms, xoroshiro128 - $timeXoroBool ms; $boolImprovement% improvement")
  }
}
