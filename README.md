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

## Benchmark

A likely non-representative benchmark run on my computer:

```
[info] Running Benchmark
Benchmarked 10000 iterations x1000:

Long:     java.util.Random - 0.2895389689999996 ms, xoroshiro128 - 0.17061549099999992 ms; 41.07339278396057% improvement
Int:      java.util.Random - 0.14850449299999993 ms, xoroshiro128 - 0.15098317799999966 ms; -1.6690976481093633% improvement
Bytes(s): java.util.Random - 0.03510169 ms, xoroshiro128 - 0.043417227000000044 ms; -23.689847981678504% improvement
Bytes(l): java.util.Random - 0.024133592000000023 ms, xoroshiro128 - 0.010907091000000008 ms; 54.80535595364338% improvement
Bytes:    java.util.Random - 0.02857708699999999 ms, xoroshiro128 - 0.011320101000000015 ms; 60.387491559234086% improvement
Boolean:  java.util.Random - 0.14481436300000017 ms, xoroshiro128 - 0.12520640400000002 ms; 13.540065083185237% improvement
```

To run this benchmark for yourself: `sbt benchmark/run`

## Verification

You can always download and compile the reference C implementation and compare output. To
aid in that endeavour [I've put up an online version](https://ideone.com/hwDnTY) which you
can use to easily generate sequences of values.

There's also a set of prebuilt comparisons against the reference built into the test suite
which you can run with `sbt test`.

  [gh-contrib]: https://github.com/mscharley/scala-xoroshiro128/graphs/contributors
  [gh-issues]: https://github.com/mscharley/scala-xoroshiro128/issues
