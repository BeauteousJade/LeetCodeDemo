package math;

/**
 * 357. 统计各位数字都不同的数字个数
 * <p>
 * https://leetcode.cn/problems/count-numbers-with-unique-digits/
 */
public class CountNumbersWithUniqueDigitsDemo {

    public static void main(String[] args) {

    }


    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int last = 9;
        int ans = 10;
        for (int i = 2; i <= n; i++) {
            int cur = last * (10 - i + 1);
            ans += cur;
            last = cur;
        }
        return ans;
    }
}
