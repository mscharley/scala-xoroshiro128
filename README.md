# xoroshiro128+ in Scala

[![CircleCI](https://circleci.com/gh/mscharley/scala-xoroshiro128.svg?style=svg)](https://circleci.com/gh/mscharley/scala-xoroshiro128)

**Source:** [https://github.com/mscharley/scala-xoroshiro128](https://github.com/mscharley/scala-xoroshiro128)  
**Author:** Matthew Scharley  
**Contributors:** [See contributors on GitHub][gh-contrib]  
**Bugs/Support:** [Github Issues][gh-issues]  
**Copyright:** 2017  
**License:** [CC0](http://creativecommons.org/publicdomain/zero/1.0/)  
**Status:** Active

## Synopsis

This is an implementation of the xoroshiro128+ algorithm in Scala for a laugh.

## License

Original implementation: http://xorshift.di.unimi.it/

To the extent possible under law, the author has dedicated all copyright
and related and neighboring rights to this software to the public domain
worldwide. This software is distributed without any warranty.

See <http://creativecommons.org/publicdomain/zero/1.0/>.

## Usage

```
"com.mscharley" %%% "xoroshiro128" % "0.2.0"
```

## Benchmark

A likely non-representative benchmark run on my computer:

```
[info] Running JvmBenchmark
Benchmarking 8000000 bytes of data x100:
Long:     s.u.Random - 23.93999266 ms, xoroshiro128 - 1.1129802500000003 ms; 95.35095826549849% improvement
Int:      s.u.Random - 23.85083168000001 ms, xoroshiro128 - 2.2173956100000005 ms; 90.70306796949397% improvement
Short:    s.u.Random - 48.22186773000002 ms, xoroshiro128 - 4.59222692 ms; 90.47687877683953% improvement
Bytes(s): s.u.Random - 29.75306531 ms, xoroshiro128 - 19.856193739999995 ms; 33.26336788120338% improvement
Bytes(l): s.u.Random - 24.804027829999995 ms, xoroshiro128 - 11.763384149999997 ms; 52.57470185639605% improvement
Bytes:    s.u.Random - 26.417548529999998 ms, xoroshiro128 - 11.995912270000012 ms; 54.59112242615036% improvement
Boolean:  s.u.Random - 95.77337273999997 ms, xoroshiro128 - 9.00962081 ms; 90.5927706707596% improvement
[success] Total time: 38 s, completed 26/03/2017 8:40:11 PM
```

```
[info] running
[info] /.../scala-xoroshiro128/benchmark/native/target/scala-2.11/xoroshiro128-benchmark-out
Benchmarking 8000000 bytes of data x100:
Long:     s.u.Random - 12.937738 ms, xoroshiro128 - 5.330703 ms; 58.797255% improvement
Int:      s.u.Random - 16.519583 ms, xoroshiro128 - 14.059075 ms; 14.894493% improvement
Short:    s.u.Random - 32.537838 ms, xoroshiro128 - 27.262902 ms; 16.211699% improvement
Bytes(s): s.u.Random - 116.925888 ms, xoroshiro128 - 113.690834 ms; 2.766756% improvement
Bytes(l): s.u.Random - 75.950144 ms, xoroshiro128 - 68.031258 ms; 10.426427% improvement
Bytes:    s.u.Random - 73.362115 ms, xoroshiro128 - 64.498381 ms; 12.082168% improvement
Boolean:  s.u.Random - 78.030979 ms, xoroshiro128 - 76.605007 ms; 1.827442% improvement
```

```
[info] Running JsBenchmark
Benchmarking 8000000 bytes of data x100:
Long:     s.u.Random - 85.66000127999997 ms, xoroshiro128 - 73.38000128 ms; 14.335745758233054% improvement
Int:      s.u.Random - 53.82000128000001 ms, xoroshiro128 - 103.03999999999998 ms; -91.45298689966876% improvement
Short:    s.u.Random - 106.64000256 ms, xoroshiro128 - 210.44999936 ms; -97.34620621524486% improvement
Bytes(s): s.u.Random - 120.88999936 ms, xoroshiro128 - 552.23000064 ms; -356.80370879604897% improvement
Bytes(l): s.u.Random - 63.909998080000015 ms, xoroshiro128 - 437.02000128 ms; -583.805373821097% improvement
Bytes:    s.u.Random - 96.52999936 ms, xoroshiro128 - 475.77999872 ms; -392.88304348332275% improvement
Boolean:  s.u.Random - 365.33999872 ms, xoroshiro128 - 578.13999104 ms; -58.247110380895364% improvement
```

To run this benchmark for yourself: `sbt benchmarkJVM/run`

## Verification

You can always download and compile the reference C implementation and compare output. To
aid in that endeavour [I've put up an online version](https://ideone.com/hwDnTY) which you
can use to easily generate sequences of values.

There's also a set of prebuilt comparisons against the reference built into the test suite
which you can run with `sbt test`.

## Releases

### Snapshots

```
sbt publishSigned
```

### Full Releases

```
sbt publishSigned sonatypeRelease
```

  [gh-contrib]: https://github.com/mscharley/scala-xoroshiro128/graphs/contributors
  [gh-issues]: https://github.com/mscharley/scala-xoroshiro128/issues
