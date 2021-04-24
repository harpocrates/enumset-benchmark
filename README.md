Benchmark to make a point in some online thread about how incorrect the
benchmark in <https://nullprogram.com/blog/2021/04/23/> is. Please don't use this
to draw any actual conclusions about `EnumSet` (you should be benchmarking
actual realistic workloads).

If you have SBT and Java installed, compile and run with `sbt jmh:run`.

On my machine, I get the following output:

```
$ sbt jmh:run
...
[info] REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
[info] why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
[info] experiments, perform baseline and negative tests that provide experimental control, make sure
[info] the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
[info] Do not assume the numbers tell you what you want them to tell.
[info] Benchmark      Mode  Cnt  Score   Error  Units
[info] Bench.enumSet  avgt  100   6.605 ± 0.173  ns/op
[info] Bench.hashSet  avgt  100  83.031 ± 9.414  ns/op
[info] Bench.maskSet  avgt  100   4.200 ± 0.123  ns/op
[success] Total time: 52 s, completed Apr 24, 2021 6:38:40 PM
```
