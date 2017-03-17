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
"com.mscharley" %%% "xoroshiro128" % "0.1"
```

## Benchmark

A likely non-representative benchmark run on my computer:

```
[info] Running Benchmark
Benchmarking 100000 iterations x1000:

Long:     java.util.Random - 3.573087792000001 ms, xoroshiro128 - 1.9018405080000018 ms; 46.773193979220274% improvement
Int:      java.util.Random - 1.9018745370000056 ms, xoroshiro128 - 1.6968884260000006 ms; 10.778109018870808% improvement
Bytes(s): java.util.Random - 0.4364170409999992 ms, xoroshiro128 - 0.3041575960000002 ms; 30.30574715802613% improvement
Bytes(l): java.util.Random - 0.3242185830000001 ms, xoroshiro128 - 0.14122651099999983 ms; 56.440957303178465% improvement
Bytes:    java.util.Random - 0.29632551600000023 ms, xoroshiro128 - 0.14365675800000016 ms; 51.520625041280596% improvement
Boolean:  java.util.Random - 1.7319338389999992 ms, xoroshiro128 - 1.4921221799999982 ms; 13.84646766521207% improvement
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
