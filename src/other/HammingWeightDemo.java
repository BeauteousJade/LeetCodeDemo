package other;


/**
 * 191. 位1的个数
 * <p>
 * https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class HammingWeightDemo {

    private final int value = 1;

    public static void main(String[] args) {
        HammingWeightDemo demo = new HammingWeightDemo();
        System.out.println(demo.hammingWeight(-3));
    }

    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) != 0) {
                ret++;
            }
            n = n >> 1;
        }

        return ret;
    }

    public int hammingWeightV2(int n) {
        return Integer.bitCount(n);
    }

}
