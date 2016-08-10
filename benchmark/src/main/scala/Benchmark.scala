import com.mscharley.random._
import org.scalameter._

object Benchmark extends App {
  val ITERATIONS = 10000
  val BENCHES = 1000

  private val measurer = config(
    Key.exec.benchRuns -> BENCHES
  ) withWarmer {
    new Warmer.Default
  } withMeasurer {
    new Measurer.IgnoringGC
  }

  val scalaRand = new java.util.Random
  val xoroRand = xoroshiro128()
  val xoroIntRand = xoroshiro128().asInt
  val xoroBoolRand = xoroshiro128().asBoolean

  val timeJavaLong = measurer measure { for (i <- 0 until ITERATIONS) yield scalaRand.nextLong() }
  val timeXoroLong = measurer measure { for (i <- 0 until ITERATIONS) yield xoroRand.next() }
//  val timeXoroLong = measurer measure { xoroRand.take(ITERATIONS).toIndexedSeq }
  val longImprovement = (1 - timeXoroLong.value / timeJavaLong.value) * 100

  val timeJavaInt = measurer measure { for (i <- 0 until ITERATIONS) yield scalaRand.nextInt() }
  val timeXoroInt = measurer measure { for (i <- 0 until ITERATIONS) yield xoroIntRand.next() }
//  val timeXoroInt = measurer measure { xoroIntRand.take(ITERATIONS).toIndexedSeq }
  val intImprovement = (1 - timeXoroInt.value / timeJavaInt.value) * 100

  val timeJavaBytes = measurer measure { for (i <- 0 until ITERATIONS / 16) yield {
    val b = Array.ofDim[Byte](16)
    scalaRand.nextBytes(b)
  } }
  val timeXoroBytes = measurer measure { for (i <- 0 until ITERATIONS / 16) yield {
    val b = Array.ofDim[Byte](16)
    xoroRand.nextBytes(b)
  } }
  val bytesImprovement = (1 - timeXoroBytes.value / timeJavaBytes.value) * 100

  val timeJavaBytesBig = measurer measure { for (i <- 0 until ITERATIONS / 4096) yield {
    val b = Array.ofDim[Byte](4096)
    scalaRand.nextBytes(b)
  } }
  val timeXoroBytesBig = measurer measure { for (i <- 0 until ITERATIONS / 4096) yield {
    val b = Array.ofDim[Byte](4096)
    xoroRand.nextBytes(b)
  } }
  val bytesBigImprovement = (1 - timeXoroBytesBig.value / timeJavaBytesBig.value) * 100

  val timeJavaBytesSingle = measurer measure {
    val b = Array.ofDim[Byte](ITERATIONS)
    scalaRand.nextBytes(b)
  }
  val timeXoroBytesSingle = measurer measure {
    val b = Array.ofDim[Byte](ITERATIONS)
    xoroRand.nextBytes(b)
  }
  val bytesSingleImprovement = (1 - timeXoroBytesSingle.value / timeJavaBytesSingle.value) * 100

  val timeJavaBool = measurer measure { for (i <- 0 until ITERATIONS) yield scalaRand.nextBoolean() }
  val timeXoroBool = measurer measure { for (i <- 0 until ITERATIONS) yield xoroBoolRand.next() }
//  val timeXoroBool = measurer measure { xoroBoolRand.take(ITERATIONS).toIndexedSeq }
  val boolImprovement = (1 - timeXoroBool.value / timeJavaBool.value) * 100

  println(s"Benchmarked $ITERATIONS iterations x$BENCHES:")
  println("")
  println(s"Long:     java.util.Random - $timeJavaLong, xoroshiro128 - $timeXoroLong; $longImprovement% improvement")
  println(s"Int:      java.util.Random - $timeJavaInt, xoroshiro128 - $timeXoroInt; $intImprovement% improvement")
  println(s"Bytes(s): java.util.Random - $timeJavaBytes, xoroshiro128 - $timeXoroBytes; $bytesImprovement% improvement")
  println(s"Bytes(l): java.util.Random - $timeJavaBytesBig, xoroshiro128 - $timeXoroBytesBig; $bytesBigImprovement% improvement")
  println(s"Bytes:    java.util.Random - $timeJavaBytesSingle, xoroshiro128 - $timeXoroBytesSingle; $bytesSingleImprovement% improvement")
  println(s"Boolean:  java.util.Random - $timeJavaBool, xoroshiro128 - $timeXoroBool; $boolImprovement% improvement")
}