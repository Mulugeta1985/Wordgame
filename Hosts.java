
import java.util.Scanner;

public class Hosts {
        private static Scanner scanner = new Scanner(System.in);

        public void createPharase() {
                System.out.print("Enter a phrase for the players to guess: ");
                String phrase = scanner.nextLine();
                Phrases phrases = new Phrases(phrase);

                System.out.println("Playing Phrase: " + phrases.getPlayingPhrase());
        }
}
