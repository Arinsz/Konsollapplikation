package KonsollAppGroup;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.*;


/**
 * UserList är en samling av användare lagrad i en TreeMap, som möjliggör effektiv hantering av användare.
 * Användare identifieras unikt med sina ID, och TreeMap upprätthåller även användarna sorterade efter deras namn.
 */

public class UserList {

    // Listorna är final för att hjälpa till att bevara integriteten.
    private final TreeMap<String, User> userMapByUserName = new TreeMap<>();
    private final HashMap<Integer, User> userMapByUserId = new HashMap<>();


    /**
     * Lägger till en användare i användarlistan.
     *
     * @param user Användaren som ska läggas till.
     * @throws IllegalStateException om en användare eller ID redan finns.
     */

    public void addUser(User user) {

        // Hämtar användarnamn och ID från den givna användaren.
        String userName = user.getUserName();
        int userId = user.getUserId();

        try {

            // Kontrollerar om användarnamnet redan finns i listan med användarnamn.
            if (userMapByUserName.containsKey(userName)) {

                throw new IllegalStateException(" Username: " + userName + " already exists, please try again.");

                // Annars, om ID redan finns i listan med användarnas-ID.
            } else if (userMapByUserId.containsKey(userId)) {

                throw new IllegalStateException(" User with ID: " + userId + " already exists, please try again.");

            } else {
                // Om användarnamnet och ID inte redan finns i listan, läggs användaren till i båda listorna.
                userMapByUserName.put(userName, user);
                userMapByUserId.put(userId, user);

                System.out.println("User " + userName + " successfully added.");

            }


        } catch (IllegalStateException e) {

            // Om det uppstår ett undantag, skriv ut ett felmeddelande.

            System.out.println("Error" + e.getMessage());
        }

    }


    /**
     * Initialiserar en användare i användarlistan.
     *
     * @param user Användaren som ska initialiseras.
     * @throws IllegalStateException om en användare eller ID redan finns.
     */

    public void initializeUser(User user) {

        // Hämtar användarnamn och ID från den givna användaren.
        String userName = user.getUserName();
        int userId = user.getUserId();

        try {

            // Kontrollerar om användarnamnet redan finns i listan med användarnamn.
            if (userMapByUserName.containsKey(userName)) {

                throw new IllegalStateException("Username: " + userName + " already exists.");

                // Annars, om ID redan finns i listan med ID
            } else if (userMapByUserId.containsKey(userId)) {

                throw new IllegalStateException("User with ID: " + userId + " already exists.");


            } else {

                // Om användarnamnet och ID inte redan finns i listan, läggs användaren till i båda listorna.
                userMapByUserName.put(userName, user);
                userMapByUserId.put(userId, user);


                System.out.println("User " + userName + " successfully initialized.");


            }


        } catch (IllegalStateException e) {

            // Om det uppstår ett undantag, skriv ut ett felmeddelande.

            System.out.println("Error" + e.getMessage());

        }


    }


    /**
     * Tar bort en användare från UserList genom deras användarnamn eller ID.
     *
     * @param userName Användarnamnet för användaren som ska tas bort. Sätt null om du vill ta bort efter ID.
     * @param id       Användarens ID som ska tas bort. Passa -1 om du vill ta bort efter användarnamn.
     */


    public boolean removeUserByNameOrId(String userName, int id) {

        // Skapar en användarreferens för att lagra användaren som ska tas bort.
        User userToRemove = null;


        if (userName != null && userMapByUserName.containsKey(userName)) {

            // Om användaren hittas, sätts userToRemove att vara användaren med det angivna användarnamnet.
            userToRemove = userMapByUserName.get(userName);


        } else if (id > 0 && userMapByUserId.containsKey(id)) {

            // Om användaren hittas, sätts userToRemove att vara användaren med det angivna ID:t.
            userToRemove = userMapByUserId.get(id);

        }

        // Kontrollerar om userToRemove innehåller en användare.
        if (userToRemove != null) {

            // Om användaren finns, tas användaren bort från listan både efter användarnamn och ID.
            userMapByUserName.remove(userToRemove.getUserName());

            userMapByUserId.remove(userToRemove.getUserId());

            System.out.println("User has been removed");
            return true;

        } else {

            System.out.println("User not found or removal failed");
            return false;

        }
    }


    /**
     * Hämtar en användare med deras ID.
     *
     * @param userId ID för användaren som ska hämtas.
     * @return Användaren med det angivna ID.
     * @throws UserPrincipalNotFoundException om användaren med det angivna ID inte hittades.
     */

    public User getUserbyId(int userId) throws UserPrincipalNotFoundException {

        if (userMapByUserId.containsKey(userId)) {

            return userMapByUserId.get(userId);

        } else {

            throw new UserPrincipalNotFoundException("User with ID " + userId + " not found.");

        }


    }


    /**
     * Sorterar listan över användare efter deras ID i stigande ordning med bubble sort-algoritmen.
     */

    public void bubbleSortUsersByID() {
        List<User> userList = new ArrayList<>(userMapByUserId.values());
        int n = userList.size();
        boolean swapped;

        // Yttre loop: Itererar från första elementet till näst sista elementet.
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            // Inre loop: Jämför intilliggande element och byter plats om det behövs.
            for (int j = 0; j < n - i - 1; j++) {
                if (userList.get(j).getUserId() > userList.get(j + 1).getUserId()) {

                    // Byt plats på de två User-objekten
                    User temp = userList.get(j);
                    userList.set(j, userList.get(j + 1));
                    userList.set(j + 1, temp);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        // Skriv ut den sorterade listan av användare
        System.out.println("***** UserList *****");
        for (User user : userList) {

            System.out.printf("User ID: %-4d Name: %-6s Email: %-4s%n",   // Justera resultatet med fasta breddfält.
                    user.getUserId(), user.getUserName(), user.getUserEmail());
        }
    }


    /**
     * Genererar en strängrepresentation av användarlistan. Den resulterande strängen inkluderar
     * detaljer om alla användare sorterade efter deras användarnamn.
     *
     * @return En formaterad sträng som representerar UserList.
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("***** UserList ***** :\n");

        for (User user : userMapByUserName.values()) {
            sb.append(user.toString()).append("\n");
        }

        return sb.toString();


    }

    /**
     * Hämtar HashMap som associerar ID med användarobjekt i UserList.
     *
     * @return En HashMap där nycklarna är ID och värdena är motsvarande användarobjekt.
     */

    public HashMap<Integer, User> getUserMapByUserId() {

        return userMapByUserId;

    }
}



