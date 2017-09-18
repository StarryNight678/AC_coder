package string;

import java.util.Arrays;

/**
 * 回文判断
 * create by  ZhouJianhua  2017/9/2
 * Email: zjhua678@163.com
 */
public class HuiWen {


    /**
     * 是否是回文
     *
     * @param arr
     * @return
     */
    boolean isHuiWen(char[] arr) {

        if (arr == null || arr.length < 1) {
            System.out.println("arr == null || arr.length < 1");
            return false;
        }
        int len = arr.length;

        int start = 0;
        int end = len - 1;
        while (start != end) {

            if (arr[start] == arr[end]) {
                start++;
                end--;
            } else {
                return false;
            }
        }


        return true;
    }

    /**
     * 最长回文子串
     *
     * @param arr
     * @return
     */
    int longestHuiWen(char[] arr) {

        if (arr == null || arr.length < 1) {
            return 0;
        }
        int len = arr.length;

        int max = 0;
        int count = 0;
        for (int i = 0; i < len; i++) {

            //奇数情况
            for (int j = 0; (i - j) >= 0 && (i + j) < len; j++) {
                if (arr[i - j] == arr[i + j]) {
                    count = 2 * j + 1;
                } else {
                    break;
                }
            }

            if (count > max) {
                max = count;
            }

            //偶数情况
            for (int j = 0; (i - j) >= 0 && (i + j + 1) < len; j++) {
                if (arr[i - j] == arr[i + j + 1]) {
                    count = 2 * j + 1;
                } else {
                    break;
                }
            }

            if (count > max) {
                max = count;
            }
        }


        return max;
    }

    public static void main(String[] args) {

        HuiWen huiWen = new HuiWen();
        String str = "madam";

        char[] arr = str.toCharArray();
        System.out.println(Arrays.toString(arr));

        System.out.println(huiWen.isHuiWen(arr));
        arr = null;
        System.out.println(huiWen.isHuiWen(arr));

        String charStr = "12212321";
        arr = charStr.toCharArray();
        System.out.println("最长回文字符串:"+huiWen.longestHuiWen(arr));
    }
}
