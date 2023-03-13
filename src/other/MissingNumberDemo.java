package other;

/**
 * 268. 丢失的数字
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * <p>
 * https://leetcode-cn.com/problems/missing-number/
 */
public class MissingNumberDemo {

    public static void main(String[] args) {
        MissingNumberDemo demo = new MissingNumberDemo();
        int[] array = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(demo.missingNumber(array));
    }

    public int missingNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        // ^ 0没有意义，不过这里为了保证语义，加个0.
        for (int i = 0; i <= nums.length; i++) {
            result ^= i;
        }
        return result;
    }

}
