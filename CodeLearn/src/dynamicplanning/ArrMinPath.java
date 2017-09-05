package dynamicplanning;

/**
 * 矩阵最小路径和
 * create by  ZhouJianhua  2017/9/2
 * Email: zjhua678@163.com
 */
public class ArrMinPath {


    /**
     * 矩阵最小路径和
     *
     * @param arr
     * @return
     */
    int minPath(int[][] arr) {

        if (null == arr) {
            return -1;
        }
        int m = arr.length;
        int n = arr[0].length;

        int[][] path = new int[m][n];

        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum = sum + arr[i][0];
            path[i][0] = sum;
        }
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[0][i];
            path[0][i] = sum;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                path[i][j] = arr[i][j] + Math.min(path[i - 1][j], path[i][j - 1]);
            }
        }
        return path[m - 1][n - 1];

    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 5, 9},
                {8, 1, 3, 4},
                {5, 0, 6, 1},
                {8, 8, 4, 0}
        };

        ArrMinPath arrMinPath = new ArrMinPath();
        int result = arrMinPath.minPath(arr);
        System.out.println("矩阵最小路径和");
        System.out.println(result);

    }
}
