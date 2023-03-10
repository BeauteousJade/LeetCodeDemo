package prefix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 17.05.  字母与数字
 * <p>
 * https://leetcode.cn/problems/find-longest-subarray-lcci/
 */
public class FindLongestSubarrayDemo {

    public static void main(String[] args) {
        FindLongestSubarrayDemo demo = new FindLongestSubarrayDemo();
        System.out.println(Arrays.toString(demo.findLongestSubarray(new String[]{"A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"})));
    }

    public String[] findLongestSubarray(String[] array) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count0 = 0;
        int count1 = 0;
        int left = -1;
        int length = 0;
        for (int i = 0; i < array.length; i++) {
            String str = array[i];
            char c = str.charAt(0);
            if (c >= '0' && c <= '9') {
                count0++;
            } else {
                count1++;
            }
            int diff = count1 - count0;
            if (map.containsKey(diff)) {
                int index = map.get(diff);
                if (i - index > length) {
                    left = index + 1;
                    length = i - index;
                }
            }
            if (!map.containsKey(diff)) {
                map.put(diff, i);
            }
        }
        if (left == -1) {
            return new String[]{};
        }
        String[] res = new String[length];
        for (int i = 0; i < length; i++) {
            res[i] = array[left + i];
        }

        return res;
    }
}
