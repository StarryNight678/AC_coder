package search;

/**
 * 二分查找
 * create by  ZhouJianhua  2017/8/31
 * Email: zjhua678@163.com
 */
public class BinarySearching {


    /**
     * 二分查找
     *
     * @param arr
     * @param target
     * @return
     */
    int binSearch(int[] arr, int target) {


        int start=0;
        int end=arr.length-1;
        while (start <= end) {

            int mid = (start + end) / 2;
            if (target == arr[mid]) {
                return target;
            }
            if(target<arr[mid]){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr={1,5,7,12,33,45,67,88,99};
        BinarySearching binarySearching=new BinarySearching();
        int key=67;
        int result=binarySearching.binSearch(arr,key);
        System.out.println("result:"+result);
    }
}
