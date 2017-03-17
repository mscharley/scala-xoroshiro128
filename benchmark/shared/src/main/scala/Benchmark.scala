import com.mscharley.random._

// scalastyle:off
object Benchmark {
  val ITERATIONS = 100000
  val BENCHES = 1000
  val SMALL_BYTE_COUNT = 16
  val LARGE_BYTE_COUNT = 4096

  def main(args: Array[String]): Unit = {
    println(s"Benchmarking $ITERATIONS iterations x$BENCHES:")
    println("")

    val scalaRand = new java.util.Random
    val xoroRand = Xoroshiro128()
    val xoroIntRand = Xoroshiro128().asInt
    val xoroBoolRand = Xoroshiro128().asBoolean

//    val timeJavaLong = measurer measure {
//      for (i <- 0 until ITERATIONS) yield scalaRand.nextLong()
//    }
//    val timeXoroLong = measurer measure {
//      for (i <- 0 until ITERATIONS) yield xoroRand.next()
//    }
//    //  val timeXoroLong = measurer measure { xoroRand.take(ITERATIONS).toIndexedSeq }
//    val longImprovement = (1 - timeXoroLong.value / timeJavaLong.value) * 100
//    println(s"Long:     java.util.Random - $timeJavaLong, xoroshiro128 - $timeXoroLong; $longImprovement% improvement")
//
//    val timeJavaInt = measurer measure {
//      for (i <- 0 until ITERATIONS) yield scalaRand.nextInt()
//    }
//    val timeXoroInt = measurer measure {
//      for (i <- 0 until ITERATIONS) yield xoroIntRand.next()
//    }
//    //  val timeXoroInt = measurer measure { xoroIntRand.take(ITERATIONS).toIndexedSeq }
//    val intImprovement = (1 - timeXoroInt.value / timeJavaInt.value) * 100
//    println(s"Int:      java.util.Random - $timeJavaInt, xoroshiro128 - $timeXoroInt; $intImprovement% improvement")
//
//    val timeJavaBytes = measurer measure {
//      for (i <- 0 until ITERATIONS / 16) yield {
//        val b = Array.ofDim[Byte](SMALL_BYTE_COUNT)
//        scalaRand.nextBytes(b)
//      }
//    }
//    val timeXoroBytes = measurer measure {
//      for (i <- 0 until ITERATIONS / 16) yield {
//        val b = Array.ofDim[Byte](SMALL_BYTE_COUNT)
//        xoroRand.nextBytes(b)
//      }
//    }
//    val bytesImprovement = (1 - timeXoroBytes.value / timeJavaBytes.value) * 100
//    println(s"Bytes(s): java.util.Random - $timeJavaBytes, xoroshiro128 - $timeXoroBytes; $bytesImprovement% improvement")
//
//    val timeJavaBytesBig = measurer measure {
//      for (i <- 0 until ITERATIONS / 4096) yield {
//        val b = Array.ofDim[Byte](LARGE_BYTE_COUNT)
//        scalaRand.nextBytes(b)
//      }
//    }
//    val timeXoroBytesBig = measurer measure {
//      for (i <- 0 until ITERATIONS / 4096) yield {
//        val b = Array.ofDim[Byte](LARGE_BYTE_COUNT)
//        xoroRand.nextBytes(b)
//      }
//    }
//    val bytesBigImprovement = (1 - timeXoroBytesBig.value / timeJavaBytesBig.value) * 100
//    println(s"Bytes(l): java.util.Random - $timeJavaBytesBig, xoroshiro128 - $timeXoroBytesBig; $bytesBigImprovement% improvement")
//
//    val timeJavaBytesSingle = measurer measure {
//      val b = Array.ofDim[Byte](ITERATIONS)
//      scalaRand.nextBytes(b)
//    }
//    val timeXoroBytesSingle = measurer measure {
//      val b = Array.ofDim[Byte](ITERATIONS)
//      xoroRand.nextBytes(b)
//    }
//    val bytesSingleImprovement = (1 - timeXoroBytesSingle.value / timeJavaBytesSingle.value) * 100
//    println(s"Bytes:    java.util.Random - $timeJavaBytesSingle, xoroshiro128 - $timeXoroBytesSingle; $bytesSingleImprovement% improvement")
//
//    val timeJavaBool = measurer measure {
//      for (i <- 0 until ITERATIONS) yield scalaRand.nextBoolean()
//    }
//    val timeXoroBool = measurer measure {
//      for (i <- 0 until ITERATIONS) yield xoroBoolRand.next()
//    }
//    //  val timeXoroBool = measurer measure { xoroBoolRand.take(ITERATIONS).toIndexedSeq }
//    val boolImprovement = (1 - timeXoroBool.value / timeJavaBool.value) * 100
//    println(s"Boolean:  java.util.Random - $timeJavaBool, xoroshiro128 - $timeXoroBool; $boolImprovement% improvement")
  }
}