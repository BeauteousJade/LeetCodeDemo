package sort;

import java.util.Arrays;

/**
 * 快速排序。
 */
public class QuickSortDemo {

    public static void main(String[] args) {
        QuickSortDemo demo = new QuickSortDemo();
        int[] array = new int[]{5, 4, 3, 1, 2, 4};
        demo.sort(array);
        System.out.println(Arrays.toString(array));
    }

    private void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int low, int high) {
        if (low >= high || low < 0 || high > array.length) {
            return;
        }
        int key = array[low];
        int left = low;
        int right = high;
        while (left < right) {
            while (left < right && array[right] >= key) {
                right--;
            }
            while (left < right && array[left] <= key) {
                left++;
            }
            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        array[low] = array[left];
        array[left] = key;
        if (low < left) {
            quickSort(array, low, left - 1);
        }
        if (right < high) {
            quickSort(array, right + 1, high);
        }
    }
}
