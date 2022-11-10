package dfs;

import java.util.List;

/**
 * 364. 加权嵌套序列和 II
 * <p>
 * https://leetcode.cn/problems/nested-list-weight-sum-ii/?favorite=qg88wci
 */
public class DepthSumInverseDemo {

    public static void main(String[] args) {

    }

    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = getDepth(nestedList);
        return dfs(nestedList, maxDepth, 1);
    }


    private int getDepth(List<NestedInteger> list) {
        int res = 0;
        for (NestedInteger integer : list) {
            if (!integer.isInteger()) {
                res = Math.max(res, 1 + getDepth(integer.getList()));
            } else {
                // 过滤无效嵌套的情况，例如：[[1,1],2,[1,1],[[[[]]]]]
                res = Math.max(res, 1);
            }
        }
        return res;
    }

    private int dfs(List<NestedInteger> list, int maxDepth, int currentDepth) {
        int res = 0;
        for (NestedInteger integer : list) {
            if (integer.isInteger()) {
                res += (maxDepth - currentDepth + 1) * integer.getInteger();
            } else {
                res += dfs(integer.getList(), maxDepth, currentDepth + 1);
            }
        }
        return res;
    }
}
