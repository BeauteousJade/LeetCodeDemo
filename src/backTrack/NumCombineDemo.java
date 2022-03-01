package backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * <p>
 * https://leetcode-cn.com/problems/combinations/
 */
public class NumCombineDemo {

    public static void main(String[] args) {
        NumCombineDemo demo = new NumCombineDemo();
        System.out.println(demo.combine(4, 2));
    }

    private final List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        boolean[] rec = new boolean[n];
        backTrack(new ArrayList<>(), rec, k, n, 1);
        return result;
    }


    private void backTrack(List<Integer> list, boolean[] rec, int k, int n, int index) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i = index; i <= n; i++) {
                if (!rec[i - 1]) {
                    rec[i - 1] = true;
                    list.add(i);
                    backTrack(list, rec, k, n, i + 1);
                    list.remove(list.size() - 1);
                    rec[i - 1] = false;
                }
            }
        }
    }
}
