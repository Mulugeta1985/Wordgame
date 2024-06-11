class Players {
        private String name;
        private int money;

        public Players(String name) {
                this.name = name;
        }

        public Players(String name, String lastName) {
                this.name = name + " " + lastName;
        }

        public void setMoney(int money) {
                this.money = money;
        }

        public void addMoney(int money) {
                this.money += money;
        }

        public int getMoney() {
                return money;
        }

        public String getName() {
                return name;
        }
}
