import java.util.Scanner;

public class Turn {
        private int amountForCorrectGuess;
        private int amountForIncorrectGuess;

        public Turn(int amountForCorrectGuess, int amountForIncorrectGuess) {
                this.amountForCorrectGuess = amountForCorrectGuess;
                this.amountForIncorrectGuess = amountForIncorrectGuess;
        }

        public boolean takeTurn(Player player, Host host) {
                Scanner scanner = new Scanner(System.in);
                System.out.println(" prompts " + host.getFirstName()
                                + " to enter a guess for the random number between 0 and 100: ");
                int guess = scanner.nextInt();

                if (guess == Numbers.randomNum) {
                        player.setMoney(player.getMoney() + amountForCorrectGuess);
                        System.out.println("Congratulations, " + host.getFirstName() + " is the winner!");
                        System.out.println(player.toString());
                        return true;
                } else {
                        player.setMoney(player.getMoney() - amountForIncorrectGuess);
                        System.out.println(player.getFirstName() + " guessed incorrectly.");
                        System.out.println(player.toString());
                        if (guess < Numbers.randomNum) {
                                System.out.println("Your guess was too low.");
                        } else {
                                System.out.println("Your guess was too high.");
                        }
                        return false;
                }
        }
}
