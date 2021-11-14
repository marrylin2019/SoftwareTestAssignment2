import java.util.ArrayList;

public class NextDayDateTestCasesGenerator {
//    下述边界值的排列顺序为{年最小值，年最大值，月最小值，月最大值，日最小值，日最大值}
//    边界值分析仅针对不会相互影响的变量组，但年月日这三个变量显然会相互影响，取值待定
    private final static int[] boundaryValues = {0, 0, 0, 0, 0, 0};

    public static ArrayList<String[] > generateBoundaryTestCases() {
        ArrayList<String[] > result = new ArrayList<>();
        result.add(new String[]{"0000-01-01",StdNextDayDate.getNextDayDate("0000-01-01")});
        result.add(new String[]{"0000-01-02",StdNextDayDate.getNextDayDate("0000-01-02")});
        result.add(new String[]{"9999-12-31",StdNextDayDate.getNextDayDate("9999-12-31")});
        result.add(new String[]{"9999-12-30",StdNextDayDate.getNextDayDate("9999-12-30")});
        result.add(new String[]{"2021-11-14",StdNextDayDate.getNextDayDate("2021-11-14")});
        return result;
    }

    public static ArrayList<String[] > generateRobustnessTestCases() {
        ArrayList<String[] > result = new ArrayList<>();
        result.add(new String[]{"0000-01-01",StdNextDayDate.getNextDayDate("0000-01-01")});
        result.add(new String[]{"0000-01-02",StdNextDayDate.getNextDayDate("0000-01-02")});
        result.add(new String[]{"9999-12-31",StdNextDayDate.getNextDayDate("9999-12-31")});
        result.add(new String[]{"9999-12-30",StdNextDayDate.getNextDayDate("9999-12-30")});
        result.add(new String[]{"2021-11-14",StdNextDayDate.getNextDayDate("2021-11-14")});
        result.add(new String[]{"0000-01-00",StdNextDayDate.getNextDayDate("0000-01-00")});
        result.add(new String[]{"9999-12-32",StdNextDayDate.getNextDayDate("9999-12-32")});
        return result;
    }

    public static ArrayList<String[] > generateWorstCaseTestCases() {
        ArrayList<String[] > result = new ArrayList<>();
        result.add(new String[]{"0000-01-01",StdNextDayDate.getNextDayDate("0000-01-01")});
        result.add(new String[]{"0000-01-02",StdNextDayDate.getNextDayDate("0000-01-02")});
        result.add(new String[]{"9999-12-31",StdNextDayDate.getNextDayDate("9999-12-31")});
        result.add(new String[]{"9999-12-30",StdNextDayDate.getNextDayDate("9999-12-30")});
        result.add(new String[]{"2021-11-14",StdNextDayDate.getNextDayDate("2021-11-14")});
        return result;
    }

    public static ArrayList<String[] > generateRobustWorstCaseTestCases() {
        ArrayList<String[] > result = new ArrayList<>();
        result.add(new String[]{"0000-01-01",StdNextDayDate.getNextDayDate("0000-01-01")});
        result.add(new String[]{"0000-01-02",StdNextDayDate.getNextDayDate("0000-01-02")});
        result.add(new String[]{"9999-12-31",StdNextDayDate.getNextDayDate("9999-12-31")});
        result.add(new String[]{"9999-12-30",StdNextDayDate.getNextDayDate("9999-12-30")});
        result.add(new String[]{"2021-11-14",StdNextDayDate.getNextDayDate("2021-11-14")});
        result.add(new String[]{"0000-01-00",StdNextDayDate.getNextDayDate("0000-01-00")});
        result.add(new String[]{"9999-12-32",StdNextDayDate.getNextDayDate("9999-12-32")});
        return result;
    }

    public static ArrayList<String[] > generateStrongNormalEquivalenceClassTestCases() {
        ArrayList<String[] > result = new ArrayList<>();
        return result;
    }

    public static ArrayList<String[] > generateStrongRobustEquivalenceClassTestCases() {
        ArrayList<String[] > result = new ArrayList<>();
        return result;
    }
}
