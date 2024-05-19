public class Player extends Person {
        private int money;

        public Player(String firstName) {
                super(firstName);
                this.money = 1000;

        }

        public int getMoney() {
                return money;
        }

        public void setMoney(int money) {
                this.money = money;
        }

        @Override
        public String toString() {
                return "Player: " + getFirstName() + ", Money: " + money;
        }

}
