package bucket;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 剑指 Offer II 057. 值和下标之差都在给定的范围内
 * <p>
 * https://leetcode.cn/problems/7WqeDu/
 */
public class ContainsNearbyAlmostDuplicateDemo {

    public static void main(String[] args) {

    }

    /**
     * 滑动窗口 + 有序集合。
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 这里是从Set里面去查询大于等于(long) nums[i] - (long) t的数字，如果有则返回；如果没有则返回为null。
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }


    /**
     * 桶
     */
    public boolean containsNearbyAlmostDuplicateV2(int[] nums, int k, int t) {
        // 桶的容量
        int w = t + 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 生成桶Id.
            int id = getId(nums[i], w);
            // 判断是否会在同一个桶里面，如果是的话，那么表示有符合要求的两个数字。
            if (map.containsKey(id)) {
                return true;
            }
            // 判断左侧的桶，是否包含符合要求的数字
            if (map.containsKey(id - 1) && nums[i] - map.get(id - 1) < w) {
                return true;
            }
            // 判断右侧的桶，是否包含符合要求的数字
            if (map.containsKey(id + 1) && map.get(id + 1) - nums[i] < w) {
                return true;
            }
            map.put(id, nums[i]);
            if (i >= k) {
                map.remove(getId(nums[i - k], w));
            }
        }
        return false;
    }

    private int getId(int num, int w) {
        if (num >= 0) {
            return num / w;
        }
        return (num + 1) / w - 1;
    }
}
