/**
 * Main application class for the Demon Slayer API demo.
 * This program prints a welcome message and demonstrates
 * passing parameters into a method.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class App {

    /**
     * The entry point of the Demon Slayer API demo.
     * Prints a welcome message to the console.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the Demon Slayer API!");
        // Log an info message instead of printing
        logger.info("Welcome to the Demon Slayer API!");

        // Optionally log at different levels
        logger.debug("Debug: Application has started");
        logger.warn("Warning: This is a demo application");
        logger.error("Error: Just an example error log");
    }

    /**
     * Returns a welcome message.
     *
     * @return A String containing the welcome message.
     */
    public static String getMessage() {
        return "Welcome to the Demon Slayer API!";
        logger.info("getMessage() called");
        return "Welcome to the Demon Slayer API!";
    }
}
