import java.util.Random;

public class TestUtils {
    public static Integer getNormalValue(int min, int max) {
        return new Random(System.currentTimeMillis()).nextInt(max)%(max-min+1) + min;
    }
}
