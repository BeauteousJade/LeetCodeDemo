package fastPower;

/**
 * 50. Pow(x, n)
 * <p>
 * https://leetcode.cn/problems/powx-n/
 */
public class MyPowDemo {

    public static void main(String[] args) {

    }

    public double myPow(double x, int n) {
        return n >= 0 ? dfs(x, n) : 1.0 / dfs(x, -n);
    }

    private double dfs(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double res = dfs(x, n / 2);
        return n % 2 == 0 ? res * res : res * res * x;
    }
}
