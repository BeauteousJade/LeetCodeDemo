package queue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 373. 查找和最小的 K 对数字
 * <p>
 * https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/
 */
public class KSmallestPairsDemo {

    public static void main(String[] args) {

    }

    /**
     * https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/solution/bu-chong-guan-fang-ti-jie-you-xian-dui-l-htf8/
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // (i,j)对，按照nums1[i] + nums[j]的从小到大排序。
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (o1, o2) -> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);
        List<List<Integer>> ans = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        // 只将第一列全部放入到队列中
        for (int i = 0; i < Math.min(m, k); i++) {
            pq.offer(new int[]{i, 0});
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int[] idxPair = pq.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[idxPair[0]]);
            list.add(nums2[idxPair[1]]);
            ans.add(list);
            // 只向右走。 向下走，上面已经初始化。
            // 避免：形成重复选择。
            if (idxPair[1] + 1 < n) {
                pq.offer(new int[]{idxPair[0], idxPair[1] + 1});
            }
        }

        return ans;
    }
}
