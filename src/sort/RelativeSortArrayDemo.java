package sort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1122. 数组的相对排序
 * <p>
 * https://leetcode.cn/problems/relative-sort-array/
 */
public class RelativeSortArrayDemo {

    public static void main(String[] args) {

    }

    /**
     * 计数排序。
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = 0;
        for (int x : arr1) {
            max = Math.max(max, x);
        }
        int[] count = new int[max + 1];
        for (int x : arr1) {
            count[x]++;
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int x : arr2) {
            for (int i = 0; i < count[x]; ++i) {
                ans[index++] = x;
            }
            count[x] = 0;
        }
        for (int x = 0; x <= max; ++x) {
            for (int i = 0; i < count[x]; ++i) {
                ans[index++] = x;
            }
        }
        return ans;
    }

    /**
     * 自定义排序
     */
    public int[] relativeSortArrayV2(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        List<Integer> res = Arrays.stream(arr1).boxed().collect(Collectors.toList());
        Collections.sort(res, (o1, o2) -> {
            if (map.containsKey(o1) && map.containsKey(o2)) {
                return map.getOrDefault(o1, 0).compareTo(map.getOrDefault(o2, 0));
            } else if (map.containsKey(o1)) {
                return -1;
            } else if (map.containsKey(o2)) {
                return 1;
            }
            return o1 - o2;
        });
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
