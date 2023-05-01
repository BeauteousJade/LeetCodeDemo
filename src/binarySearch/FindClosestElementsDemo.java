package binarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * 658. 找到 K 个最接近的元素
 * <p>
 * https://leetcode-cn.com/problems/find-k-closest-elements/
 */
public class FindClosestElementsDemo {

    public static void main(String[] args) {
        FindClosestElementsDemo demo = new FindClosestElementsDemo();
        int[] array = new int[]{1, 2, 3, 4, 6, 7, 8, 9, 10};
        int k = 6;
        int x = 5;
        System.out.println(demo.findClosestElementsV2(array, k, x));
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        if (x < arr[0]) {
            for (int i = 0; i < k; i++) {
                list.add(arr[i]);
            }
            return list;
        }
        if (x > arr[arr.length - 1]) {
            for (int i = arr.length - 1; i > arr.length - 1 - k; i--) {
                list.add(0, arr[i]);
            }
            return list;
        }

        int left = 0;
        int right = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] <= x && arr[i] >= x) {
                right = i;
                left = i - 1;
                break;
            }
        }
        while (left >= 0 && right < arr.length && list.size() < k) {
            if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                list.add(0, arr[left]);
                left--;
            } else if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                list.add(arr[right]);
                right++;
            }
        }
        while (list.size() < k && left >= 0) {
            list.add(0, arr[left]);
            left--;
        }
        while (list.size() < k && right < arr.length) {
            list.add(arr[right]);
            right++;
        }
        return list;
    }


    public List<Integer> findClosestElementsV2(int[] arr, int k, int x) {
        int right = binarySearch(arr, x);
        int left = right - 1;
        while (k-- > 0) {
            if (left < 0) {
                right++;
            } else if (right >= arr.length) {
                left--;
            } else if (x - arr[left] <= arr[right] - x) {
                left--;
            } else {
                right++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = left + 1; i < right; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

    /**
     * 找到第一个比X大的数字。
     */
    public int binarySearch(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
