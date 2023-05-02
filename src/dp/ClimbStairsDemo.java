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
        int pre = 0, current = 0, next = 1;
        for (int i = 1; i <= n; ++i) {
            pre = current;
            current = next;
            next = pre + current;
        }
        return next;
    }
}
