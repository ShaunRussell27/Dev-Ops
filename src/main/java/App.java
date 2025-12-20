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

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    // Micrometer registry and metrics
    private static final SimpleMeterRegistry REGISTRY = new SimpleMeterRegistry();
    private static final Counter INVOCATION_COUNTER = REGISTRY.counter("app.invocations");
    private static final Timer EXECUTION_TIMER = REGISTRY.timer("app.execution.time");

    /**
     * The entry point of the Demon Slayer API demo.
     * Logs a welcome message and tracks metrics for
     * method invocations and execution time.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {

        LOGGER.info("Application started");

        // Increment invocation count
        INVOCATION_COUNTER.increment();

        // Time the execution of the welcome message logic
        EXECUTION_TIMER.record(() -> {
            LOGGER.info("Welcome to the Demon Slayer API!");
            // Simulate work or business logic here
        });

        // Print current metrics to console
        REGISTRY.getMeters().forEach(meter -> {
            LOGGER.info("Meter: " + meter.getId().getName() + " - Count: " + meter.measure());
        });

        LOGGER.info("Application finished");
    }

    /**
     * Returns a welcome message.
     * Logs the method call for monitoring purposes.
     *
     * @return A String containing the welcome message.
     */
    public static String getMessage() {
        return "Welcome to the Demon Slayer API!";
    }
}
