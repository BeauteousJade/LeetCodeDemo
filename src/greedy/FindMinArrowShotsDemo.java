package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. 用最少数量的箭引爆气球
 * <p>
 * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */
public class FindMinArrowShotsDemo {

    public static void main(String[] args) {

    }

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        // 按右侧边界，从大到小排序
        Arrays.sort(points, (o1, o2) -> {
            if (o1[1] > o2[1]) {
                return 1;
            } else if (o1[1] < o2[1]) {
                return -1;
            }
            return 0;
        });
        int ans = 1;
        int[] pre = points[0];
        for (int[] array : points) {
            // 一旦一个气球左侧边界，大于上次的右侧边界，表示它没有跟前面的气球重叠
            // 需要多消耗一次。
            if (array[0] > pre[1]) {
                pre = array;
                ans++;
            }
        }
        return ans;
    }
}
