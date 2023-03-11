package prefix;

/**
 * 剑指 Offer II 012. 左右两边子数组的和相等
 * <p>
 * https://leetcode.cn/problems/tvdfij/
 */
public class PivotIndexDemo {

    public static void main(String[] args) {
        PivotIndexDemo demo = new PivotIndexDemo();
        System.out.println(demo.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }

    public int pivotIndex(int[] nums) {

        int sum = nums[0];
        int[] prefix = new int[nums.length + 1];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
            sum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (sum - prefix[i] - nums[i] == prefix[i]) {
                return i;
            }
        }
        return -1;
    }
}
