import java.util.Scanner;

public class GamePlay {
        private Person player;

        public static void main(String[] args) {
                GamePlay game = new GamePlay();
                game.initializePlayer(game);

        }

        private void initializePlayer(GamePlay game) {
                try (Scanner scanner = new Scanner(System.in)) {
                        System.out.print("Enter your name: ");
                        String firstName = scanner.nextLine();
                        System.out.print("Would you like to enter a last name? (yes/no): ");
                        String response = scanner.nextLine();

                        if (response.equalsIgnoreCase("yes")) {
                                System.out.print("Enter your last name: ");
                                String lastName = scanner.nextLine();
                                player = new Person(firstName, lastName);
                        } else {
                                player = new Person(firstName);
                        }

                        game.startGame();

                }

        }

        private void startGame() {
                Numbers numberToGuess = new Numbers();
                numberToGuess.generateNumber();

                try (Scanner scannerGues = new Scanner(System.in)) {
                        boolean guessedCorrectly = false;

                        while (!guessedCorrectly) {
                                System.out.print(player.getFirstName() + ", enter your guess: ");
                                int guess = scannerGues.nextInt();
                                guessedCorrectly = numberToGuess.compareNumber(guess);
                        }
                }
        }
}
