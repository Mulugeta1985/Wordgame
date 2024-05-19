import java.util.Random;

public class Numbers {
        public static int randomNum;

        public int getRandomNum() {
                return randomNum;
        }

        public void setRandomNum(int randomNum) {
                this.randomNum = randomNum;
        }

        public static void generateNumber() {
                Random rand = new Random();
                randomNum = rand.nextInt(101);

        }

}
