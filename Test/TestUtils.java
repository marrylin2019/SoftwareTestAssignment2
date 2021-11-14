import java.util.Random;

public class TestUtils {
    public static Integer getNormalValue(int min, int max) {
        return new Random(System.currentTimeMillis()).nextInt(max)%(max-min+1) + min;
    }

    public static int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    public static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
