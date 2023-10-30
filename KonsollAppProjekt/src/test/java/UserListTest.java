import static org.junit.Assert.*;

import KonsollAppGroup.User;
import KonsollAppGroup.UserList;
import org.junit.Before;
import org.junit.Test;


import java.nio.file.attribute.UserPrincipalNotFoundException;

import static org.junit.Assert.assertEquals;


/**
 * Denna klass innehåller en uppsättning JUnit-testfall för UserList-klassen.
 * Testerna täcker scenarier för att lägga till, sortera och ta bort användare från UserList.
 */

public class UserListTest {

    private UserList userList;


    /**
     * Metoden som körs innan testfallen. Skapar en användarlista och initierar den med några användare.
     */
    @Before
    public void setUp() {

        userList = new UserList();

        userList.initializeUser(new User("Arin", "arin@gmail.com", 109));
        userList.initializeUser(new User("Bob", "bob@example.com", 150));
        userList.initializeUser(new User("Clara", "Clara@example.com", 209));
    }

    /**
     * Testar att lägga till en ny användare i listan och sedan hämta användaren med hjälp av användarens-ID.
     */

    @Test
    public void testAddUserAndGetUserById() {

        User newUser = new User("Kalle", "Kalle@gmail.com", 207);
        userList.addUser(newUser);

        try {

            User retrievedUser = userList.getUserbyId(207);
           
            assertEquals(newUser, retrievedUser);
        } catch (UserPrincipalNotFoundException e) {
            fail("getUserbyID kastade ett undantag: " + e.getMessage());
        }
    }

    /**
     * Testar bubble sort-algoritmen för att sortera användare efter användarens-ID.
     */
    @Test
    public void testBubbleSortUsersByID() {

        // Konfigurera userList med osorterade användare
        UserList userList = new UserList();
        userList.initializeUser(new User("UserA", "usera@example.com", 3));
        userList.initializeUser(new User("UserB", "userb@example.com", 11));
        userList.initializeUser(new User("UserC", "userc@example.com", 8));

        userList.bubbleSortUsersByID();


        User prevUser = null;

        for (User user : userList.getUserMapByUserId().values()) {
            if (prevUser != null) {
              
                assertTrue(user.getUserId() >= prevUser.getUserId());
            }

       
            prevUser = user;
        }
    }

    /**
     * Testar att ta bort en användare med användarnamn eller ID från listan.
     */

    @Test
    public void testRemoveUserByNameOrId() {

 
        userList.removeUserByNameOrId("Arin", 201);

      
        assertEquals(2, userList.getUserMapByUserId().size());
    }
}
