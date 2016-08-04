import org.scalameter._

object Benchmark extends App {
  val ITERATIONS = 1000000

  private val measurer = config(
    Key.exec.benchRuns -> 20
  ) withWarmer {
    new Warmer.Default
  } withMeasurer {
    new Measurer.IgnoringGC
  }

  val scalaRand = new java.util.Random
  val xoroRand = new xoroshiro128

  val timeJavaLong = measurer measure { for (i <- 0 until ITERATIONS) yield scalaRand.nextLong() }
  val timeXoroLong = measurer measure { for (i <- 0 until ITERATIONS) yield xoroRand.nextLong() }
  val longImprovement = (1 - timeXoroLong.value / timeJavaLong.value) * 100

  val timeJavaInt = measurer measure { for (i <- 0 until ITERATIONS) yield scalaRand.nextInt() }
  val timeXoroInt = measurer measure { for (i <- 0 until ITERATIONS) yield xoroRand.nextInt() }
  val intImprovement = (1 - timeXoroInt.value / timeJavaInt.value) * 100

  val timeJavaBool = measurer measure { for (i <- 0 until ITERATIONS) yield scalaRand.nextBoolean() }
  val timeXoroBool = measurer measure { for (i <- 0 until ITERATIONS) yield xoroRand.nextBoolean() }
  val boolImprovement = (1 - timeXoroBool.value / timeJavaBool.value) * 100

  println(s"Benchmarked $ITERATIONS iterations:")
  println("")
  println(s"Long:    java.util.Random - $timeJavaLong, xoroshiro128 - $timeXoroLong; $longImprovement% improvement")
  println(s"Int:     java.util.Random - $timeJavaInt, xoroshiro128 - $timeXoroInt; $intImprovement% improvement")
  println(s"Boolean: java.util.Random - $timeJavaBool, xoroshiro128 - $timeXoroBool; $boolImprovement% improvement")
}
