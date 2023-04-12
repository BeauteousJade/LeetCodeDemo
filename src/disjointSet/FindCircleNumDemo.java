package disjointSet;

/**
 * 547. 省份数量
 * <p>
 * https://leetcode.cn/problems/number-of-provinces/
 */
public class FindCircleNumDemo {

    public static void main(String[] args) {

    }

    private int[] parent;
    private int count;

    public int findCircleNum(int[][] isConnected) {
        parent = new int[isConnected.length];
        count = parent.length;
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] != 0) {
                    add(i, j);
                }
            }
        }
        return count;
    }

    private int find(int a) {
        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }

    private void add(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return;
        }
        parent[rootB] = rootA;
        count--;
    }


}
