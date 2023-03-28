package disjointSet;

import java.util.Arrays;

/**
 * 261. 以图判树
 * <p>
 * https://leetcode.cn/problems/graph-valid-tree/
 */
public class ValidTreeDemo {

    public static void main(String[] args) {

    }

    public boolean validTree(int n, int[][] edges) {
        if (n - edges.length != 1) {
            return false;
        }
        int[] temp = new int[n];
        Arrays.fill(temp, -1);
        for (int i = 0; i < edges.length; i++) {
            int node1 = dfs(temp, edges[i][0]);
            int node2 = dfs(temp, edges[i][1]);
            if (node1 == node2) {
                return false;
            }
            //将node2的父亲设置为node1
            temp[node2] = node1;
        }
        return true;
    }

    private int dfs(int[] temp, int node) {
        if (temp[node] == -1) {
            return node;
        } else {
            return dfs(temp, temp[node]);
        }
    }
}
