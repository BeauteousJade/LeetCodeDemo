package bfs;

import java.util.*;

/**
 * 444. 序列重建
 * <p>
 * https://leetcode.cn/problems/sequence-reconstruction/
 */
public class SequenceReconstructionDemo {

    public static void main(String[] args) {
        SequenceReconstructionDemo demo = new SequenceReconstructionDemo();
        int[][] array = {{1, 2}, {1, 3}, {2, 3}};
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            List<Integer> res = new ArrayList<>();
            for (int j = 0; j < array[0].length; j++) {
                res.add(array[i][j]);
            }
            list.add(res);
        }
        System.out.println(demo.sequenceReconstructionV2(new int[]{1, 2, 3}, list));
    }

    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        int n = nums.length;
        // 记录每个num 拥有上一个数字的个数。
        int[] counts = new int[n + 1];
        // 记录每个节点的下一个数字。
        Set<Integer>[] sets = new Set[n + 1];
        for (int i = 1; i <= n; i++) {
            sets[i] = new HashSet<Integer>();
        }
        for (List<Integer> sequence : sequences) {
            int size = sequence.size();
            for (int i = 1; i < size; i++) {
                Integer prev = sequence.get(i - 1);
                Integer current = sequence.get(i);
                counts[current]++;
                sets[prev].add(current);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            // 没有前置数字，表示可以直接入队。
            if (counts[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            // 如果当前queue的size大于1，证明了两点：
            // 1. 序列下一个数字不是唯一的。
            // 2. 可能存在有某些数组没有出现在sequences里面,证明nums不是最短序列。
            if (queue.size() > 1) {
                return false;
            }
            Set<Integer> set = sets[queue.poll()];
            for (Integer i : set) {
                counts[i]--;
                // 如果count为0，表示当前没有前置的数字，可以入队
                if (counts[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        return true;
    }


    /**
     * 用普通的Map来维护状态--超时。
     */
    public boolean sequenceReconstructionV2(int[] nums, List<List<Integer>> sequences) {
        int n = nums.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (List<Integer> sequence : sequences) {
            int size = sequence.size();
            for (int i = 1; i < size; i++) {
                Integer prev = sequence.get(i - 1);
                Integer current = sequence.get(i);
                Set<Integer> set = map.computeIfAbsent(current, integer -> new HashSet<>());
                set.add(prev);

            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            // 没有前置数字，表示可以直接入队。
            if (!map.containsKey(i)) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            // 如果当前queue的size大于1，证明了两点：
            // 1. 序列下一个数字不是唯一的。
            // 2. 可能存在有某些数组没有出现在sequences里面,证明nums不是最短序列。
            if (queue.size() > 1) {
                return false;
            }
            Integer poll = queue.poll();
            Set<Integer> keySet = new HashSet<>(map.keySet());
            for (Integer key : keySet) {
                Set<Integer> set = map.get(key);
                if (set == null) {
                    continue;
                }
                boolean isRemove = set.remove(poll);
                if (set.isEmpty() && isRemove) {
                    queue.offer(key);
                    map.remove(key);
                }
            }
        }
        return true;
    }
}
