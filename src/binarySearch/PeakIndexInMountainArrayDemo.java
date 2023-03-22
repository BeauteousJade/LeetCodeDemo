package binarySearch;

/**
 * 852. 山脉数组的峰顶索引
 * <p>
 * https://leetcode.cn/problems/peak-index-in-a-mountain-array/
 */
public class PeakIndexInMountainArrayDemo {

    public static void main(String[] args) {

    }

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 2;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
