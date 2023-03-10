package math;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 * <p>
 * https://leetcode.cn/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 */
public class PrintNumbersDemo {

    public static void main(String[] args) {

    }

    public int[] printNumbers(int n) {
        int count = 1;
        int digit = 1;
        // 1. 找到刚好超出n位的数。
        // 例如 n 为0，那么digit就等于100。
        while (count <= n) {
            digit = digit * 10;
            count++;
        }
        // 2. 从1 到 digit- 1，赋值。
        int[] res = new int[digit - 1];
        for (int i = 0; i < digit - 1; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
