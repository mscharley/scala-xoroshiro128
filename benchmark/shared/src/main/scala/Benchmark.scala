import com.mscharley.random._

// scalastyle:off
trait Benchmark {
  val ITERATIONS = 1000000
  val BENCHES = 100
  val SMALL_BYTE_COUNT = 16
  val LARGE_BYTE_COUNT = 4096

  val measurer: Measurer

  def main(args: Array[String]): Unit = {
    println(s"Benchmarking $ITERATIONS iterations x$BENCHES:")
    println("")

    val scalaRand = new java.util.Random
    val xoroRand = Xoroshiro128()
    val xoroIntRand = Xoroshiro128().asInt
    val xoroBoolRand = Xoroshiro128().asBoolean

    val timeJavaLong = measurer measure {
      for (i <- 0 until ITERATIONS) yield scalaRand.nextLong()
    }
    val timeXoroLong = measurer measure {
      for (i <- 0 until ITERATIONS) yield xoroRand.next()
    }
    val longImprovement = (1 - timeXoroLong / timeJavaLong) * 100
    println(s"Long:     java.util.Random - $timeJavaLong ms, xoroshiro128 - $timeXoroLong ms; $longImprovement% improvement")

    val timeJavaInt = measurer measure {
      for (i <- 0 until ITERATIONS) yield scalaRand.nextInt()
    }
    val timeXoroInt = measurer measure {
      for (i <- 0 until ITERATIONS) yield xoroIntRand.next()
    }
    val intImprovement = (1 - timeXoroInt / timeJavaInt) * 100
    println(s"Int:      java.util.Random - $timeJavaInt ms, xoroshiro128 - $timeXoroInt ms; $intImprovement% improvement")

    val timeJavaBytes = measurer measure {
      for (i <- 0 until ITERATIONS / 16) yield {
        val b = Array.ofDim[Byte](SMALL_BYTE_COUNT)
        scalaRand.nextBytes(b)
      }
    }
    val timeXoroBytes = measurer measure {
      for (i <- 0 until ITERATIONS / 16) yield {
        val b = Array.ofDim[Byte](SMALL_BYTE_COUNT)
        xoroRand.nextBytes(b)
      }
    }
    val bytesImprovement = (1 - timeXoroBytes / timeJavaBytes) * 100
    println(s"Bytes(s): java.util.Random - $timeJavaBytes ms, xoroshiro128 - $timeXoroBytes ms; $bytesImprovement% improvement")

    val timeJavaBytesBig = measurer measure {
      for (i <- 0 until ITERATIONS / 4096) yield {
        val b = Array.ofDim[Byte](LARGE_BYTE_COUNT)
        scalaRand.nextBytes(b)
      }
    }
    val timeXoroBytesBig = measurer measure {
      for (i <- 0 until ITERATIONS / 4096) yield {
        val b = Array.ofDim[Byte](LARGE_BYTE_COUNT)
        xoroRand.nextBytes(b)
      }
    }
    val bytesBigImprovement = (1 - timeXoroBytesBig / timeJavaBytesBig) * 100
    println(s"Bytes(l): java.util.Random - $timeJavaBytesBig ms, xoroshiro128 - $timeXoroBytesBig ms; $bytesBigImprovement% improvement")

    val timeJavaBytesSingle = measurer measure {
      val b = Array.ofDim[Byte](ITERATIONS)
      scalaRand.nextBytes(b)
    }
    val timeXoroBytesSingle = measurer measure {
      val b = Array.ofDim[Byte](ITERATIONS)
      xoroRand.nextBytes(b)
    }
    val bytesSingleImprovement = (1 - timeXoroBytesSingle / timeJavaBytesSingle) * 100
    println(s"Bytes:    java.util.Random - $timeJavaBytesSingle ms, xoroshiro128 - $timeXoroBytesSingle ms; $bytesSingleImprovement% improvement")

    val timeJavaBool = measurer measure {
      for (i <- 0 until ITERATIONS) yield scalaRand.nextBoolean()
    }
    val timeXoroBool = measurer measure {
      for (i <- 0 until ITERATIONS) yield xoroBoolRand.next()
    }
    val boolImprovement = (1 - timeXoroBool / timeJavaBool) * 100
    println(s"Boolean:  java.util.Random - $timeJavaBool ms, xoroshiro128 - $timeXoroBool ms; $boolImprovement% improvement")
  }
}
