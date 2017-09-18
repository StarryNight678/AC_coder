package array;
import java.util.Arrays;

/**
 * 从n个数选择最小的k个数
 * <p>
 * 方法1:全部排序 O(nlogn)
 * 方法2:堆排序 O(nlogk)
 * 方法3:线性选择排序 O(n)
 *
 * 类似于快速排序
 *
 * 选择个主元m, 将大于该值的放到右边,小于该值的放到左边
 * create by  ZhouJianhua  2017/9/2
 * Email: zjhua678@163.com
 */
public class MinKNum {

    /**
     * 选出最小的k个元素
     *
     * @param arr
     * @param k
     * @param left
     * @param right
     */
    void quickSelect(int[] arr, int k, int left, int right) {
        int i, j;
        int pivot;

        if (left <= right) {

            pivot = arr[left];
            i = left;
            j = right;
            while (i < j) {

                while (arr[j] >= pivot  && i<j) {
                    j--;
                }
                if(i<j){
                    arr[i]=arr[j];
                }

                while (arr[i] <= pivot  && i<j)  {
                    i++;
                }
                if(i<j){
                    arr[j]=arr[i];
                }

            }

            arr[i]=pivot;
            System.out.println(left+" "+right+" "+arr[i]);
            System.out.println("pivot:"+pivot);
            System.out.println(left+" "+right+": "+Arrays.toString(arr));
            if(k<=i){
                quickSelect(arr,k,left,i-1);
            }else{
                quickSelect(arr,k,i+1,right);
            }

        }

    }

    public static void main(String[] args) {

        MinKNum minKNum=new MinKNum();

        int[] arr={9,3,5,3,2,1,1,7,22,45,77,12,21,55};
        int k=3;
        minKNum.quickSelect(arr,k,0,arr.length-1);

        System.out.println("结果:");
        System.out.println(Arrays.toString(arr));

    }
}
