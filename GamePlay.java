import java.util.Scanner;

public class GamePlay {

        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                Host host = new Host("Jack");
                Player player = new Player("Jack");

                Turn turn = new Turn(20, 5);

                boolean keepPlaying = true;
                host.generateRandomNumber();
                while (keepPlaying) {

                        boolean guessedCorrectly = false;
                        while (!guessedCorrectly) {

                                guessedCorrectly = turn.takeTurn(player, host);
                                if (guessedCorrectly) {
                                        System.out.println("Congratulations! You guessed the number.");
                                } else {
                                        System.out.println("Try again!");
                                }
                        }

                        System.out.println("Do you want to keep playing? (yes/no)");
                        String choice = scanner.next();
                        if (choice.equalsIgnoreCase("no")) {
                                keepPlaying = false;
                        } else {
                                host.generateRandomNumber();
                        }
                }
        }
}