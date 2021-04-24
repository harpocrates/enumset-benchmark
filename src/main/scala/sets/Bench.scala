package sets
import org.openjdk.jmh.annotations._
import java.util._
import java.util.concurrent._
import org.openjdk.jmh.infra.Blackhole

@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
@Warmup(iterations = 5, time = 200, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 200, timeUnit = TimeUnit.MILLISECONDS)
@Fork(10)
class Bench {

  val flagsSet: Set[FlagsEnum] = EnumSet.of(FlagsEnum.A, FlagsEnum.B, FlagsEnum.G);
  val masksSet: Int = FlagsMasks.A | FlagsMasks.B | FlagsMasks.G;

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
