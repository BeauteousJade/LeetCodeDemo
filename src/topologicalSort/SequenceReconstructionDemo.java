package topologicalSort;

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
        System.out.println(demo.sequenceReconstruction(new int[]{1, 2, 3}, list));
    }

    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        int n = nums.length;
        int[] counts = new int[n + 1];
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
                if (counts[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        return true;
    }
}
