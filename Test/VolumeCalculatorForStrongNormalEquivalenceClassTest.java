import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class VolumeCalculatorForStrongNormalEquivalenceClassTest {
    @Parameterized.Parameters(name = "{index}: getVolume(length={0}, width={1}, height={2})={3}")
    public static Iterable<Integer[] > testCasesGenerator() {
        return VolumeCalculatorTestCasesGenerator.generateStrongNormalEquivalenceClassTestCases();
    }

    @Parameterized.Parameter
    public int length;
    @Parameterized.Parameter(1)
    public int width;
    @Parameterized.Parameter(2)
    public int height;
    @Parameterized.Parameter(3)
    public Integer result;

    @Test
    public void getVolume() {
        assertEquals(result.intValue(), VolumeCalculator.getVolume(length, width, height));
    }
}