package other;

/**
 * 581. 最短无序连续子数组
 * <p>
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 */
public class FindUnsortedSubarrayDemo {

    public static void main(String[] args) {

    }


    public int findUnsortedSubarray(int[] nums) {
        int left = -1;
        int right = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (max > nums[i]) {
                right = i;
            } else {
                max = nums[i];
            }
            if (min < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                min = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}
