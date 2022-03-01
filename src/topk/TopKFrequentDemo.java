package topk;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * <p>
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentDemo {

    public static void main(String[] args) {
        TopKFrequentDemo demo = new TopKFrequentDemo();
        System.out.println(Arrays.toString(demo.topKFrequent(new int[]{1, 1, 1, 2, 2, 3, 3, 3}, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            queue.offer(key);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] res = new int[queue.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = queue.poll();
        }
        return res;
    }
}
