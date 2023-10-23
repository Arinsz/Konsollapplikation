import static org.junit.Assert.*;

import KonsollAppGroup.User;
import org.junit.Before;
import org.junit.Test;

/**
 * Denna klass innehåller JUnit-testfall för att testa olika aspekter av User-klassen.
 */

public class UserTest {

    private User user1;
    private User user2;


    // Metoden med @Before körs före varje testfall.
    @Before
    public void setUp() {


        user1 = new User("Anna", "Anna@gmail.com", 22);
        user2 = new User("Bertil", "Bertil@gmail.com", 27);


    }


    @Test
    public void testGetUserName() {

        // Jämför användarnamnet som returneras av "getUserName" för "user1" med det förväntade värdet "Anna".
        assertEquals("Anna", user1.getUserName());

    }

    @Test
    public void testSetUsername() {

        // Anropar "setUserName" -metoden för "user1" och ändrar användarnamnet till "Johan".
        user1.setUserName("Johan");

        // Jämför användarnamnet som returneras av "getUserName" för "user1" med det förväntade värdet "Johan".
        assertEquals("Johan", user1.getUserName());

    }

    @Test
    public void testSetEmptyUsername() {
        try {
            User user = new User("", "Anna@gmail.com", 42);
            fail("Expected IllegalArgumentException"); // Om inget exception kastas, misslyckas testet.
        } catch (IllegalArgumentException e) {
            // Kontrollera meddelandet i exception.
            assertEquals("Username must not be empty", e.getMessage());
        }
    }


    @Test
    public void testGetUserId() {

        // Jämför användarens ID som returneras av "getUserId" för "user1" med det förväntade värdet 22.
        assertEquals(22, user1.getUserId());
    }

    @Test
    public void testSetUserEmail() {
        // Anropar "setUserEmail" -metoden för "user2" och ändrar användarens e-postadress.
        user2.setUserEmail("bob@example.com");

        // Jämför användarens e-postadress som returneras av "getUserEmail" för "user2" med det
        // förväntade värdet "bob@example.com".

        assertEquals("bob@example.com", user2.getUserEmail());
    }
}
