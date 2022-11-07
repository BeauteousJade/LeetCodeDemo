package disjointSet;

/**
 * 323. 无向图中连通分量的数目
 * <p>
 * https://leetcode.cn/problems/number-of-connected-components-in-an-undirected-graph/?favorite=qg88wci
 */
public class CountComponentsDemo {

    public static void main(String[] args) {
        CountComponentsDemo demo = new CountComponentsDemo();
        int n = 5;
        int[][] array = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        System.out.println(demo.countComponents(n, array));
    }


    private int count = 0;
    private int[] root;


    public int countComponents(int n, int[][] edges) {
        root = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        return count;
    }

    private int find(int a) {
        if (root[a] != a) {
            root[a] = find(root[a]);
        }
        return root[a];
    }

    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            // 已经相连
            return;
        }
        // 将B 连接到A上。
        root[rootB] = rootA;
        count--;
    }


}
