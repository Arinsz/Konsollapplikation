package KonsollAppGroup;


/**
 * Denna klass innehåller en användarmeny för att hantera användardata och interaktioner.
 * Användare kan lägga till, ta bort, hämta och lista användare, med alternativ att sortera efter namn och ID. Programmet styrs
 * av en loop som kontinuerligt visar menyn och behandlar användarinmatning.
 * Programmet initialiserar även en UserList, fyller den med initiala användare och konfigurerar en administratörsanvändare.
 * Koden använder klasserna UserList, User och AdminUser, samt en InputHandler för användarinmatning.
 *
 * @author [Arin Sarafraz]
 */


public class Main {
    public static void main(String[] args) {

        // Skapar en UserList och en InputHandler för att hantera användare och användarinmatning.
        UserList initializedUserList = initializeUserList();
        InputHandler inputHandler = new InputHandler();

        while (true) {

            try {

                System.out.println(" ******  Menu: ******");
                System.out.println("1. Add new user");
                System.out.println("2. Remove user");
                System.out.println("3. Get user-information");
                System.out.println("4. List all users sorted by name");  // Treemap sköter sorteringen.
                System.out.println("5. List all users sorted by ID"); // Använder BubbleSort-metoden för att sortera ID.
                System.out.println("6. Exit");
                System.out.print("Enter your choice with a number from 1-6: ");

                int choice = inputHandler.readIntInput();


                switch (choice) {


                    case 1:

                        // Initiera indata-variabler med standardvärden.
                        String newUsername = null;
                        String newEmail = null;
                        int newId = -1;

                        boolean validInput = false;

                        while (!validInput) {
                            try {
                                System.out.println("Enter new Username (1-20 Characters):");
                                newUsername = inputHandler.readStringInput(1, 20);

                                System.out.println("Enter E-mail address (at least 5 characters, must contain @ and .):");
                                newEmail = inputHandler.readStringInput(5, 20);

                                System.out.println("Enter new ID (a positive integer):");
                                newId = inputHandler.readIntInput();

                                // Indata-validering.
                                if (!newUsername.isEmpty() &&
                                        newEmail.length() >= 5 &&
                                        newEmail.contains("@") &&
                                        newEmail.contains(".") &&
                                        newId > 0) {
                                    validInput = true;
                                } else {
                                    System.out.println("Invalid input. Please check the criteria for each field.");
                                }
                            } catch (IllegalArgumentException e) {
                                System.out.println("Error: " + e.getMessage());
                                System.out.println("Please try again.");
                            }
                        }

                        // Skapa ett nytt User-objekt med den angivna användarinformationen.
                        User user = new User(newUsername, newEmail, newId);

                        try {
                            // Försök att lägga till användaren i listan.
                            initializedUserList.addUser(user);

                            // printar ett meddelande om det misslyckas att lägga till en användare.
                        } catch (IllegalStateException e) {
                            System.out.println("Error: " + e.getMessage());
                            System.out.println("Please try again.");
                        }

                        break;

                    case 2:

                        System.out.println("Enter Username or ID on the user you want to remove");
                        String userToRemove = inputHandler.readStringInput(1, 20);

                        // Håll reda på om användaren togs bort.
                        boolean userRemoved = false;


                        try {
                            // Försök att tolka användarinmatningen som ett heltal (ID)
                            int userId = Integer.parseInt(userToRemove);

                            // Försök ta bort med userId, sätter username som null.
                            userRemoved = initializedUserList.removeUserByNameOrId(null, userId);
                        } catch (NumberFormatException e) {

                            //Catch försök ta bort med username, därför är id -1.
                            userRemoved = initializedUserList.removeUserByNameOrId(userToRemove, -1);

                        }

                        if (userRemoved) {
                            System.out.println("User has been successfully removed.");
                        } else {
                            System.out.println("User not found or removal failed.");
                        }

                        break;

                    case 3:

                        System.out.println(" Enter ID on the user you want information about");
                        int inputId = inputHandler.readIntInput();

                        User retrievedUser = initializedUserList.getUserbyId(inputId);

                        if (retrievedUser != null) {

                            System.out.println(retrievedUser);

                        } else {

                            System.out.println("User with ID " + inputId + " not found.");
                        }


                        break;

                    case 4:

                        // Skriv ut UserList sorterad efter namn.
                        System.out.println(initializedUserList);

                        break;

                    case 5:

                        // Skriv ut UserList sorterad efter ID.
                        initializedUserList.bubbleSortUsersByID();
                        break;


                    case 6:

                        System.out.println("Exiting the program");
                        System.exit(0);
                        break;


                }

            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
        }


    }

    // Initierar en Admin och lägger till den i UserList.
    // Initierar en UserList och returnerar den.

    public static UserList initializeUserList() {

        // Registrera starttiden
        long startTime = System.currentTimeMillis();

        // Skapa en instans av UserList.
        UserList userList = new UserList();

        // Skapa en ny AdminUser.
        AdminUser adminUser = new AdminUser("Admin", "Admin@hotmail.com", 137);

        // Anropa metoden setAdmin, sätter den på true och skapar ett lösenord.
        adminUser.setAdmin(true, "Jensen");


        userList.initializeUser(adminUser);
        userList.initializeUser(new User("Alex", "Alex@gmail.com", 107));
        userList.initializeUser(new User("Göran", "Göran@gmail.com", 789));
        userList.initializeUser(new User("Clara", "Clara@gmail.com", 999));
        userList.initializeUser(new User("Doris", "Doris@gmail.com", 642));
        userList.initializeUser(new User("Maria", "Maria@gmail.com", 332));
        userList.initializeUser(new User("Sara", "Sara@gmail.com", 722));
        userList.initializeUser(new User("Bengt", "Bengt@gmail.com", 106));
        userList.initializeUser(new User("Lars", "Lars@gmail.com", 101));


        // Registrera sluttiden
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("Total Elapsed Time for Initialization: " + elapsedTime + " milliseconds");

        return userList;


    }

}
