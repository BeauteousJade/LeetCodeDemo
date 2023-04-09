package math;

/**
 * 剑指 Offer 43. 1～n 整数中 1 出现的次数
 * <p>
 * https://leetcode.cn/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
 */
// TODO 下次
public class CountDigitOneDemo {

    public static void main(String[] args) {

    }

    /**
     * https://leetcode.cn/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/mian-shi-ti-43-1n-zheng-shu-zhong-1-chu-xian-de-2/
     */
    public int countDigitOne(int n) {
        int digit = 1;
        int res = 0;
        int height = n / 10;
        int current = n % 10;
        int low = 0;
        while (height != 0 || current != 0) {
            if (current == 0) {
                res += height * digit; // (height - 1) * digit (高位) + 9(低位) + 1(current位) = height * digit，current 位不是1，需要向高位借1.
            } else if (current == 1) {
                res += height * digit + low + 1; // height * digit(高位) + low (低位) + 1（current 位） = (height + 1) * digit。current 位是1，不需要借.
            } else {
                res += (height + 1) * digit; // height * digit  + 9 + 1。current位变为1，那么low位就变为9.
            }
            current = height % 10;
            height = height / 10;
            digit *= 10;
            low = n % digit;
        }
        return res;
    }
}
