package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 624. 数组列表中的最大距离
 * <p>
 * https://leetcode.cn/problems/maximum-distance-in-arrays/
 */
public class MaxDistanceDemo {


    public static void main(String[] args) {
        MaxDistanceDemo demo = new MaxDistanceDemo();
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1, 2, 3));
        res.add(Arrays.asList(4, 5));
        res.add(Arrays.asList(1, 2, 3));
        System.out.println(demo.maxDistance(res));
    }

    /**
     * 正常遍历 -- 超时。
     * <p>
     * 每个一维数组都是升序得。
     */
    public int maxDistance(List<List<Integer>> arrays) {
        int res = 0;
        for (int i = 0; i < arrays.size() - 1; i++) {
            for (int j = i + 1; j < arrays.size(); j++) {
                res = Math.max(res, Math.abs(arrays.get(i).get(0) - arrays.get(j).get(arrays.get(j).size() - 1)));
                res = Math.max(res, Math.abs(arrays.get(j).get(0) - arrays.get(i).get(arrays.get(i).size() - 1)));
            }
        }
        return res;
    }


    public int maxDistanceV2(List<List<Integer>> arrays) {
        int res = Integer.MIN_VALUE;
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> list = arrays.get(i);
            int currentMin = list.get(0);
            int currentMax = list.get(list.size() - 1);
            res = Math.max(res, Math.max(Math.abs(currentMin - max), Math.abs(currentMax - min)));

            min = Math.min(currentMin, min);
            max = Math.max(currentMax, max);
        }
        return res;
    }
}
