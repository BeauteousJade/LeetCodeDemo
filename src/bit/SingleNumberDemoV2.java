package bit;

/**
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * <p>
 * https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 */
public class SingleNumberDemoV2 {

    public static void main(String[] args) {

    }

    /**
     * 统计每个数字32位bit上的数字。然后在模3，剩下的bit位就属于只出现过一次的数字。
     * 然后将剩下的bit位组装起来即可。
     */
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int value : nums) {
            for (int i = 0; i < 32; i++) {
                count[i] += value & 1;
                value = value >> 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = res | (count[i] % 3) << i;
        }

        return res;
    }
}
