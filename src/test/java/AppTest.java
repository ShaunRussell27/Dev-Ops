import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the App class.
 * Verifies the behavior of the getMessage() method.
 */

public class AppTest {

    @Test
    void testMessage() {
        assertEquals("Welcome to the Demon Slayer API!", App.getMessage());
    }
}
