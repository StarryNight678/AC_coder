package array;

import java.util.HashSet;

/**
 * 和为定值的两个数
 * <p>
 * create by  ZhouJianhua  2017/9/2
 * Email: zjhua678@163.com
 */
public class TwoSum {


    HashSet<Integer> set;

    TwoSum(int[] arr) {
        set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
    }


    /**
     * 查询和为定值的两个数是否在数组中
     *
     * @param sum
     * @param n
     * @return boolean
     */
    boolean findTwoSum(int sum, int n) {

        return set.contains(sum - n);

    }


    public static void main(String[] args) {
        int[] arr = {6, 7, 8, 91, 23, 5, 6, 44};

        TwoSum twoSum = new TwoSum(arr);
        System.out.println(twoSum.findTwoSum(11, 5));

        System.out.println(twoSum.findTwoSum(16, 7));

        System.out.println(twoSum.findTwoSum(50, 6));


    }
}
