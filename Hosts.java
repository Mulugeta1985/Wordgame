import java.util.Scanner;

public class Hosts {
        private static Scanner scanner = new Scanner(System.in);

        public void createPharase() {
                System.out.print("Enter a phrase for the players to guess: ");
                String phrase = scanner.nextLine();
                Phrases phrases = new Phrases(phrase);

                System.out.println("Playing Phrase: " + phrases.getPlayingPhrase());
        }

        // public static void main(String[] args) {
        //
        //
        // System.out.print("Enter a phrase for the players to guess: ");
        // String phrase = scanner.nextLine();
        // Phrases phrases = new Phrases(phrase);
        //
        // System.out.println("Playing Phrase: " + phrases.getPlayingPhrase());
        //
        // boolean playAgain = true;
        // while (playAgain) {
        // System.out.print("Enter 'Y' to play again, or any other key to exit: ");
        // String playChoice = scanner.nextLine();
        //
        // if (!playChoice.equalsIgnoreCase("Y")) {
        // playAgain = false;
        // break;
        // }
        //
        // System.out.print("Enter a new phrase for the players to guess: ");
        // phrase = scanner.nextLine();
        // phrases = new Phrases(phrase);
        //
        // System.out.println("Playing Phrase: " + phrases.getPlayingPhrase());
        // }
        // }
}
