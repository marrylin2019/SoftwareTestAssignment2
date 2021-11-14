import java.util.ArrayList;

public class VolumeCalculatorTestCasesGenerator {
    /**   getVolume(length={0}, width={1}, height={2})={3}  **/
    final static int NUM_OF_VAR = 3;  // Variables
    //    下述边界值的排列顺序为{长最小值，长最大值，宽最小值，宽最大值，高最小值，高最大值}
    final static int[] boundaryVals = {2, 100, 5, 200, 20, 80};

    public static ArrayList<Integer[] > generateBoundaryTestCases() {
        final int NUM_OF_BSV = 4;  // Boundary Test Special Value

        ArrayList<Integer[] > result = new ArrayList<>();
        for (int iVar=0; iVar < NUM_OF_VAR; iVar++) {
            //                   min,                  min+,                   max-,                     max
            int[] specialVals = {boundaryVals[2*iVar], boundaryVals[2*iVar]+1, boundaryVals[2*iVar+1]-1, boundaryVals[2*iVar+1]};
            for (int iType = 0; iType < NUM_OF_BSV; iType++) { // 遍历全部特殊值
                Integer[] testCase = new Integer[NUM_OF_VAR+1];
                testCase[NUM_OF_VAR] = 1;
                for (int var = 0; var < NUM_OF_VAR; var++) // 遍历全部变量，为每个变量赋随机生成的普通值
                    testCase[var] = TestUtils.getNormalValue(boundaryVals[2 * var], boundaryVals[2 * var + 1]);
                testCase[iVar] = specialVals[iType];    // 给指定位置的变量赋特殊值
                testCase[NUM_OF_VAR] = StdVolumeCalculator.getVolume(testCase[0],testCase[1], testCase[2]); // 计算expectedOutput

                result.add(testCase);                   // 将该测试样例添加进测试样例集
            }
        }
        int nom_len=TestUtils.getNormalValue(boundaryVals[0], boundaryVals[1]),
                nom_wth=TestUtils.getNormalValue(boundaryVals[2], boundaryVals[3]),
                nom_hgt=TestUtils.getNormalValue(boundaryVals[4], boundaryVals[5]);
        // 添加全为普通值的测试样例
        result.add(new Integer[]{nom_len, nom_wth, nom_hgt, StdVolumeCalculator.getVolume(nom_len, nom_wth, nom_hgt)});

        return result;
    }

    public static ArrayList<Integer[] > generateRobustnessTestCases() {
        final int NUM_OF_RSV = 6;  // Boundary Test Special Value

        ArrayList<Integer[] > result = new ArrayList<>();
        for (int iVar=0; iVar < NUM_OF_VAR; iVar++) {
            //                   min-                    min,                  min+,                   max-,                     max                     max+
            int[] specialVals = {boundaryVals[2*iVar]-1, boundaryVals[2*iVar], boundaryVals[2*iVar]+1, boundaryVals[2*iVar+1]-1, boundaryVals[2*iVar+1], boundaryVals[2*iVar+1]+1};
            for (int iType = 0; iType < NUM_OF_RSV; iType++) { // 遍历全部特殊值
                Integer[] testCase = new Integer[NUM_OF_VAR+1];
                testCase[NUM_OF_VAR] = 1;
                for (int var = 0; var < NUM_OF_VAR; var++) // 遍历全部变量，为每个变量赋随机生成的普通值
                    testCase[var] = TestUtils.getNormalValue(boundaryVals[2 * var], boundaryVals[2 * var + 1]);
                testCase[iVar] = specialVals[iType];    // 给指定位置的变量赋特殊值
                testCase[NUM_OF_VAR] = StdVolumeCalculator.getVolume(testCase[0],testCase[1], testCase[2]); // 计算expectedOutput

                result.add(testCase);                   // 将该测试样例添加进测试样例集
            }
        }
        int nom_len=TestUtils.getNormalValue(boundaryVals[0], boundaryVals[1]),
                nom_wth=TestUtils.getNormalValue(boundaryVals[2], boundaryVals[3]),
                nom_hgt=TestUtils.getNormalValue(boundaryVals[4], boundaryVals[5]);
        // 添加全为普通值的测试样例
        result.add(new Integer[]{nom_len, nom_wth, nom_hgt, StdVolumeCalculator.getVolume(nom_len, nom_wth, nom_hgt)});

        return result;
    }

    public static ArrayList<Integer[] > generateWorstCaseTestCases() {
        final int NUM = 5;  // Worst Case Test All values number
        Integer[][] tmpVals = new Integer[NUM_OF_VAR][NUM];

        ArrayList<Integer[] > result = new ArrayList<>();
        for (int iVar=0; iVar < NUM_OF_VAR; iVar++)
            //                            min,                  min+,                   max-,                     max,                    normal
            tmpVals[iVar] = new Integer[]{boundaryVals[2*iVar], boundaryVals[2*iVar]+1, boundaryVals[2*iVar+1]-1, boundaryVals[2*iVar+1], TestUtils.getNormalValue(boundaryVals[2*iVar], boundaryVals[2*iVar+1])};
        // worst case test需要5^n个测试样例，即
        for (int i=0; i < NUM; i++)
            for (int j=0; j < NUM; j++)
                for (int k=0; k < NUM; k++) {
                    int len=tmpVals[0][i], wdh=tmpVals[1][j], hgt=tmpVals[2][k];
                    result.add(new Integer[]{len, wdh, hgt, StdVolumeCalculator.getVolume(len, wdh, hgt)});
                }
        return result;
    }

    public static ArrayList<Integer[] > generateRobustWorstCaseTestCases() {
        final int NUM = 7;  // Worst Case Test All values number
        Integer[][] tmpVals = new Integer[NUM_OF_VAR][NUM];

        ArrayList<Integer[] > result = new ArrayList<>();
        for (int iVar=0; iVar < NUM_OF_VAR; iVar++)
            //                            min-,                   min,                  min+,                   max-,                     max,                    max+,                     normal
            tmpVals[iVar] = new Integer[]{boundaryVals[2*iVar]-1, boundaryVals[2*iVar], boundaryVals[2*iVar]+1, boundaryVals[2*iVar+1]-1, boundaryVals[2*iVar+1], boundaryVals[2*iVar+1]+1, TestUtils.getNormalValue(boundaryVals[2*iVar], boundaryVals[2*iVar+1])};

        for (int i=0; i < NUM; i++)
            for (int j=0; j < NUM; j++)
                for (int k=0; k < NUM; k++) {
                    int len=tmpVals[0][i], wdh=tmpVals[1][j], hgt=tmpVals[2][k];
                    result.add(new Integer[]{len, wdh, hgt, StdVolumeCalculator.getVolume(len, wdh, hgt)});
                }
        return result;
    }

    public static ArrayList<Integer[] > generateStrongNormalEquivalenceClassTestCases() {
        ArrayList<Integer[]> result = new ArrayList<>();
        return result;
    }

    public static ArrayList<Integer[] > generateStrongRobustEquivalenceClassTestCases() {
        ArrayList<Integer[]> result = new ArrayList<>();
        return result;
    }

}
