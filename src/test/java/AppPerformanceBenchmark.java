import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * JMH Benchmark for App performance testing.
 * Run this class directly to execute performance benchmarks.
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
@Fork(value = 1, warmups = 1)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 1)
public class AppPerformanceBenchmark {

    /**
     * Benchmark for getMessage method - average time per operation.
     */
    @Benchmark
    public String benchmarkGetMessage() {
        return App.getMessage();
    }

    /**
     * Benchmark for getMessage method - throughput (operations per second).
     */
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public String benchmarkGetMessageThroughput() {
        return App.getMessage();
    }

    /**
     * Baseline benchmark - measures empty method overhead.
     */
    @Benchmark
    public void baselineEmptyMethod() {
        // Intentionally empty - measures JMH overhead
    }

    /**
     * Main method to run benchmarks.
     * Execute: mvn clean test -Dtest=AppPerformanceBenchmark
     */
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(AppPerformanceBenchmark.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
