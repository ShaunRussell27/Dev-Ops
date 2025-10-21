import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void testMessage() {
        assertEquals("Welcome to the Demon Slayer API!", App.getMessage());
    }
}
