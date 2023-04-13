package disjointSet;

import java.util.Arrays;

/**
 * 684. 冗余连接
 * <p>
 * https://leetcode.cn/problems/redundant-connection/
 */
public class FindRedundantConnectionDemo {

    public static void main(String[] args) {
        int[][] array = {{1, 2}, {1, 3}, {2, 3}};
        FindRedundantConnectionDemo demo = new FindRedundantConnectionDemo();
        System.out.println(Arrays.toString(demo.findRedundantConnection(array)));
    }


    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            boolean added = add(a, b);
            if (!added) {
                return edges[i];
            }
        }

        return null;
    }

    private int[] parent;


    private int find(int a) {
        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }

    private boolean add(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return false;
        }
        parent[rootB] = rootA;
        return true;
    }
}
