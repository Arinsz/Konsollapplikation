package KonsollAppGroup;

import java.util.Scanner;

/**
 * ____________________________________________________________________________________________________________________
 * Klassen InputHandler hanterar användarinmatning från konsolen. Den erbjuder metoder för att läsa heltal och strängar
 * med validering av längd och tomma strängar.
 */

public class InputHandler {

    private final Scanner scanner;

    /**
     * _______________________________________________________________________________________________
     * Konstruktören skapar en Scanner som används för att läsa inmatning från användaren via konsolen.
     */

    public InputHandler() {

        scanner = new Scanner(System.in);

    }

    /**
     * ______________________________________________________________________________________________________________
     * Läser ett heltal från användaren och returnerar det. Om användaren inte anger ett heltal, upprepas inmatningen.
     */
    public int readIntInput() {

        while (true) {

            try {

                // Försök att tolka inmatningen som ett heltal.
                return Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {

                // Om ett NumberFormatException kastas (inmatningen är inte ett giltigt heltal), visa ett felmeddelande.
                System.out.println("Invalid input.");
            }
        }
    }

    /**
     * ______________________________________________________________________________________________________
     * Läser en sträng från användaren och returnerar den efter att ha kontrollerat längden och om den är tom.
     * Om strängen är tom eller inte ligger inom angivna längdgränser, upprepas inmatningen.
     *
     * @param minLength Minsta tillåtna längd för strängen.
     * @param maxLength Högsta tillåtna längd för strängen.
     */

    public String readStringInput(int minLength, int maxLength) {
        while (true) {

            String input = scanner.nextLine().trim();

            // Kontrollera om inmatningen är tom och kasta ett undantag om så är fallet.
            if (input.isEmpty()) {

                throw new IllegalArgumentException("Input must not be empty. ");

                // Kontrollera om längden på inmatningen inte stämmer, kasta ett undantag om så är fallet.
            } else if (input.length() < minLength || input.length() > maxLength) {

                throw new IllegalArgumentException("Input must be between " + minLength + " and " + maxLength + " characters.");

            } else {

                return input;

            }

        }

    }
}

