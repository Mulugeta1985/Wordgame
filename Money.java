class Money implements Award {
        private int winningAmount = 100;
        private int losingAmount = 50;

        public int displayWinnings(Players player, boolean correctGuess) {
                if (correctGuess) {
                        System.out.println(player.getName() + " won " + winningAmount + "$");
                        return winningAmount;
                } else {
                        System.out.println(player.getName() + " lost " + losingAmount + "$");
                        return -losingAmount;
                }
        }

}