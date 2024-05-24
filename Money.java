public class Money implements Award {
        private int winningAmount = 100;
        private int losingAmount = 50;

        public int displayWinnings(Players playerr, boolean correctGuess) {
                if (correctGuess) {
                        System.out.println(playerr.getName() + " won " + winningAmount + "$");
                        return winningAmount;
                } else {
                        System.out.println(playerr.getName() + " you could have won  " + losingAmount + "$");
                        return -losingAmount;
                }
        }

}
