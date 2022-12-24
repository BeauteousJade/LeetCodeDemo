package math;

import java.util.List;

/**
 * 469. 凸多边形
 * <p>
 * https://leetcode.cn/problems/convex-polygon/
 */
public class IsConvexDemo {

    public static void main(String[] args) {
    }

    public boolean isConvex(List<List<Integer>> points) {
        int n = points.size();
        long cur, pre = 0;
        for (int i = 0; i < n; i++) {
            cur = crossProduct(points.get((i + 1) % n).get(0) - points.get(i).get(0),
                    points.get((i + 1) % n).get(1) - points.get(i).get(1),
                    points.get((i + 2) % n).get(0) - points.get(i).get(0),
                    points.get((i + 2) % n).get(1) - points.get(i).get(1));
            if (cur != 0) {
                if (cur * pre < 0) {
                    return false;
                }
                pre = cur;
            }
        }
        return true;
    }

    private long crossProduct(long x1, long y1, long x2, long y2) {
        return x1 * y2 - x2 * y1;
    }
}
