package bfs;

import java.util.*;

/**
 * 582. 杀掉进程
 * <p>
 * https://leetcode.cn/problems/kill-process/
 */
// TODO 下次
public class KillProcessDemo {

    public static void main(String[] args) {
        List<Integer> pid = Arrays.asList(1);
        List<Integer> ppid = Arrays.asList(0);
        KillProcessDemo demo = new KillProcessDemo();
        System.out.println(demo.killProcess(pid, ppid, 1));
    }

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = pid.size();
        for (int i = 0; i < n; i++) {
            int parentId = ppid.get(i);
            List<Integer> list = map.computeIfAbsent(parentId, k -> new ArrayList<>());
            list.add(pid.get(i));
        }
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(kill);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            res.add(current);
            List<Integer> list = map.get(current);
            if (list != null) {
                for (int next : list) {
                    queue.offer(next);
                }
            }
        }
        return res;
    }
}
