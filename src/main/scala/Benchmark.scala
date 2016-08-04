import org.scalameter._

object Benchmark extends App {
  val ITERATIONS = 10000000

  private val measurer = config(
    Key.exec.benchRuns -> 20,
    Key.verbose -> true
  ) withWarmer {
    new Warmer.Default
  } withMeasurer {
    new Measurer.IgnoringGC
  }

  val scalaRand = new java.util.Random
  val xoroRand = new xoroshiro128

  val timeJavaLong = measurer measure {
    for (i <- 0 until ITERATIONS) yield scalaRand.nextLong()
  }

  val timeXoroLong = measurer measure {
    for (i <- 0 until ITERATIONS) yield xoroRand.nextLong()
  }

  val timeJavaBool = measurer measure {
    for (i <- 0 until ITERATIONS) yield scalaRand.nextBoolean()
  }

  val timeXoroBool = measurer measure {
    for (i <- 0 until ITERATIONS) yield xoroRand.nextBoolean()
  }

  println(s"Long: java.util.Random - $timeJavaLong, xoroshiro128 - $timeXoroLong")
  println(s"Boolean: java.util.Random - $timeJavaBool, xoroshiro128 - $timeXoroBool")
}
