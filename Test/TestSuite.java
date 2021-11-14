import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    NextDayDateTest.class,
    VolumeCalculatorForBoundaryTest.class,
    VolumeCalculatorForRobustnessTest.class,
    VolumeCalculatorForWorstCaseTest.class,
    VolumeCalculatorForRobustWorstCaseTest.class,
    VolumeCalculatorForStrongNormalEquivalenceClassTest.class,
    VolumeCalculatorForStrongRobustEquivalenceClassTest.class
})
public class TestSuite {
}
