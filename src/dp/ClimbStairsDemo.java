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
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int a = 0;
        int b = 0;
        int c = 1;
        for (int i = 1; i <= n; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }
}
