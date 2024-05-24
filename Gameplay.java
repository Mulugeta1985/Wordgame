import java.util.Scanner;

public class Gameplay {

        private Players[] currentPlayers;
        boolean keepPlaying = true;
        Scanner scanner = new Scanner(System.in);
        int randomNumber = 0;

        public Gameplay() {
                currentPlayers = new Players[3];
        }

        public void startGame() {

                for (int i = 0; i < 3; i++) {
                        System.out.print("Enter player " + (i + 1) + " name: ");
                        String playerName = scanner.nextLine();
                        currentPlayers[i] = new Players(playerName);
                }

                Turn turn = new Turn();

                randomNumber = turn.generateRandomNumber();

                Host host = new Host();
                System.out.println("Game is starting with the following players:");
                for (Players player : currentPlayers) {
                        System.out.println(player.getName());

                }

                while (keepPlaying) {
                        for (Players player : currentPlayers) {

                                boolean guessedCorrectly = turn.takeTurn(player, host, randomNumber);

                                if (guessedCorrectly == true) {
                                        System.out.println("Do you want to keep playing? (yes/no)");
                                        String choice = scanner.next();
                                        if (choice.equalsIgnoreCase("no")) {
                                                keepPlaying = false;
                                                break;

                                        } else {

                                                randomNumber = turn.generateRandomNumber();

                                        }
                                }

                        }
                }

        }

        public static void main(String[] args) {
                Gameplay gameObj = new Gameplay();
                gameObj.startGame();

        }
}
