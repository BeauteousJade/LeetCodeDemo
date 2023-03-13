package greedy;

import java.util.Collections;
import java.util.List;

/**
 * 539. 最小时间差
 * <p>
 * https://leetcode.cn/problems/569nqc/
 */
public class FindMinDifferenceDemo {

    public static void main(String[] args) {

    }

    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int ans = Integer.MAX_VALUE;
        int t0Minutes = getMinutes(timePoints.get(0));
        int preMinutes = t0Minutes;
        for (int i = 1; i < timePoints.size(); ++i) {
            int minutes = getMinutes(timePoints.get(i));
            ans = Math.min(ans, minutes - preMinutes); // 相邻时间的时间差
            preMinutes = minutes;
        }
        // 24 * 60  = 1440
        ans = Math.min(ans, t0Minutes + 1440 - preMinutes); // 首尾时间的时间差
        return ans;
    }

    public int getMinutes(String t) {
        return ((t.charAt(0) - '0') * 10 + (t.charAt(1) - '0')) * 60 + (t.charAt(3) - '0') * 10 + (t.charAt(4) - '0');
    }
}
