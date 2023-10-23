package KonsollAppGroup;

/**
 * Klassen User representerar en användare med ett användarnamn, e-postadress och användarens-ID.
 * Den tillhandahåller metoder för att ställa in och hämta användarinformation med lämplig validering.
 */

public class User {

    private String userName;
    private String userEmail;
    private int userId;

    /**
     * Konstruktören för User tar emot användarnamn, e-postadress och ID och skapar en ny användare.
     */

    public User(String userName, String userEmail, int userId) {
        setUserName(userName);
        setUserEmail(userEmail);
        setUserId(userId);
    }

    /**
     * Hämtar användarnamnet. Kastar ett undantag om användarnamnet är tomt eller saknas.
     */
    public String getUserName() {
        if (!userName.isEmpty()) {
            return userName;
        } else {
            throw new IllegalStateException(" Username was not found or is empty ");
        }

    }

    /**
     * Ställer in användarnamnet. Kastar ett undantag om användarnamnet är tomt.
     */
    public void setUserName(String userName) {
        if (!userName.isEmpty()) {
            this.userName = userName;
        } else {
            throw new IllegalArgumentException("Username must not be empty");

        }
    }

    /**
     * Hämtar e-postadressen. Kastar ett undantag om e-postadressen är tomt eller saknas.
     */

    public String getUserEmail() {
        if (!userEmail.isEmpty()) {
            return userEmail;
        } else {
            throw new IllegalStateException(" E-mail adress not found or is empty");
        }
    }

    /**
     * Ställer in e-postadressen. Kastar ett undantag om e-postadressen är tomt.
     */

    public void setUserEmail(String userEmail) {
        if (!userEmail.isEmpty()) {
            this.userEmail = userEmail;
        } else {
            throw new IllegalStateException(" E-mail must not be empty ");
        }
    }

    /**
     * Hämtar användarens-ID. Kastar ett undantag om användarens-ID inte är giltigt.
     */
    public int getUserId() {
        if (userId > 0) {
            return userId;
        } else {
            throw new IllegalStateException("User ID not found or is invalid.");
        }
    }

    /**
     * Ställer in användarens-ID. Kastar ett undantag om användarens-ID inte är ett positivt heltal.
     */

    public void setUserId(int userId) {
        if (userId > 0) {
            this.userId = userId;
        } else {
            throw new IllegalArgumentException("User ID must be a positive number.");
        }
    }

    /**
     * Genererar en strängrepresentation av User-objektet.
     */
    @Override
    public String toString() {
        return String.format("User ID: %-4d Name: %-6s Email: %-4s",
                userId, userName, userEmail);
    }


}
