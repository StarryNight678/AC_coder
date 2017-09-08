package dynamicplanning;

import java.util.Arrays;

/**
 * 最长递增子序列
 * <p>
 * 数组 arr
 * 返回arr的最长递增子序列
 * <p>
 * 例子:
 * arr={2,1,5,3,6,4,8,9,7}
 * 递增序列: 1 3 4 8 9
 * <p>
 * create by  ZhouJianhua  2017/9/5
 * Email: zjhua678@163.com
 */
public class LongestIncreasingSubsequence {


    /**
     * 最长递增子序列
     * <p>
     * 复杂度  N*N
     *
     * @param arr
     * @return
     */
    int LongestSub(int[] arr) {

        if (null == arr || arr.length == 0) {
            return 0;
        }

        int[] data = new int[arr.length];
        data[0] = 1;

        //在i位置结尾的最长递增子序列,
        //从 0--i-1 的j位置上,找到最大的递增长度 data[j],  data[i]=data[j]+1
        for (int i = 1; i < arr.length; i++) {
            //默认为1
            data[i] = 1;
            for (int j = 0; j <= i; j++) {
                if (arr[i] > arr[j]) {
                    data[i] = Math.max(data[i], data[j] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(data));

        int max = data[0];
        for (int i = 1; i < data.length; i++) {
            max = Math.max(max, data[i]);
        }
        return max;
    }


    /**
     * N*log(N)的复杂度
     * <p>
     * 二叉进行搜索
     *
     * @param arr
     * @return
     */
    int LongestSubLogN(int[] arr) {

        int len = arr.length;
        int[] dp = new int[len];
        int[] ends = new int[len];
        ends[0] = arr[0];
        dp[0] = 1;
        int right = 0;
        int l = 0;
        int r = 0;
        int m = 0;
        for (int i = 1; i < len; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = (r + r) / 2;
                if (arr[i] > ends[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            ends[l] = arr[i];
            dp[i] = l + 1;
        }

        System.out.println("dp  :" + Arrays.toString(dp));
        System.out.println("ends:" + Arrays.toString(ends));
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    public static void main(String[] args) {

        int[] arr = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        System.out.println("N*N  最长递增子序列:" + longestIncreasingSubsequence.LongestSub(arr));
        System.out.println("N*logN 最长递增子序列:" + longestIncreasingSubsequence.LongestSubLogN(arr));
    }
}
