package dp;

/**
 * 845. 数组中的最长山脉
 * <p>
 * https://leetcode.cn/problems/longest-mountain-in-array/
 */
public class LongestMountainDemo {

    public static void main(String[] args) {
        LongestMountainDemo demo = new LongestMountainDemo();
        int[] array = new int[]{2, 1, 4, 7, 3, 2, 5};
        System.out.println(demo.longestMountain(array));
    }

    public int longestMountain(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // left 记录最长递增序列
        int[] left = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            left[i] = arr[i] > arr[i - 1] ? left[i - 1] + 1 : 0;
        }
        // right 记录最长递减序列
        int[] right = new int[arr.length];
        for (int i = arr.length - 2; i >= 0; i--) {
            right[i] = arr[i] > arr[i + 1] ? right[i + 1] + 1 : 0;
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (left[i] > 0 && right[i] > 0) {
                res = Math.max(res, left[i] + right[i] + 1);
            }
        }
        return res;
    }
}
