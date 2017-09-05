package dynamicplanning;

/**
 * 换钱的最小货币数
 * <p>
 * 给定数组,数组不重复,且为正数.
 * 每个数值代表一个面值货币
 * 每个货币可以使用任意张
 * <p>
 * 一个aim表要找的钱数
 * <p>
 * qiu组成aim的换钱方法数
 * <p>
 * 无法找开返回0
 * create by  ZhouJianhua  2017/9/5
 * Email: zjhua678@163.com
 */
public class MinCoinChange {


    /**
     * 换钱方法数
     * <p>
     * 复杂度  n*aim*aim
     *
     * @param arr   零钱数组
     * @param index 当前选择的钱数 arr[index]
     * @param aim   目标钱数
     * @return 换钱的方法数
     */
    int minCoin(int[] arr, int index, int aim) {

        int res = 0;
        if (index == arr.length) {

            if (0 == aim) {
                return 1;
            } else {
                return 0;
            }
        }

        for (int i = 0; arr[index] * i <= aim; i++) {
            res = res + minCoin(arr, index + 1, aim - arr[index] * i);
        }

        return res;
    }

    /**
     * 动态规划
     *
     * @param arr
     * @param aim
     * @return
     */

    int coinFast(int[] arr, int aim) {

        int m = arr.length;

        int[][] d = new int[m][aim + 1];
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }

        for (int i = 0; i < m; i++) {
            d[i][0] = 1;
        }

        for (int i = 0; arr[0] * i <= aim; i++) {
            d[0][arr[0] * i] = 1;
        }


        //  d[i][j] =  d[i-1][j] +  d[i][j-arr[i]]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= aim; j++) {
                
                if ((j - arr[i]) >= 0) {
                    d[i][j] = d[i - 1][j] + d[i][j - arr[i]];
                } else {
                    d[i][j] = d[i - 1][j];
                }

            }

        }

        System.out.println("动态规划数组");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= aim; j++) {
                System.out.print(String.format("%d\t", d[i][j]));
            }
            System.out.println();
        }

        return d[m - 1][aim];
    }

    public static void main(String[] args) {

        int[] arr = {5, 10, 25, 1};
        int aim = 15;
        MinCoinChange minCoinChange = new MinCoinChange();
        System.out.println("递归结果:" + minCoinChange.minCoin(arr, 0, aim));
        System.out.println("动态规划");
        System.out.println("动态规划结果:" + minCoinChange.coinFast(arr, aim));
    }
}
