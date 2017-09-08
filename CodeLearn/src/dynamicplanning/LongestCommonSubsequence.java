package dynamicplanning;

import java.util.Arrays;

/**
 * 最长公共子序列
 * create by  ZhouJianhua  2017/9/6
 * Email: zjhua678@163.com
 */
public class LongestCommonSubsequence {

    /**
     * 计算特征矩阵
     *
     * @param charArr1
     * @param charArr2
     * @return
     */

    int[][] CalLongestComSub(char[] charArr1, char[] charArr2) {


        if (charArr1 == null || charArr2 == null || charArr1.length == 0 || charArr2.length == 0) {
            return null;
        }

        int m = charArr1.length;
        int n = charArr2.length;
        int[][] data = new int[m][n];

        if (charArr1[0] == charArr2[0]) {
            data[0][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            int tmp = 0;
            if (charArr1[i] == charArr2[0]) {
                tmp = 1;
            }
            data[i][0] = Math.max(data[i - 1][0], tmp);
        }

        for (int j = 1; j < n; j++) {
            int tmp = 0;
            if (charArr1[0] == charArr2[j]) {
                tmp = 1;
            }
            data[0][j] = Math.max(data[0][j - 1], tmp);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                data[i][j] = Math.max(data[i - 1][j], data[i][j - 1]);
                if (charArr1[i] == charArr2[j]) {
                    data[i][j] = Math.max(data[i][j], data[i - 1][j - 1] + 1);
                }

            }

        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(String.format("%d\t", data[i][j]));
            }
            System.out.println();
        }


        return data;
    }


    /**
     * 打印子序列
     */
    void printSubSeq(int[][] data, char[] charArr1, char[] charArr2) {

        int m = data.length;
        int n = data[0].length;

        char[] result = new char[data[m - 1][n - 1]];

        int i = m - 1;
        int j = n - 1;
        int index = data[m - 1][n - 1] - 1;
        while (index >= 0) {

            if (j >= 1 && data[i][j] == data[i][j - 1]) {
                j--;
            } else if (i >= 1 && data[i][j] == data[i - 1][j]) {
                i--;
            } else {
                result[index] = charArr1[i];
                i--;
                j--;
                index--;
            }
        }

        System.out.println("最长公共子序列:");
        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {

        String s1 = "1A2C3D4B56";
        String s2 = "B1D23CA45B6A";
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        int[][] data = longestCommonSubsequence.CalLongestComSub(s1.toCharArray(), s2.toCharArray());
        longestCommonSubsequence.printSubSeq(data, s1.toCharArray(), s2.toCharArray());

    }
}
