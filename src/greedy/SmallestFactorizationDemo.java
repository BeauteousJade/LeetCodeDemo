package greedy;

/**
 * 625. 最小因式分解
 * <p>
 * https://leetcode.cn/problems/minimum-factorization/
 */
public class SmallestFactorizationDemo {

    public static void main(String[] args) {

    }

    /**
     * 贪心思想，将最大得因子放在最低位，这样才能保证最终结果最小(位数最短且高位数字尽可能最小)。
     */
    public int smallestFactorization(int num) {
        if (num < 2) {
            return num;
        }
        long res = 0;
        int mul = 1;
        for (int i = 9; i >= 2; i--) {
            while (num % i == 0) {
                num /= i;
                res = res + (long) mul * i;
                mul *= 10;
            }
        }
        return num < 2 && res <= Integer.MAX_VALUE ? (int) res : 0;
    }
}
