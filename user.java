import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class user {

    public boolean ValidCredentials(String name, String password) {
        if (name == null || name.isEmpty()) {
            return false;
        }
        if (password == null || password.length() < 6) {
            return false;
        }
        return true;
    }
}



public class UserTest {

    @Test
    void validCredentials_shouldReturnTrue_forValidInputs() {
        user u = new user();
        assertTrue(u.ValidCredentials("Alice", "password123"));
    }

    @Test
    void validCredentials_shouldReturnFalse_whenNameIsNull() {
        user u = new user();
        assertFalse(u.ValidCredentials(null, "password123"));
    }

    @Test
    void validCredentials_shouldReturnFalse_whenNameIsEmpty() {
        user u = new user();
        assertFalse(u.ValidCredentials("", "password123"));
    }

    @Test
    void validCredentials_shouldReturnFalse_whenPasswordIsNull() {
        user u = new user();
        assertFalse(u.ValidCredentials("Alice", null));
    }

    @Test
    void validCredentials
