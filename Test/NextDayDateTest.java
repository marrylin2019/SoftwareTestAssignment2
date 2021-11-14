import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class NextDayDateTest {
//    下述边界值的排列顺序为{年最小值，年最大值，月最小值，月最大值，日最小值，日最大值}
//    边界值分析仅针对不会相互影响的变量组，但年月日这三个变量显然会相互影响，取值待定
    final static int[] boundaryValues = {0, 0, 0, 0, 0, 0};

    @Parameters(name = "{index}: getNextDayDate({0})={1}")
    public static Collection<String[]> testCasesGenerator() {
        ArrayList<String[]> result = new ArrayList<String[]>();
        // Boundary Value Analysis
        // Robustness Testing
        // Worst-Case
        // Robust Worst Case
        // Strong Normal Equivalence Class Testing
        // Strong Robust Equivalence Class Testing
        return result;
    }

    @Parameter
    public String date;
    @Parameter(1)
    public String nextDate;

    @Test
    public void getNextDayDate() {
        assertEquals(nextDate, NextDayDate.overwrapGetNextDayDate(date));
    }
}