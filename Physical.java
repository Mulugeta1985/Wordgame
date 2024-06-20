import java.util.Random;

class Physical implements Award {
        private String[] physicalPrizes = { "Television", "Laptop", "Smartphone", "Tablet", "Game Console" };

        public int getRandomPrize() {
                Random random = new Random();
                return random.nextInt(physicalPrizes.length);
        }

        public int displayWinnings(Players player, boolean correctGuess) {
                if (correctGuess) {
                        int prizeIndex = getRandomPrize();
                        System.out.println(player.getName() + " won " + physicalPrizes[prizeIndex]);
                        return 0;
                } else {
                        int prizeIndex = getRandomPrize();
                        System.out.println(player.getName() + " could have won " + physicalPrizes[prizeIndex]);
                        return 0;
                }
        }
}
