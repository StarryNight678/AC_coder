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

        return arr[arr.length - 1];
    }


    /**
     * log(N)的复杂度
     *
     * @param arr
     * @return
     */
    int LongestSubLogN(int[] arr) {


        return 1;
    }

    public static void main(String[] args) {

        int[] arr = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        System.out.println("" + longestIncreasingSubsequence.LongestSub(arr));

    }
}
