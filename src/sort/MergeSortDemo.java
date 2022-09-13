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


    private void sort(int[] array) {
        mergeSort(array, 0, array.length - 1, new int[array.length]);
    }

    private void mergeSort(int[] array, int start, int end, int[] result) {
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(array, start, mid, result);
        mergeSort(array, mid + 1, end, result);
        merge(array, start, end, result);
    }

    private void merge(int[] array, int start, int end, int[] result) {
        int start1 = start;
        int end1 = (start + end) / 2;
        int start2 = (start + end) / 2 + 1;
        int end2 = end;
        int resultIndex = start;
        while (start1 <= end1 && start2 <= end2) {
            if (array[start1] <= array[start2]) {
                result[resultIndex++] = array[start1++];
            } else {
                result[resultIndex++] = array[start2++];
            }
        }
        while (start1 <= end1) {
            result[resultIndex++] = array[start1++];
        }
        while (start2 <= end2) {
            result[resultIndex++] = array[start2++];
        }
        for (int i = start; i <= end; i++) {
            array[i] = result[i];
        }
    }
}
