package dynamicplanning;

/**
 * 最长公共子串
 * <p>
 * 注意:子串是连续的
 * create by  ZhouJianhua  2017/9/6
 * Email: zjhua678@163.com
 */
public class LongestSub {


    int[][] fun(char[] charArr1, char[] charArr2) {

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
            if (charArr1[i] == charArr2[0]) {
                data[i][0] = 1;
            }
        }

        for (int j = 1; j < n; j++) {
            if (charArr1[0] == charArr2[j]) {
                data[0][j] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (charArr1[i] == charArr2[j]) {
                    data[i][j] = data[i - 1][j - 1] + 1;
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

    public static void main(String[] args) {

        String s1 = "abcde";
        String s2 = "bebcd";

        LongestSub longestSub = new LongestSub();
        longestSub.fun(s1.toCharArray(), s2.toCharArray());

    }
}
