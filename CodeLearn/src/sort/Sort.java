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

    /**
     * 快速排序
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
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
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
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

        System.out.println("计数排序:");
        for (int j = 0; j < sortArr.length; j++) {
            int size = sortArr[j];
            if (size > 0) {

                while (size > 0) {
                    System.out.print(" " + j);
                    size--;
                }
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {

        Sort sort = new Sort();
        int arr[] = {1, 4, 4, 8, 3, 9, 21, 55, 77, 88};
        System.out.println("原始数组");
        System.out.println(Arrays.toString(arr));
        int[] insertSortArr = arr;
        sort.insertSort(insertSortArr);
        System.out.println("插入排序:" + Arrays.toString(insertSortArr));
        int[] qsortArr = arr;
        sort.qsort(qsortArr, 0, arr.length - 1);
        System.out.println("快速排序:" + Arrays.toString(qsortArr));
        int[] maoPaoSortArr = arr;
        sort.maoPaoSort(maoPaoSortArr);
        System.out.println("冒泡排序:" + Arrays.toString(maoPaoSortArr));
        int[] jiShuSortArr = arr;
        sort.jiShuSort(jiShuSortArr, 100);
//        System.out.println("计数排序:"+Arrays.toString(jiShuSortArr));


    }
}
