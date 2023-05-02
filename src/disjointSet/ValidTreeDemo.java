package disjointSet;

/**
 * 261. 以图判树
 * <p>
 * https://leetcode.cn/problems/graph-valid-tree/
 */
public class ValidTreeDemo {

    public static void main(String[] args) {

    }

    private int[] parent;

    public boolean validTree(int n, int[][] edges) {
        if (n - edges.length != 1) {
            return false;
        }
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] array : edges) {
            boolean added = add(array[0], array[1]);
            if (!added) {
                return false;
            }
        }

        return true;
    }

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
