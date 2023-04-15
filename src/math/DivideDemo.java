package math;

/**
 * 29. 两数相除
 * <p>
 * https://leetcode.cn/problems/divide-two-integers/
 */
public class DivideDemo {

    public static void main(String[] args) {

    }

    /**
     * https://leetcode.cn/problems/xoh6Oh/solution/zheng-shu-chu-fa-by-leetcode-solution-3572/1522366
     *
     */
    public int divide(int a, int b) {
        int MIN = Integer.MIN_VALUE;
        int MAX = Integer.MAX_VALUE;
        int MIN_LIMIT = MIN >> 1; // -1073741824
        if (a == MIN && b == -1) {
            return MAX; // 特判
        }
        boolean isPos = (a < 0 && b > 0) || (a > 0 && b < 0) ? false : true;
        if (a > 0) {
            a = -a;
        }
        if (b > 0) {
            b = -b;
        }
        int ans = 0; // 最终的商
        while (a <= b) {
            int d = b, c = 1; // d为当前除数，c为当前商
            while (d >= MIN_LIMIT && d + d >= a) { // 通过第一个条件防止d + d溢出
                d += d; // 当前除数倍增，也可以用 d <<= 1;
                c += c; // 当前商倍增，也可以用 c <<= 1;
            }
            a -= d; // a剩余部分
            ans += c; // 累计当前商
        }
        return isPos ? ans : -ans;
    }
}
