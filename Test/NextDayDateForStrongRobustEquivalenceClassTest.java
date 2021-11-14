import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class NextDayDateForStrongRobustEquivalenceClassTest {
    @Parameters(name = "{index}: getNextDayDate({0})={1}")
    public static Iterable<String[] > testCasesGenerator() {
        return NextDayDateTestCasesGenerator.generateStrongRobustEquivalenceClassTestCases();
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
