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
        int a = 1;
        int b = 2;
        for (int i = 3; i <= n; i++) {
            b = a + b;
            a = b;
        }
        return b;
    }
}
