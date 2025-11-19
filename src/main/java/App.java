import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main application class for the Demon Slayer API demo.
 * This program demonstrates logging and basic monitoring
 * using SLF4J and Micrometer.
 * 
 * @author ShaunRussell27
 * @version 1.0
 */
public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    // Micrometer registry and metrics
    private static final SimpleMeterRegistry registry = new SimpleMeterRegistry();
    private static final Counter invocationCounter = registry.counter("app.invocations");
    private static final Timer executionTimer = registry.timer("app.execution.time");

    /**
     * The entry point of the Demon Slayer API demo.
     * Logs a welcome message and tracks metrics for
     * method invocations and execution time.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {

        logger.info("Application started");

        // Increment invocation count
        invocationCounter.increment();

        // Time the execution of the welcome message logic
        executionTimer.record(() -> {
            logger.info("Welcome to the Demon Slayer API!");
            // Simulate work or business logic here
        });

        // Print current metrics to console
        registry.getMeters().forEach(meter -> {
            logger.info("Meter: " + meter.getId().getName() + " - Count: " + meter.measure());
        });

        logger.info("Application finished");
    }

    /**
     * Returns a welcome message.
     * Logs the method call for monitoring purposes.
     *
     * @return A String containing the welcome message.
     */
    public static String getMessage() {
        logger.info("getMessage() called");
        return "Welcome to the Demon Slayer API!";
    }
}
