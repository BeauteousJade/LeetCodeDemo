package dp;

/**
 * 634. 寻找数组的错位排列
 * <p>
 * https://leetcode.cn/problems/find-the-derangement-of-an-array/
 */
// TODO 下次
public class FindDerangementDemo {

    public static void main(String[] args) {
        FindDerangementDemo demo = new FindDerangementDemo();
        System.out.println(demo.findDerangement(3));
    }

    /**
     * 首先明确dp[n]表示一共有n个元素，
     * 每个元素都不能放在自己现在位置的方案数。比如初始状态是[1,2,3,4,5]，
     * 现在考虑将1和后面的元素交换位置，那么1一共有n-1个位置可以选择，
     * 假设选中了2与1交换，状态变为[2,1,3,4,5]，令当前状态(2的位置不能动)的方案数为K，
     * 那么首先你要明白的是，dp[n]=(n-1)*K，也就是说，不管1与后面的哪个元素交换，
     * 交换之后的状态都有K种方案数。怎么求K呢，现在考虑状态[1,3,4,5]，
     * 这个局面有两种操作方法，一种是1不变，变换[3,4,5]，这个方案的值就是dp[n-2]；
     * 另一种是1也参与进来，那么意味着，每个元素都不能放在现在的位置，
     * 因此方案数dp[n-1]。即K=dp[n-1]+dp[n-2]。
     * dp[n] = (n - 1) * (dp[i - 1] + dp[i - 2])
     */
    public int findDerangement(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = (int) ((i - 1L) * (dp[i - 1] + dp[i - 2]) % 1000000007);
        }
        return dp[n];
    }
}
