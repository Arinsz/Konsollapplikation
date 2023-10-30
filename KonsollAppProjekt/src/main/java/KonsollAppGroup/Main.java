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

       
        UserList initializedUserList = initializeUserList();
        InputHandler inputHandler = new InputHandler();

        while (true) {

            try {

                System.out.println(" ******  Menu: ******");
                System.out.println("1. Add new user");
                System.out.println("2. Remove user");
                System.out.println("3. Get user-information");
                System.out.println("4. List all users sorted by name");  
                System.out.println("5. List all users sorted by ID"); 
                System.out.println("6. Exit");
                System.out.print("Enter your choice with a number from 1-6: ");

                int choice = inputHandler.readIntInput();


                switch (choice) {


                    case 1:

                     
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

                        User user = new User(newUsername, newEmail, newId);

                        try {
                        
                            initializedUserList.addUser(user);

                        } catch (IllegalStateException e) {
                            System.out.println("Error: " + e.getMessage());
                            System.out.println("Please try again.");
                        }

                        break;

                    case 2:

                        System.out.println("Enter Username or ID on the user you want to remove");
                        String userToRemove = inputHandler.readStringInput(1, 20);

                    
                        boolean userRemoved = false;


                        try {
                          
                            int userId = Integer.parseInt(userToRemove);

                           
                            userRemoved = initializedUserList.removeUserByNameOrId(null, userId);
                        } catch (NumberFormatException e) {

                           
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

                    
                        System.out.println(initializedUserList);

                        break;

                    case 5:

                      
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



    public static UserList initializeUserList() {

   
        long startTime = System.currentTimeMillis();

      
        UserList userList = new UserList();

      
        AdminUser adminUser = new AdminUser("Admin", "Admin@hotmail.com", 137);

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


        
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("Total Elapsed Time for Initialization: " + elapsedTime + " milliseconds");

        return userList;


    }

}
