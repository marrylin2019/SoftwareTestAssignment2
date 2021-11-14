import java.util.ArrayList;

public class NextDayDateTestCasesGenerator {
//    下述边界值的排列顺序为{年最小值，年最大值，月最小值，月最大值，日最小值，日最大值}
//    边界值分析仅针对不会相互影响的变量组，但年月日这三个变量显然会相互影响，取值待定
    private final static int[] boundaryValues = {0, 0, 0, 0, 0, 0};

    public static ArrayList<String[] > generateBoundaryTestCases() {
        // 总测试样例数为5
        ArrayList<String[] > result = new ArrayList<>();
        // min
        result.add(new String[]{"0000-01-01", StdNextDayDate.getNextDayDate("0000-01-01")});
        // min+
        result.add(new String[]{"0000-01-02", StdNextDayDate.getNextDayDate("0000-01-02")});
        // max-
        result.add(new String[]{"9999-12-30", StdNextDayDate.getNextDayDate("9999-12-30")});
        // max
        result.add(new String[]{"9999-12-31", StdNextDayDate.getNextDayDate("9999-12-31")});
        // normal
        String nom = TestUtils.getNDDNormalValue();
        result.add(new String[]{nom, StdNextDayDate.getNextDayDate(nom)});

        return result;
    }

    public static ArrayList<String[] > generateRobustnessTestCases() {
        // 总测试样例数为7
        ArrayList<String[] > result = new ArrayList<>();
        // min-
        result.add(new String[]{"0000-01-00", StdNextDayDate.getNextDayDate("0000-01-00")});
        // min
        result.add(new String[]{"0000-01-01", StdNextDayDate.getNextDayDate("0000-01-01")});
        // min+
        result.add(new String[]{"0000-01-02", StdNextDayDate.getNextDayDate("0000-01-02")});
        // max-
        result.add(new String[]{"9999-12-30", StdNextDayDate.getNextDayDate("9999-12-30")});
        // max
        result.add(new String[]{"9999-12-31", StdNextDayDate.getNextDayDate("9999-12-31")});
        // max+
        result.add(new String[]{"9999-12-32", StdNextDayDate.getNextDayDate("9999-12-32")});
        // normal
        String nom = TestUtils.getNDDNormalValue();
        result.add(new String[]{nom, StdNextDayDate.getNextDayDate(nom)});

        return result;
    }

    public static ArrayList<String[] > generateWorstCaseTestCases() {
        // 总测试样例数为5
        ArrayList<String[] > result = new ArrayList<>();
        // min
        result.add(new String[]{"0000-01-01", StdNextDayDate.getNextDayDate("0000-01-01")});
        // min+
        result.add(new String[]{"0000-01-02", StdNextDayDate.getNextDayDate("0000-01-02")});
        // max-
        result.add(new String[]{"9999-12-30", StdNextDayDate.getNextDayDate("9999-12-30")});
        // max
        result.add(new String[]{"9999-12-31", StdNextDayDate.getNextDayDate("9999-12-31")});
        // normal
        String nom = TestUtils.getNDDNormalValue();
        result.add(new String[]{nom, StdNextDayDate.getNextDayDate(nom)});

        return result;
    }

    public static ArrayList<String[] > generateRobustWorstCaseTestCases() {
        // 总测试样例数为7
        ArrayList<String[] > result = new ArrayList<>();
        // min-
        result.add(new String[]{"0000-01-00", StdNextDayDate.getNextDayDate("0000-01-00")});
        // min
        result.add(new String[]{"0000-01-01", StdNextDayDate.getNextDayDate("0000-01-01")});
        // min+
        result.add(new String[]{"0000-01-02", StdNextDayDate.getNextDayDate("0000-01-02")});
        // max-
        result.add(new String[]{"9999-12-30", StdNextDayDate.getNextDayDate("9999-12-30")});
        // max
        result.add(new String[]{"9999-12-31", StdNextDayDate.getNextDayDate("9999-12-31")});
        // max+
        result.add(new String[]{"9999-12-32", StdNextDayDate.getNextDayDate("9999-12-32")});
        // normal
        String nom = TestUtils.getNDDNormalValue();
        result.add(new String[]{nom, StdNextDayDate.getNextDayDate(nom)});

        return result;
    }

    public static ArrayList<String[] > generateStrongNormalEquivalenceClassTestCases() {
        // 总测试样例数2*3*5-7=23
        // 将年划分为闰年/非闰年，月划分为30天的月/31天的月/2月，日划分为28/29/30/31/普通取值
        // 刨除不合法的，包括
        // 闰年30天的月31, 闰年2月30, 闰年2月31, 非闰年30天的月31, 非闰年2月29, 非闰年2月30, 非闰年2月31
        ArrayList<String[] > result = new ArrayList<>();
        for (int iYear=0; iYear < 2; iYear++)
            for (int iMonth=0; iMonth < 3; iMonth++)
                for (int iDay=27; iDay < 32; iDay++) {
                    // 碰到不合法的数据就跳过
                    if (iMonth==1&&iDay==31 || iMonth==2&&iDay>=30 || iYear==0&&iMonth==2&&iDay==29) continue;
                    String arg = String.format("%04d-%02d-%02d", TestUtils.getYear(iYear), TestUtils.getMonth(iMonth), TestUtils.getDay(iDay));
                    result.add(new String[]{arg, StdNextDayDate.getNextDayDate(arg)});
                }
        return result;
    }

    public static ArrayList<String[] > generateStrongRobustEquivalenceClassTestCases() {
        // 总测试样例数为2*3*5=30
        // 将年划分为闰年/非闰年，月划分为30天的月/31天的月/2月，日划分为28/29/30/31/普通取值
        ArrayList<String[] > result = new ArrayList<>();
        for (int iYear=0; iYear < 2; iYear++)
            for (int iMonth=0; iMonth < 3; iMonth++)
                for (int iDay=27; iDay < 32; iDay++) {
                    String arg = String.format("%04d-%02d-%02d", TestUtils.getYear(iYear), TestUtils.getMonth(iMonth), TestUtils.getDay(iDay));
                    result.add(new String[]{arg, StdNextDayDate.getNextDayDate(arg)});
                }
        return result;
    }
}