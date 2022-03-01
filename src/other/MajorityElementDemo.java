package other;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MajorityElementDemo {

    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Set<Integer> integers = map.keySet();
        for (Integer key : integers) {
            if (map.get(key) > nums.length / 2) {
                return key;
            }
        }
        return 0;
    }
}
