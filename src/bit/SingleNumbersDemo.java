package bit;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * <p>
 * https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 */
public class SingleNumbersDemo {

    public static void main(String[] args) {

    }

    public int[] singleNumbers(int[] nums) {
        int x = 0;
        int y = 0;
        int m = 1;
        int num = 0;
        // 1. 两个落单数字的异或值记在num中
        for (int value : nums) {
            num ^= value;
        }
        // 2. 找到第一个bit位1(两个落单数第一个不一致的bit位)，用来拆分两个数字
        while ((num & m) == 0) {
            m = m << 1;
        }
        // 3. 再次遍历，区分出两个数字。
        for (int value : nums) {
            if ((value & m) != 0) {
                x ^= value;
            } else {
                y ^= value;
            }
        }
        return new int[]{x, y};
    }
}
