import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class VolumeCalculatorForRobustnessTest {
    @Parameters(name = "{index}: getVolume(length={0}, width={1}, height={2})={3}")
    public static Iterable<Integer[] > testCasesGenerator() {
        return VolumeCalculatorTestCasesGenerator.generateRobustnessTestCases();
    }

    @Parameter
    public int length;
    @Parameter(1)
    public int width;
    @Parameter(2)
    public int height;
    @Parameter(3)
    public Integer result;

    @Test
    public void getVolume() {
        assertEquals(result.intValue(), VolumeCalculator.getVolume(length, width, height));
    }
}