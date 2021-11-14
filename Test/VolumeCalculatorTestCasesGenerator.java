import java.util.ArrayList;
import java.util.HashSet;

public class VolumeCalculatorTestCasesGenerator {
    /**   getVolume(length={0}, width={1}, height={2})={3}  **/
    final static int NUM_OF_VAR = 3;  // Variables
    //    下述边界值的排列顺序为{长最小值，长最大值，宽最小值，宽最大值，高最小值，高最大值}
    final static int[] boundaryVals = {2, 100, 5, 200, 20, 80};

    public static ArrayList<Integer[] > generateBoundaryTestCases() {
        // 总测试样例数为4*NUM_OF_VAR+1=13
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
        // 总测试样例数为6*NUM_OF_VAR+1=19
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
        // 总测试样例数为5^NUM_OF_VAR=125
        final int NUM = 5;  // Worst Case Test All values number
        Integer[][] tmpVals = new Integer[NUM_OF_VAR][NUM];

        ArrayList<Integer[] > result = new ArrayList<>();
        for (int iVar=0; iVar < NUM_OF_VAR; iVar++)
            //                            min,                  min+,                   max-,                     max,                    normal
            tmpVals[iVar] = new Integer[]{boundaryVals[2*iVar], boundaryVals[2*iVar]+1, boundaryVals[2*iVar+1]-1, boundaryVals[2*iVar+1], TestUtils.getNormalValue(boundaryVals[2*iVar], boundaryVals[2*iVar+1])};
        // worst case test需要5^n个测试样例，即对于每个变量都遍历全部的取值（对于worst case test来说是5个），因此做3重循环
        for (int i=0; i < NUM; i++)
            for (int j=0; j < NUM; j++)
                for (int k=0; k < NUM; k++) {
                    int len=tmpVals[0][i], wdh=tmpVals[1][j], hgt=tmpVals[2][k];
                    result.add(new Integer[]{len, wdh, hgt, StdVolumeCalculator.getVolume(len, wdh, hgt)});
                }
        return result;
    }

    public static ArrayList<Integer[] > generateRobustWorstCaseTestCases() {
        // 总测试样例数为7^NUM_OF_VAR+1=343
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
        // 总测试样例数为3
        // 此等价类划分依据结果进行
        // 划分为正方体体积，柱体体积及普通长方体(三边均不相等)体积
        // 由此，结果导向的等价类划分只有一个变量，因此测试样例数为3
        ArrayList<Integer[]> result = new ArrayList<>();
        /** cube **/
        // 生成正方体的边长，算法为取三边长度范围的左边界值中最大值为随机数函数的下界，右边界值中的最小值为上界
        int sideLen = TestUtils.getNormalValue(TestUtils.max(boundaryVals[0], boundaryVals[2], boundaryVals[4]), TestUtils.min(boundaryVals[1], boundaryVals[3], boundaryVals[5]));
        result.add(new Integer[]{sideLen, sideLen, sideLen, StdVolumeCalculator.getVolume(sideLen, sideLen, sideLen)});
        /** cylinder **/
        Integer[] tmpDate = new Integer[NUM_OF_VAR+1];
        // 随机选出一条不相等的边，生成相等边的长度，算法同上
        int notEqualSideId = TestUtils.getNormalValue(0, 2),
            equalSideLen = TestUtils.getNormalValue(TestUtils.max(boundaryVals[0], boundaryVals[2], boundaryVals[4]), TestUtils.min(boundaryVals[1], boundaryVals[3], boundaryVals[5]));
        // 先给三条边都赋相同的值
        for (int iVar=0; iVar < NUM_OF_VAR; iVar++)
            tmpDate[iVar] = equalSideLen;
        // 给选出的不相等边赋不相等的值
        do
            tmpDate[notEqualSideId] =  TestUtils.getNormalValue(boundaryVals[notEqualSideId]*2, boundaryVals[notEqualSideId]*2+1);
        while (tmpDate[notEqualSideId].equals(tmpDate[(notEqualSideId+1)%NUM_OF_VAR])); // 使用不溢出加法判定特值边长与特值边的下一个边长是否相等
        tmpDate[NUM_OF_VAR] = StdVolumeCalculator.getVolume(tmpDate[0], tmpDate[1], tmpDate[2]);
        result.add(tmpDate);
        /** Ordinary rectangle **/
        Integer[] randomSet = new Integer[NUM_OF_VAR+1];
        for (int iVar = 0; iVar < NUM_OF_VAR; iVar++) {
            boolean flag;
            Integer tmp;
            do {
                flag = false;
                tmp = TestUtils.getNormalValue(boundaryVals[iVar * 2], boundaryVals[iVar * 2 + 1]);
                for (int i=0; i < iVar; i++) if (tmp.equals(randomSet[i])) { flag=true; break;}
            } while (flag);
            randomSet[iVar] = tmp;
        }
        randomSet[NUM_OF_VAR] = StdVolumeCalculator.getVolume(randomSet[0], randomSet[1], randomSet[2]);
        result.add(randomSet);

        return result;
    }

    public static ArrayList<Integer[] > generateStrongRobustEquivalenceClassTestCases() {
        // 总测试样例数为4
        // 此等价类划分依据结果进行
        // 划分为正方体体积，柱体体积，普通长方体（三边均不相等）体积及错误数据（不为长方体）体积
        // 且结果导向的等价类划分只有一个变量，因此测试样例数为4
        ArrayList<Integer[]> result = new ArrayList<>();
        /** cube **/
        // 生成正方体的边长，算法为取三边长度范围的左边界值中最大值为随机数函数的下界，右边界值中的最小值为上界
        int sideLen = TestUtils.getNormalValue(TestUtils.max(boundaryVals[0], boundaryVals[2], boundaryVals[4]), TestUtils.min(boundaryVals[1], boundaryVals[3], boundaryVals[5]));
        result.add(new Integer[]{sideLen, sideLen, sideLen, StdVolumeCalculator.getVolume(sideLen, sideLen, sideLen)});
        /** cylinder **/
        Integer[] tmpDate = new Integer[NUM_OF_VAR+1];
        // 随机选出一条不相等的边，生成相等边的长度，算法同上
        int notEqualSideId = TestUtils.getNormalValue(0, 2),
                equalSideLen = TestUtils.getNormalValue(TestUtils.max(boundaryVals[0], boundaryVals[2], boundaryVals[4]), TestUtils.min(boundaryVals[1], boundaryVals[3], boundaryVals[5]));
        // 先给三条边都赋相同的值
        for (int iVar=0; iVar < NUM_OF_VAR; iVar++)
            tmpDate[iVar] = equalSideLen;
        // 给选出的不相等边赋不相等的值
        do
            tmpDate[notEqualSideId] =  TestUtils.getNormalValue(boundaryVals[notEqualSideId]*2, boundaryVals[notEqualSideId]*2+1);
        while (tmpDate[notEqualSideId].equals(tmpDate[(notEqualSideId+1)%NUM_OF_VAR])); // 使用不溢出加法判定特值边长与特值边的下一个边长是否相等
        tmpDate[NUM_OF_VAR] = StdVolumeCalculator.getVolume(tmpDate[0], tmpDate[1], tmpDate[2]);
        result.add(tmpDate);
        /** Ordinary rectangle **/
        Integer[] randomSet = new Integer[NUM_OF_VAR+1];
        for (int iVar = 0; iVar < NUM_OF_VAR; iVar++) {
            boolean flag;
            Integer tmp;
            do {
                flag = false;
                tmp = TestUtils.getNormalValue(boundaryVals[iVar * 2], boundaryVals[iVar * 2 + 1]);
                for (int i=0; i < iVar; i++) if (tmp.equals(randomSet[i])) { flag=true; break;}
            } while (flag);
            randomSet[iVar] = tmp;
        }
        randomSet[NUM_OF_VAR] = StdVolumeCalculator.getVolume(randomSet[0], randomSet[1], randomSet[2]);
        result.add(randomSet);
        /** Not for cuboid **/
        result.add(new Integer[]{0, -1, 1000, StdVolumeCalculator.getVolume(0, -1, 1000)});

        return result;
    }

}
