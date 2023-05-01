package dfs;

/**
 * 785. 判断二分图
 * <p>
 * https://leetcode.cn/problems/is-graph-bipartite/
 */
public class IsBipartiteDemo {

    public static void main(String[] args) {

    }

    private final int red = 1;
    private final int green = 2;
    private final int def = 0;
    private int[] colors;
    private boolean isValid = true;


    public boolean isBipartite(int[][] graph) {
        colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == def) {
                dfs(i, red, graph);
            }
        }
        return isValid;
    }

    private void dfs(int node, int color, int[][] graph) {
        colors[node] = color;
        int nextColor = color == red ? green : red;
        for (int neighbor : graph[node]) {
            if (colors[neighbor] == def) {
                dfs(neighbor, nextColor, graph);
            } else if (colors[neighbor] != nextColor) {
                isValid = false;
            }
        }
    }
}
