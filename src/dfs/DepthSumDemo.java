package dfs;

import java.util.List;

/**
 * 339. 嵌套列表权重和
 * <p>
 * https://leetcode.cn/problems/nested-list-weight-sum/?favorite=qg88wci
 */
public class DepthSumDemo {


    public static void main(String[] args) {

    }


    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }

    private int dfs(List<NestedInteger> nestedList, int k) {
        int res = 0;
        for (int i = 0; i < nestedList.size(); i++) {
            NestedInteger nestedInteger = nestedList.get(i);
            if (nestedInteger.isInteger()) {
                res += k * nestedInteger.getInteger();
            } else {
                res += dfs(nestedInteger.getList(), k + 1);
            }
        }
        return res;
    }


    public interface NestedInteger {
        // Constructor initializes an empty nested list.

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }
}
