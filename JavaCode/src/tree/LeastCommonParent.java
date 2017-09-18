package tree;

/**
 * 最近公共祖先
 * <p>
 * create by  ZhouJianhua  2017/9/2
 * Email: zjhua678@163.com
 */
public class LeastCommonParent {


    /**
     * 最近公共祖先
     * 后序遍历
     *
     * @param arr
     * @param m
     * @param n
     * @param current
     * @return
     */

    int findLeastCommonParent(int[] arr, int m, int n, int current) {

        if (arr == null || current >= arr.length) {
            return -1;
        }

        if (arr[current] == -1 || arr[current] == m || arr[current] == n) {
            return arr[current];
        }

        int left = findLeastCommonParent(arr, m, n, 2 * current + 1);
        int rigt = findLeastCommonParent(arr, m, n, 2 * current + 2);

        //一个在左子树,一个在右子树
        if (left != -1 && rigt != -1) {
            return arr[current];
        }

        if (left != -1) {
            return left;
        } else {
            return rigt;
        }


    }

    public static void main(String[] args) {


        /*
              1
          2       3
        4   5   6   7
                   8
         */
        int[] arr = {1, 2, 3, 4, 5, 6, 7, -1, -1, -1, -1, -1, -1, 8, -1};
        LeastCommonParent leastCommonParent = new LeastCommonParent();
        System.out.println("最近公共祖先");
        System.out.println(leastCommonParent.findLeastCommonParent(arr, 8, 6, 0));

    }
}
