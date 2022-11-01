package disjointSet;

import java.util.ArrayList;
import java.util.List;

/**
 * 305. 岛屿数量 II
 * <p>
 * https://leetcode.cn/problems/number-of-islands-ii/
 * <p>
 * 并查集
 */
public class NumIslands2Demo {

    public static void main(String[] args) {

        NumIslands2Demo demo = new NumIslands2Demo();
        int[][] array = {{0, 0}, {0, 1}, {1, 2}, {2, 1}};
        System.out.println(demo.numIslands2(3, 3, array));
    }

    private final static int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {

        List<Integer> res = new ArrayList<>();
        boolean[] rec = new boolean[m * n];
        UnionFind union = new UnionFind(m * n);
        for (int[] position : positions) {
            int x = position[0];
            int y = position[1];
            int index = x * n + y;
            if (!rec[index]) {
                rec[x * n + y] = true;
                union.addCount();
                for (int[] array : DIRECTIONS) {
                    int newX = x + array[0];
                    int newY = y + array[1];
                    int newIndex = newX * n + newY;
                    // 将两个岛屿连接在一起。
                    if (isInArea(newX, newY, m, n) && rec[newIndex] && !union.isConnected(index, newIndex)) {
                        union.union(newIndex, index);
                    }
                }
            }
            res.add(union.count);
        }
        return res;
    }

    private boolean isInArea(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }


    /**
     * 并查集的数据结构。
     * index 表示节点，parent[index]表示该节点的祖宗节点。
     * 并查集有三个操作：
     * 1. 查询。比如说查询祖宗节点，查询两个节点是否相连。
     * 2. 插入，即插入一个新的节点。
     * 3. 合并，即将新的节点合并到集合当中，如果新节点跟集合中所有的节点都不相连，那就创建一个新的。这里默认拥有所有的节点，且每个节点的祖宗默认都是自己。
     */
    private static class UnionFind {

        private final int[] parent;
        private int count;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            count = 0;
        }

        public void addCount() {
            count++;
        }

        public boolean isConnected(int index, int newIndex) {
            return find(index) == find(newIndex);
        }

        public int find(int index) {
            if (parent[index] != index) {
                parent[index] = find(parent[index]);
            }
            return parent[index];
        }

        public void union(int newIndex, int index) {
            int root = find(index);
            int newRoot = find(newIndex);
            if (root == newRoot) {
                return;
            }
            // 将new链接到index的root上。
            parent[newRoot] = root;
            count--;
        }
    }
}
