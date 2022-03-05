package other;

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
        int[] array = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int k = 6;
        int x = 1;
        System.out.println(demo.findClosestElements(array, k, x));
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
}
