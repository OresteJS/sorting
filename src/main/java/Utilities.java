import java.util.Random;

public class Utilities {

    public static int[] getRandomNumbers(int x) {
        int[] numbers = new int[x];
        Random random = new Random();
        for (int i = 0; i < x; i++) {
            numbers[i] = random.nextInt();
        }
        return numbers;
    }
}
