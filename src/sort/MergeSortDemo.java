package sort;

import java.util.Arrays;

/**
 * 归并排序。
 */
public class MergeSortDemo {


    public static void main(String[] args) {
        MergeSortDemo demo = new MergeSortDemo();
        int array[] = new int[]{5, 4, 3, 2, 1, 4};
        demo.sort(array);
        System.out.println(Arrays.toString(array));
    }

    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[arr.length];
        //  初始化
        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }

        int i = start;
        int j = mid + 1;
        int k = start;

        while (i <= mid && j <= end) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        // 这里只需要拷贝i,不需要j的。
        // 因为如果j没有拷贝完，上面初始化的逻辑就已经拷贝了，所以不需要拷贝。
        while (i <= mid) {
            arr[k] = temp[i];
            i++;
            k++;
        }
    }
}
