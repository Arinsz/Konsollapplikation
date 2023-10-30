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


  
    @Before
    public void setUp() {


        user1 = new User("Anna", "Anna@gmail.com", 22);
        user2 = new User("Bertil", "Bertil@gmail.com", 27);


    }


    @Test
    public void testGetUserName() {

   
        assertEquals("Anna", user1.getUserName());

    }

    @Test
    public void testSetUsername() {

    
        user1.setUserName("Johan");

        assertEquals("Johan", user1.getUserName());

    }

    @Test
    public void testSetEmptyUsername() {
        try {
            User user = new User("", "Anna@gmail.com", 42);
            fail("Expected IllegalArgumentException"); // 
        } catch (IllegalArgumentException e) {
        
            assertEquals("Username must not be empty", e.getMessage());
        }
    }


    @Test
    public void testGetUserId() {

   
        assertEquals(22, user1.getUserId());
    }

    @Test
    public void testSetUserEmail() {

        user2.setUserEmail("bob@example.com");

    

        assertEquals("bob@example.com", user2.getUserEmail());
    }
}
