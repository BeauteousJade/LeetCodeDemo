package bfs;

import java.util.*;

/**
 * 743. 网络延迟时间
 * 有 n 个网络节点，标记为 1 到 n。
 * <p>
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 * <p>
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1
 * <p>
 * <p>
 * <p>
 * 最短路：dijkstra
 * <p>
 * https://leetcode-cn.com/problems/network-delay-time/
 */
public class NetworkDelayTimeDemo {

    public static void main(String[] args) {
        NetworkDelayTimeDemo demo = new NetworkDelayTimeDemo();
        int[][] times = new int[][]{{4, 2, 76}, {1, 3, 79}, {3, 1, 81}, {4, 3, 30}, {2, 1, 47}, {1, 5, 61}, {1, 4, 99}, {3, 4, 68}, {3, 5, 46}, {4, 1, 6}, {5, 4, 7}, {5, 3, 44}, {4, 5, 19}, {2, 3, 13}, {3, 2, 18}, {1, 2, 0}, {5, 1, 25}, {2, 5, 58}, {2, 4, 77}, {5, 2, 74}};
        int n = 5;
        int k = 3;
        System.out.println(demo.networkDelayTime(times, n, k));
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] cost = new int[n + 1];
        int[][] costRec = new int[n + 1][n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        for (int i = 0; i <= n; i++) {
            Arrays.fill(costRec[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < times.length; i++) {
            costRec[times[i][0]][times[i][1]] = times[i][2];
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k);
        cost[k] = 0;
        int res = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            int[] nodeCostRec = costRec[node];
            for (int i = 0; i < nodeCostRec.length; i++) {
                if (nodeCostRec[i] != Integer.MAX_VALUE && cost[node] + nodeCostRec[i] < cost[i]) {
                    queue.offer(i);
                    cost[i] = Math.min(cost[i], cost[node] + nodeCostRec[i]);
                }
            }
        }

        for (int i = 1; i < cost.length; i++) {
            if (cost[i] == Integer.MAX_VALUE) {
                return -1;
            } else {
                res = Math.max(res, cost[i]);
            }
        }
        return res;
    }
}
