package sets
import org.openjdk.jmh.annotations._
import java.util._
import java.util.concurrent._
import org.openjdk.jmh.infra.Blackhole

@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
@Warmup(iterations = 10, time = 200, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 200, timeUnit = TimeUnit.MILLISECONDS)
@Fork(10)
class Bench {

  val hashSet: Set[FlagsEnum] = {
    val s = new HashSet[FlagsEnum]()
    s.add(FlagsEnum.A)
    s.add(FlagsEnum.B)
    s.add(FlagsEnum.G)
    s
  }
  val flagsSet: Set[FlagsEnum] = EnumSet.of(FlagsEnum.A, FlagsEnum.B, FlagsEnum.G);
  val masksSet: Int = FlagsMasks.A | FlagsMasks.B | FlagsMasks.G;

  @Benchmark
  def hashSet(b: Blackhole): Any = {
    val hashSet2 = new HashSet[FlagsEnum]()
    hashSet2.add(FlagsEnum.A)
    hashSet2.add(FlagsEnum.B)
    hashSet2.add(FlagsEnum.G)
    b.consume(hashSet.equals(hashSet2))
  }

  @Benchmark
  def enumSet(b: Blackhole): Any = {
    val flagsSet2 = EnumSet.of(FlagsEnum.A, FlagsEnum.B, FlagsEnum.G);
    b.consume(flagsSet.equals(flagsSet2))
  }

  @Benchmark
  def maskSet(b: Blackhole): Any = {
    val maskSet2 = FlagsMasks.A | FlagsMasks.B | FlagsMasks.G;
    b.consume(masksSet.equals(maskSet2))
  }

}
