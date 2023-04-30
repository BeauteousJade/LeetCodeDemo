package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 剑指 Offer 40. 最小的k个数
 * <p>
 * https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/
 */
public class GetLeastNumbersDemo {

    public static void main(String[] args) {

    }

    /**
     * 堆。
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] res = new int[queue.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = queue.poll();
        }
        return res;
    }

    /**
     * 排序
     */
    public int[] getLeastNumbersV2(int[] arr, int k) {
        int[] vec = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; ++i) {
            vec[i] = arr[i];
        }
        return vec;
    }

    /**
     * 快速排序
     */
    public int[] getLeastNumbersV3(int[] arr, int k) {
        if (k >= arr.length) {
            return arr;
        }
        return quickSort(arr, k, 0, arr.length - 1);
    }

    private int[] quickSort(int[] array, int k, int left, int right) {
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && array[j] >= array[left]) {
                j--;
            }
            while (i < j && array[i] <= array[left]) {
                i++;
            }
            swap(array, i, j);
        }
        swap(array, i, left);
        if (i > k) {
            return quickSort(array, k, left, i - 1);
        }
        if (i < k) {
            return quickSort(array, k, i + 1, right);
        }
        return Arrays.copyOf(array, k);
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
