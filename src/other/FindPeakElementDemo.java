package other;

/**
 * 162. 寻找峰值
 * <p>
 * https://leetcode-cn.com/problems/find-peak-element/
 */
public class FindPeakElementDemo {

    public static void main(String[] args) {

    }

    public int findPeakElement(int[] nums) {
        int idx = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        return idx;
    }
}
