import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class NextDayDateForRobustnessTest {
    @Parameters(name = "{index}: getNextDayDate({0})={1}")
    public static Iterable<String[] > testCasesGenerator() {
        return NextDayDateTestCasesGenerator.generateBoundaryTestCases();
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
