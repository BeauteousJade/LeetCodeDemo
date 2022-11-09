package hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 356. 直线镜像
 * <p>
 * https://leetcode.cn/problems/line-reflection/
 */
public class IsReflectedDemo {


    public static void main(String[] args) {
        IsReflectedDemo demo = new IsReflectedDemo();
        int[][] array = {{0, 0}, {1, 0}};
        System.out.println(demo.isReflected(array));
    }


    public boolean isReflected(int[][] points) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<List<Integer>> set = new HashSet<>();

        for (int[] point : points) {
            // 1. 找到最大值和最小值。目的是为了找到中间线。
            min = Math.min(min, point[0]);
            max = Math.max(max, point[0]);

            // 2. 将所有的坐标都放在set里面，滤重。
            List<Integer> list = new ArrayList<>();
            list.add(point[0]);
            list.add(point[1]);
            set.add(list);
        }
        int x = (min + max);
        List<Integer> list = new ArrayList<>(2);

        for (int[] point : points) {
            // 3. 基于当前节点，计算它的镜像节点。如果不在set当中，表示不存在当前节点的镜像。
            list.add(x - point[0]);
            list.add(point[1]);
            if (!set.contains(list)) {
                return false;
            }
            list.clear();
        }
        return true;
    }
}
