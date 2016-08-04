# xoroshiro128 in Scala

This is an implementation of the xoroshiro128 algorithm in Scala for a laugh.

Original implementation: http://xorshift.di.unimi.it/xoroshiro128plus.c

To the extent possible under law, the author has dedicated all copyright
and related and neighboring rights to this software to the public domain
worldwide. This software is distributed without any warranty.

See <http://creativecommons.org/publicdomain/zero/1.0/>.

## Benchmark

A likely non-representative benchmark run on my computer:

```
[info] Running Benchmark
Benchmarked 1000000 iterations:

Long:     java.util.Random - 26.930215300000004 ms, xoroshiro128 - 15.1353751 ms; 43.79779392257589% improvement
Int:      java.util.Random - 14.460099499999998 ms, xoroshiro128 - 11.92222945 ms; 17.550847765604928% improvement
Bytes(s): java.util.Random - 3.2541663500000007 ms, xoroshiro128 - 3.7238746500000004 ms; -14.434059279114585% improvement
Bytes(l): java.util.Random - 2.86566435 ms, xoroshiro128 - 1.27808245 ms; 55.40013435278978% improvement
Bytes:    java.util.Random - 2.8313277499999994 ms, xoroshiro128 - 1.25413845 ms; 55.70493560839079% improvement
Boolean:  java.util.Random - 13.868151799999998 ms, xoroshiro128 - 10.985092 ms; 20.78907010521761% improvement
```

To run this benchmark for yourself: `./sbt run`
