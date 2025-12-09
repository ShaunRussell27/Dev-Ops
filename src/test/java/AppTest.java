import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the App class.
 * Tests the core functionality including message retrieval
 * and application execution.
 */
public class AppTest {

    @BeforeEach
    void setUp() {
        // Setup runs before each test
        System.out.println("Running test...");
    }

    @Test
    @DisplayName("Should return correct welcome message")
    void testGetMessage() {
        String expectedMessage = "Welcome to the Demon Slayer API!";
        String actualMessage = App.getMessage();
        
        assertEquals(expectedMessage, actualMessage, 
            "getMessage() should return the welcome message");
    }

    @Test
    @DisplayName("Should return non-null message")
    void testGetMessageNotNull() {
        String message = App.getMessage();
        assertNotNull(message, "getMessage() should never return null");
    }

    @Test
    @DisplayName("Should return non-empty message")
    void testGetMessageNotEmpty() {
        String message = App.getMessage();
        assertEquals(false, message.isEmpty(), 
            "getMessage() should return a non-empty string");
    }

    @Test
    @DisplayName("Main method should execute without throwing exceptions")
    void testMainMethodExecution() {
        assertDoesNotThrow(() -> {
            App.main(new String[]{});
        }, "main() should execute without throwing any exceptions");
    }

    @Test
    @DisplayName("Main method should handle null arguments")
    void testMainMethodWithNullArgs() {
        assertDoesNotThrow(() -> {
            App.main(null);
        }, "main() should handle null arguments gracefully");
    }

    @Test
    @DisplayName("Message should contain expected keywords")
    void testMessageContent() {
        String message = App.getMessage();
        assertEquals(true, message.contains("Demon Slayer"), 
            "Message should contain 'Demon Slayer'");
        assertEquals(true, message.contains("API"), 
            "Message should contain 'API'");
    }
}
