package bfs;

import java.util.*;

/**
 * 399. 除法求值
 * <p>
 * https://leetcode.cn/problems/evaluate-division/
 */
public class CalcEquationDemo {

    public static void main(String[] args) {

    }

    /**
     * 基本思路：先根据信息，建立起带权值的图，然后在从起点搜索到终点。
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Integer> map = new HashMap<>();

        // 1. 给每个词分配一个index.
        int index = 0;
        for (List<String> equation : equations) {
            String string1 = equation.get(0);
            String string2 = equation.get(1);
            if (!map.containsKey(string1)) {
                map.put(string1, index++);
            }
            if (!map.containsKey(string2)) {
                map.put(string2, index++);
            }
        }

        // 2. 建立带权的图。
        List<Pair>[] list = new List[index];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < equations.size(); i++) {
            int index1 = map.get(equations.get(i).get(0));
            int index2 = map.get(equations.get(i).get(1));
            list[index1].add(new Pair(index2, values[i]));
            list[index2].add(new Pair(index1, 1.0 / values[i]));
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            double result = -1;
            if (map.containsKey(queries.get(i).get(0)) && map.containsKey(queries.get(i).get(1))) {
                int index1 = map.get(queries.get(i).get(0));
                int index2 = map.get(queries.get(i).get(1));
                if (index1 == index2) {
                    result = 1;
                } else {
                    // 3. 从起点开始搜索，到终点。每搜索一次，根据权值计算每个节点对应的结果。
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(index1);
                    double[] ratios = new double[index];
                    Arrays.fill(ratios, -1);
                    ratios[index1] = 1;
                    while (!queue.isEmpty()) {
                        int current = queue.poll();
                        if (current == index2) {
                            result = ratios[current];
                            break;
                        }
                        for (Pair pair : list[current]) {
                            int nextIndex = pair.index;
                            double nextValue = pair.value;
                            if (ratios[nextIndex] < 0) {
                                ratios[nextIndex] = ratios[current] * nextValue;
                                queue.offer(nextIndex);
                            }
                        }
                    }
                }
            }
            res[i] = result;

        }
        return res;
    }

    private static class Pair {
        int index;
        double value;

        public Pair(int index, double value) {
            this.value = value;
            this.index = index;
        }
    }

}
