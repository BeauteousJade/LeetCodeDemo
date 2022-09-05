package topk;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 215. 数组中的第K个最大元素
 * <p>
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * <p>
 * topK
 */
public class FindKthLargestDemo {

    public static void main(String[] args) {
        FindKthLargestDemo demo = new FindKthLargestDemo();
        int[] array = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(demo.findKthLargest(array, k));
    }

    public int findKthLargest(int[] nums, int k) {
        // 从小到大排序
        Queue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());
        for (int value : nums) {
            queue.offer(value);
            if (queue.size() > k) {
                // 弹出小的，就从小到大排序(第K大)。弹出大的，就从大道小排序(第K小)。
                queue.poll();
            }
        }
        return queue.poll();
    }
}
