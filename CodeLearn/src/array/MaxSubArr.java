package array;

import java.util.Arrays;

/**
 * 最大连续子数组和
 * 求数组中的连续子数组的最大和
 * <p>
 * create by  ZhouJianhua  2017/9/2
 * Email: zjhua678@163.com
 */
public class MaxSubArr {


    /**
     * 最大连续子数组的和
     *
     * 动态规划:
     *
     * 当前第i个值为结尾的数值和.
     *
     * 1. 前面和sum大于0,加入前面
     * 2. 前面和sum小于0,单独作为一个元素
     *
     * @param arr
     * @return
     */
    int maxSub(int[] arr) {

        if (arr == null) {
            return -1;
        }

        int max = arr[0];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum >= 0) {
                sum = sum + arr[i];
            } else {
                sum = arr[i];
            }

            if (sum > max) {
                max = sum;
            }
        }

        return max;


    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(Arrays.toString(arr));
        MaxSubArr maxSubArr = new MaxSubArr();
        System.out.println("maxSubArr:"+maxSubArr.maxSub(arr));
    }
}
