package dp;

/**
 * 爬楼梯
 * <p>
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbStairsDemo {

    public static void main(String[] args) {
        ClimbStairsDemo demo = new ClimbStairsDemo();

        System.out.println(demo.climbStairs(4));
    }

    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
