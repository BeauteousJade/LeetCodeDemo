package other;

/**
 * 136. 只出现一次的数字
 * <p>
 * https://leetcode-cn.com/problems/single-number/
 */
public class SingleNumberDemo {

    public static void main(String[] args) {
        SingleNumberDemo demo = new SingleNumberDemo();
        System.out.println(demo.singleNumber(new int[]{2, 2, 1}));
    }

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
