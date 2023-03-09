package math;

/**
 * 剑指 Offer 44. 数字序列中某一位的数字
 * <p>
 * https://leetcode.cn/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
 */
public class FindNthDigitDemo {

    public static void main(String[] args) {

    }

    public int findNthDigit(int n) {
        // 当前数字一共有多少位，例如 0 ~ 9 是一位数，10 ~ 99 是两位数。
        int digit = 1;
        // 当前位数的数字的开始值，例如一位数开始值是：1，两位数开始值是：10. // 注意一位数的开始值是1.
        long start = 1;
        // 当前位数数字包含数字一共有多少个，例如一位数一共有9个，两位数一共有180个(每个数字包含两个数字)。count = digit * start * 9.
        long count = 9;
        // 1. 轮询删除前面的位数。
        while (n > count) { //
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        // 2. 找到n所在的位数，计算它哪个数里面。
        long num = start + (n - 1) / digit;
        // 3. 从指定数找打对应数字(0 ~ 9)。记住这里需要模一下，因为此时n表示从start 开始 第n位数字，由于当前从start开始，每个数的位数都是一样，所以可以直接模
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }
}
