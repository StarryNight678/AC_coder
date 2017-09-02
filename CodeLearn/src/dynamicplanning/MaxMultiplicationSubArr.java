package dynamicplanning;

/**
 * 最大连续乘积子数组
 * <p>
 * create by  ZhouJianhua  2017/9/2
 * Email: zjhua678@163.com
 */
public class MaxMultiplicationSubArr {


    /**
     * 最大连续乘积子数组
     * @param arr
     * @return
     */
    double maxMultiSubArr(double[] arr) {

        if (arr == null) {
            return -1;
        }
        double maxResult = arr[0];
        double maxEnd = arr[0];
        double minEnd = arr[0];
        for (int i = 1; i < arr.length; i++) {
            double end1 = arr[i] * maxEnd;
            double end2 = arr[i] * minEnd;
            maxEnd = Math.max(Math.max(end1, end2), arr[i]);
            minEnd = Math.min(Math.min(end1, end2), arr[i]);
            maxResult = Math.max(maxEnd, maxResult);
        }

        return maxResult;
    }


    public static void main(String[] args) {

        double[] arr = {-2.5, 4, 0, 3, 0.5, 8, -1};
        MaxMultiplicationSubArr maxMultiplicationSubArr = new MaxMultiplicationSubArr();
        double result = maxMultiplicationSubArr.maxMultiSubArr(arr);
        System.out.println("最大连续乘积子数组");
        System.out.println(result);
    }
}
