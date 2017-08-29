package sort;

import java.util.*;

public class Sort {


    /**
     * 插入排序
     *
     * @param arr
     */
    void insertSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int tmp = arr[i];
            while (j >= 0 && tmp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = tmp;
        }
    }

    int qsortFun(int arr[], int start, int end) {
        int flag = arr[start];
        int m = end;
        int n = start;
        while (m > n) {

            while (arr[m] >= flag && m > n) {
                m--;
            }
            if (m > n) {
                arr[n] = arr[m];
            }

            while (arr[n] <= flag && m > n) {
                n++;
            }

            if (m > n) {
                arr[m] = arr[n];
            }
        }
        arr[m] = flag;

        return m;
    }

    /**
     * 快速排序
     *
     * @param arr
     * @param start
     * @param end
     */
    void qsort(int arr[], int start, int end) {

        if (start < end) {
            int position = qsortFun(arr, start, end);
            qsort(arr, start, position - 1);
            qsort(arr, position + 1, end);
        }

    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    void maoPaoSort(int arr[]) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    /**
     * 堆排序
     *
     * @param arr
     */
    void heapSort(int arr[]) {


    }


    /**
     * 计数排序
     *
     * @param arr
     */
    void jiShuSort(int arr[], int maxSize) {

        int[] sortArr = new int[maxSize];

        for (int i = 0; i < arr.length; i++) {
            sortArr[arr[i]]++;
        }

        for (int j = 0; j < sortArr.length; j++) {
            int size=sortArr[j];
            if (size> 0) {

                while(size>0){
                    System.out.print(" "+j);
                    size--;
                }
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {

        Sort sort = new Sort();
        int arr[] = {1, 4, 4, 8, 3, 9, 21, 55, 77, 88};

        System.out.println(Arrays.toString(arr));
//        sort.insertSort(arr);
//        sort.qsort(arr, 0, arr.length - 1);
//        sort.maoPaoSort(arr);
//        sort.jiShuSort(arr,100);


        System.out.println(Arrays.toString(arr));
    }
}
