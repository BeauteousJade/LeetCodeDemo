package backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 254. 因子的组合
 * <p>
 * https://leetcode.cn/problems/factor-combinations/?favorite=qg88wci
 */
public class GetFactorsDemo {
    public static void main(String[] args) {
        GetFactorsDemo demo = new GetFactorsDemo();
        System.out.println(demo.getFactors(4));
    }


    public List<List<Integer>> getFactors(int n) {
        return dfs(2, n);
    }

    private List<List<Integer>> dfs(int start, int num) {
        if (num == 1) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        int end = (int) Math.sqrt(num);
        for (int i = start; i <= end; i++) {
            if (num % i == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(num / i);
                res.add(list);
                List<List<Integer>> lists = dfs(i, num / i);
                for (List<Integer> newList : lists) {
                    newList.add(0, i);
                    res.add(newList);
                }
            }
        }
        return res;
    }
}
