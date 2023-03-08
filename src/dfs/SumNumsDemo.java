package dfs;

/**
 * 剑指 Offer 64. 求1+2+…+n
 * <p>
 * https://leetcode.cn/problems/qiu-12n-lcof/
 */
public class SumNumsDemo {

    public static void main(String[] args) {
        SumNumsDemo demo = new SumNumsDemo();
        System.out.println(demo.sumNums(2));
    }

    int sum = 0;

    public int sumNums(int n) {
        boolean res = n > 1 && sumNums(n - 1) > 0;
        sum += n;
        return sum;
    }
}
