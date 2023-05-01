package dataStructure;

import java.util.*;

/**
 * 剑指 Offer II 030. 插入、删除和随机访问都是 O(1) 的容器
 * <p>
 * https://leetcode.cn/problems/FortPu/?envType=study-plan-v2&id=coding-interviews-special
 */
class RandomizedSet {

    List<Integer> nums;
    Map<Integer, Integer> indices;
    Random random;

    public RandomizedSet() {
        nums = new ArrayList<>();
        indices = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (indices.containsKey(val)) {
            return false;
        }
        int index = nums.size();
        nums.add(val);
        indices.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if (!indices.containsKey(val)) {
            return false;
        }
        // 这里是把last 移动到index位置上，然后删除last. 保证O(1)时间复杂.
        int valIndex = indices.get(val);
        int lastValue = nums.get(nums.size() - 1);
        nums.set(valIndex, lastValue);
        indices.put(lastValue, valIndex);
        nums.remove(nums.size() - 1);
        indices.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }

}