package twoPointer;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * <p>
 * https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */
public class ExchangeDemo {

    public static void main(String[] args) {

    }

    public int[] exchange(int[] array) {
        int fastIndex = 0;
        int slowIndex = 0;
        while (fastIndex < array.length) {
            if (array[fastIndex] % 2 == 1) {
                int temp = array[slowIndex];
                array[slowIndex] = array[fastIndex];
                array[fastIndex] = temp;
                slowIndex++;
            }
            fastIndex++;
        }
        return array;
    }
}
