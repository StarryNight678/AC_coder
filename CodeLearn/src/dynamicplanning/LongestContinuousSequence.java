package dynamicplanning;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 最长连续序列
 * <p>
 * 例子:
 * arr={100,4,200,1,3,2}
 * 最长的连续序列为1,2,3,4 返回4
 * <p>
 * create by ZhouJianhua 2017/9/7
 * Email: zjhua678@163.com
 */
public class LongestContinuousSequence {

    /**
     * 最长连续序列
     *
     * @param arr
     * @return
     */
    public int longConSeq(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = 1;
        //map  <i,value> 表示在值i时,i所在的序列长度为value
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {

                //输入初始值,当前值所在的连续序列为1
                map.put(arr[i], 1);
                if (map.containsKey(arr[i] - 1)) {
                    max = Math.max(max, merge(map, arr[i] - 1, arr[i]));
                }
                if (map.containsKey(arr[i] + 1)) {
                    max = Math.max(max, merge(map, arr[i], arr[i] + 1));
                }
            }
        }

        System.out.println("hashMap:");
        for (Integer i : map.keySet()) {
            System.out.println(String.format("%d\t len:%d", i, map.get(i)));
        }

        return max;
    }

    /**
     * 更新值
     * 将其和左边或右边进行拼接.
     * 更新时,只需要更新最左边或右边的值.中间的不需要更新.
     * 中间的值已经存在,不会再更新了.
     * <p>
     * map.put(left, len);
     * map.put(right, len);
     *
     * @param map
     * @param less
     * @param more
     * @return
     */
    public int merge(HashMap<Integer, Integer> map, int less, int more) {
        int left = less - map.get(less) + 1;
        int right = more + map.get(more) - 1;
        int len = right - left + 1;
        map.put(left, len);
        map.put(right, len);
        return len;
    }

    public static void main(String[] args) {

        int[] arr = {100, 4, 200, 1, 3, 2};
        LongestContinuousSequence longestContinuousSequence = new LongestContinuousSequence();

        int result = longestContinuousSequence.longConSeq(arr);
        System.out.println("longestContinuousSequence结果:");
        System.out.println(result);

    }

}
