# Performance Testing Guide

This project includes comprehensive performance testing for the Demon Slayer API application.

## Performance Test Types

### 1. JUnit Performance Tests (`AppTest.java`)

Basic performance tests integrated with regular unit tests:

- **Load Performance Test**: Measures average execution time over 100,000 iterations
- **Consistency Test**: Verifies consistent behavior across multiple repeated calls
- **Concurrent Access Test**: Tests performance under multi-threaded load (10 threads)
- **Memory Efficiency Test**: Monitors memory usage during extensive operations

**Run JUnit tests:**
```bash
mvn test
```

### 2. JMH Benchmarks (`AppPerformanceBenchmark.java`)

Industry-standard microbenchmarking using Java Microbenchmark Harness (JMH):

- **Average Time Benchmark**: Measures average time per operation in nanoseconds
- **Throughput Benchmark**: Measures operations per second
- **Baseline Benchmark**: Measures JMH overhead for comparison

**Run JMH benchmarks:**
```bash
# Run the benchmark class directly
mvn exec:java -Dexec.mainClass="AppPerformanceBenchmark"

# Or compile and run manually
mvn clean compile test-compile
java -cp target/test-classes:target/classes org.openjdk.jmh.Main AppPerformanceBenchmark
```

## Performance Metrics

### Expected Performance Targets

- **getMessage() execution time**: < 1,000 ns per call
- **Concurrent access**: Complete in < 5 seconds (10 threads, 10k iterations each)
- **Memory usage**: < 10 MB for 100,000 calls
- **Throughput**: > 1,000,000 ops/sec

## Interpreting Results

### JUnit Performance Output
```
Performance Test Results:
Total iterations: 100000
Total time: 15 ms
Average time per call: 150 ns
```

### JMH Benchmark Output
```
Benchmark                                       Mode  Cnt   Score   Error  Units
AppPerformanceBenchmark.benchmarkGetMessage     avgt    5  10.234 ± 0.234  ns/op
AppPerformanceBenchmark.benchmarkThroughput    thrpt    5  95.123 ± 2.456  ops/s
```

## CI/CD Integration

Performance tests run automatically with:
```bash
mvn clean verify
```

## Performance Optimization Tips

1. **JVM Warmup**: JMH handles warmup iterations automatically
2. **Garbage Collection**: Tests request GC before memory measurements
3. **Thread Safety**: Concurrent tests verify thread-safe operations
4. **Baseline Comparison**: Compare against baseline to measure actual overhead

## Troubleshooting

If performance tests fail:
1. Check system load - close unnecessary applications
2. Verify JVM heap size is sufficient
3. Review test thresholds in assertions
4. Run tests multiple times to account for variance

## Dependencies

- JUnit 5.8.2 - Unit and performance testing
- JMH 1.37 - Microbenchmarking framework
