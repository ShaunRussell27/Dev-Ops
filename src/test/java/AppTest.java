import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the App class.
 * Tests the core functionality including message retrieval
 * and application execution.
 */
public class AppTest {

    /**
     * Setup method that runs before each test.
     */
    @BeforeEach
    void setUp() {
        // Setup runs before each test
        System.out.println("Running test...");
    }

    /**
     * Tests that getMessage returns the correct welcome message.
     */
    @Test
    @DisplayName("Should return correct welcome message")
    void testGetMessage() {
        String expectedMessage = "Welcome to the Demon Slayer API!";
        String actualMessage = App.getMessage();
        
        assertEquals(expectedMessage, actualMessage, 
            "getMessage() should return the welcome message");
    }

    /**
     * Tests that getMessage never returns null.
     */
    @Test
    @DisplayName("Should return non-null message")
    void testGetMessageNotNull() {
        String message = App.getMessage();
        assertNotNull(message, "getMessage() should never return null");
    }

    /**
     * Tests that getMessage returns a non-empty string.
     */
    @Test
    @DisplayName("Should return non-empty message")
    void testGetMessageNotEmpty() {
        String message = App.getMessage();
        assertFalse(message.isEmpty(), 
            "getMessage() should return a non-empty string");
    }

    /**
     * Tests that the main method executes without throwing exceptions.
     */
    @Test
    @DisplayName("Main method should execute without throwing exceptions")
    void testMainMethodExecution() {
        assertDoesNotThrow(() -> {
            App.main(new String[]{});
        }, "main() should execute without throwing any exceptions");
    }

    /**
     * Tests that the main method handles null arguments gracefully.
     */
    @Test
    @DisplayName("Main method should handle null arguments")
    void testMainMethodWithNullArgs() {
        assertDoesNotThrow(() -> {
            App.main(null);
        }, "main() should handle null arguments gracefully");
    }

    /**
     * Tests that the message contains expected keywords.
     */
    @Test
    @DisplayName("Message should contain expected keywords")
    void testMessageContent() {
        String message = App.getMessage();
        assertTrue(message.contains("Demon Slayer"), 
            "Message should contain 'Demon Slayer'");
        assertTrue(message.contains("API"), 
            "Message should contain 'API'");
    }

    // ========== Performance Tests ==========

    /**
     * Tests getMessage performance under load conditions.
     */
    @Test
    @DisplayName("Test getMessage performance under load")
    void testMessagePerformance() {
        long startTime = System.nanoTime();
        int iterations = 100_000;
        
        for (int i = 0; i < iterations; i++) {
            App.getMessage();
        }
        
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        long avgTimeNanos = duration / iterations;
        
        System.out.println("Performance Test Results:");
        System.out.println("Total iterations: " + iterations);
        System.out.println("Total time: " + duration / 1_000_000 + " ms");
        System.out.println("Average time per call: " + avgTimeNanos + " ns");
        
        // Assert that average execution time is reasonable (less than 1000 ns)
        assertTrue(avgTimeNanos < 1000, 
            "getMessage should execute in less than 1000ns, but took " + avgTimeNanos + "ns");
    }

    /**
     * Tests getMessage consistency across multiple repeated calls.
     */
    @RepeatedTest(10)
    @DisplayName("Test getMessage consistency across multiple calls")
    void testMessageConsistency() {
        String result = App.getMessage();
        assertEquals("Welcome to the Demon Slayer API!", result);
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    /**
     * Tests concurrent access performance with multiple threads.
     *
     * @throws InterruptedException if thread execution is interrupted
     */
    @Test
    @DisplayName("Test concurrent access performance")
    void testConcurrentAccess() throws InterruptedException {
        int threadCount = 10;
        int iterationsPerThread = 10_000;
        Thread[] threads = new Thread[threadCount];
        long startTime = System.nanoTime();
        
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < iterationsPerThread; j++) {
                    App.getMessage();
                }
            });
            threads[i].start();
        }
        
        for (Thread thread : threads) {
            thread.join();
        }
        
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        
        System.out.println("Concurrent Test Results:");
        System.out.println("Threads: " + threadCount);
        System.out.println("Iterations per thread: " + iterationsPerThread);
        System.out.println("Total time: " + duration / 1_000_000 + " ms");
        
        // Assert test completed in reasonable time (less than 5 seconds)
        assertTrue(duration < 5_000_000_000L, 
            "Concurrent test should complete in less than 5 seconds");
    }

    /**
     * Tests memory efficiency of repeated getMessage calls.
     */
    @Test
    @DisplayName("Test memory efficiency")
    void testMemoryEfficiency() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); // Request garbage collection
        
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        
        // Execute many times
        for (int i = 0; i < 100_000; i++) {
            App.getMessage();
        }
        
        runtime.gc(); // Request garbage collection
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsed = memoryAfter - memoryBefore;
        
        System.out.println("Memory Test Results:");
        System.out.println("Memory used: " + memoryUsed / 1024 + " KB");
        
        // Assert reasonable memory usage (less than 10 MB)
        assertTrue(memoryUsed < 10_000_000, 
            "Memory usage should be less than 10 MB, but was " + memoryUsed / 1024 + " KB");
    }
}
