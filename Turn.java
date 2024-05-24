
import java.util.Random;
import java.util.Scanner;

public class Turn {

        public boolean takeTurn(Players player, Host host, int generatedRandomNumber) {
                boolean retValue = false;
                Scanner scanner = new Scanner(System.in);
                System.out.println(" Player  " + player.getName()
                                + " Turn to enter a guess for the random number between 0 and 100: ");
                int guess = scanner.nextInt();

                if (guess == generatedRandomNumber) {

                        int priceRanNumber = getRandomPrize();
                        if (priceRanNumber < 6) {
                                Money money = new Money();
                                money.displayWinnings(player, true);
                        } else {
                                Physical award = new Physical();
                                award.displayWinnings(player, true);
                        }
                        retValue = true;

                } else {
                        int priceRanNumber = getRandomPrize();
                        if (priceRanNumber < 6) {
                                Money money = new Money();
                                money.displayWinnings(player, false);
                        } else {
                                Physical award = new Physical();
                                award.displayWinnings(player, false);
                        }
                        retValue = false;
                }

                return retValue;
        }

        public int generateRandomNumber() {
                Random rand = new Random();
                return (int) rand.nextInt(101);

        }

        public int getRandomPrize() {
                Random rand = new Random();
                return (int) rand.nextInt(11);
        }
}
