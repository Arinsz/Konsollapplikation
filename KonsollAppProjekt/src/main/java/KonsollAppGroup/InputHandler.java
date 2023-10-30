package KonsollAppGroup;

import java.util.Scanner;

/**
 * Klassen InputHandler hanterar användarinmatning från konsolen. Den erbjuder metoder för att läsa heltal och strängar
 * med validering av längd och tomma strängar.
 */

public class InputHandler {

    private final Scanner scanner;

 

    public InputHandler() {

        scanner = new Scanner(System.in);

    }

    /**
     * Läser ett heltal från användaren och returnerar det. Om användaren inte anger ett heltal, upprepas inmatningen.
     */
    public int readIntInput() {

        while (true) {

            try {

                return Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {

               
                System.out.println("Invalid input.");
            }
        }
    }

    /**
     * Läser en sträng från användaren och returnerar den efter att ha kontrollerat längden och om den är tom.
     * Om strängen är tom eller inte ligger inom angivna längdgränser, upprepas inmatningen.
     *
     * @param minLength Minsta tillåtna längd för strängen.
     * @param maxLength Högsta tillåtna längd för strängen.
     */

    public String readStringInput(int minLength, int maxLength) {
        while (true) {

            String input = scanner.nextLine().trim();

           
            if (input.isEmpty()) {

                throw new IllegalArgumentException("Input must not be empty. ");

            } else if (input.length() < minLength || input.length() > maxLength) {

                throw new IllegalArgumentException("Input must be between " + minLength + " and " + maxLength + " characters.");

            } else {

                return input;

            }

        }

    }
}

