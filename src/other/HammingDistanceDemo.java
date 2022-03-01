package other;


/**
 * 461. 汉明距离
 * <p>
 * https://leetcode-cn.com/problems/hamming-distance/
 */
public class HammingDistanceDemo {

    public static void main(String[] args) {
        HammingDistanceDemo demo = new HammingDistanceDemo();
        System.out.println(demo.hammingDistance(3, 1));
    }

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
