package KonsollAppGroup;


/**
 * Denna klass representerar en administratörsanvändare i konsolapplikationen. Den ärver
 * från klassen User och inkluderar egenskaper som användarnamn, e-postadress och användar-ID.
 * Klassen har också möjlighet att ställa in adminstatus och administratörslösenord.
 */

public class AdminUser extends User {
    private boolean isAdmin;
    private String adminPassword;

    public AdminUser(String userName, String userEmail, int userId) {
        super(userName, userEmail, userId);
        this.isAdmin = true;   
        this.adminPassword = null; 
    }


    /**
     * Ange admin-status och lösenord för AdminUser.
     *
     * @param isAdmin  Sant om användaren är en administratör, annars falskt.
     * @param password Lösenordet som ska lagras.
     * @throws IllegalArgumentException Om det angivna lösenordet är tomt eller null.
     */

    public void setAdmin(boolean isAdmin, String password) {

        if (password != null && !password.isEmpty()) {

            this.isAdmin = isAdmin;

            this.adminPassword = password;

        } else {

            throw new IllegalArgumentException("Please enter a password");
        }
    }

}
