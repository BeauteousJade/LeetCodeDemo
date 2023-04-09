package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 797. 所有可能的路径
 * <p>
 * https://leetcode.cn/problems/all-paths-from-source-to-target/
 */
public class AllPathsSourceTargetDemo {

    public static void main(String[] args) {

    }

    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(0, graph, list);
        return res;
    }


    private void dfs(int index, int[][] graph, List<Integer> list) {
        if (index == graph.length - 1) {
            res.add(new ArrayList<>(list));
        } else {
            for (int next : graph[index]) {
                list.add(next);
                dfs(next, graph, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
