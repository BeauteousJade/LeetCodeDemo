package greedy;

import java.math.BigInteger;

/**
 * 剑指 Offer 14- II. 剪绳子 II
 * <p>
 * https://leetcode.cn/problems/jian-sheng-zi-ii-lcof/
 */
public class CuttingRopeDemo {

    public static void main(String[] args) {

    }

    /**
     * dp 写法。
     * 记住，不能在dp过程 取模，只能最终结果取模。
     * <p>
     * 尝试在动态规划的基础上取余，就算把数据类型都换成long也是无解的，对每次的dp[i]取余确实可以避免溢出的问题，但是由于过程中修改了值，会导致最终结果和预期不同。比如
     * 这一步：
     * dp[i] = Math.max(dp[i]，x * y);
     * x * y = 1000000005 ，若dp[i] 本该等于 1000000008 ，但是经过上次取余后变成了1，本来的结果应该是1000000008 ，现在却变成了1000000005，所以在动态规划过程中是不能取余的，那么就只能使用BigInter存储中间结果了
     * <p>
     * https://leetcode.cn/problems/jian-sheng-zi-ii-lcof/solution/di-zi-fen-xi-shi-yong-dong-tai-gui-hua-q-jlr7/
     */
    public int cuttingRope(int n) {
        BigInteger[] dp = new BigInteger[n + 1];
        dp[1] = BigInteger.valueOf(0L);
        dp[2] = BigInteger.valueOf(1L);
        for (int i = 3; i <= n; i++) {
            dp[i] = BigInteger.valueOf(0);
            for (int j = 1; j < i; j++) {
                dp[i] = dp[i].max(dp[i - j].multiply(BigInteger.valueOf(j))).max(BigInteger.valueOf(i - j).multiply(BigInteger.valueOf(j)));
            }
        }
        return dp[n].mod(BigInteger.valueOf(1000000007)).intValue();
    }


    /**
     * 贪心 + 循环取模。
     * <p>
     * 本题的特点是将绳子全部按照长度为3进行切割乘积结果是最大的（证明过程略过，其实贪心本来也可以不需要证明，找不出反例即可）
     * 不过有几种情况需要注意：
     * (1) 在剩余长度等于4的时候，要取2 * 2，而不是3
     * (2) 在至少分出1段3的情况下，
     * 剩余n = 2的时候要取2；剩余n = 1的时候要取1
     * <p>
     * 循环取余
     * 所谓循环取余就是每乘一次3就取次余数，为什么这种方法不会像动态规划那样影响最终结果呢，因为本题的动态规划涉及到数的比较，会出现取余后的数和取余前的数相比较的情况，自然会影响后面的结果，
     * 而贪心算法的求解过程就是简单的乘法，(100000009 % 1000000007) * 3 和 (100000009 * 3）% 1000000007的结果是一样的
     */
    public int cuttingRopeV2(int n) {
        if (n < 3) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        long res = 1;
        while (n > 4) {
            res *= 3;
            res %= 1000000007;
            n -= 3;
        }
        return (int) (n * res % 1000000007);
    }
}
