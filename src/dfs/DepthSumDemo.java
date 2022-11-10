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

}
