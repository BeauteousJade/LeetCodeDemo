package other;

import java.util.*;

/**
 * 681. 最近时刻
 * <p>
 * https://leetcode.cn/problems/next-closest-time/
 */
public class NextClosestTimeDemo {

    public static void main(String[] args) {
        NextClosestTimeDemo demo = new NextClosestTimeDemo();
        System.out.println(demo.nextClosestTime("19:34"));
    }

    public String nextClosestTime(String time) {
        Set<String> hh = new HashSet<>();
        Set<String> mm = new HashSet<>();
        Set<Character> set = new HashSet<>();
        // 1. 统计出现的数字。
        for (int i = 0; i < time.length(); i++) {
            char c = time.charAt(i);
            if (c != ':') {
                set.add(c);
            }
        }

        // 2. 分别构造小时和分钟，并且分别记录再hh和mm集合里面。
        for (char c1 : set) {
            for (char c2 : set) {
                String str = c1 + "" + c2;
                if (str.compareTo("24") < 0) {
                    hh.add(str);
                }
                if (str.compareTo("60") < 0) {
                    mm.add(str);
                }
            }
        }

        // 3.构造时间。
        List<String> memo = new ArrayList<>();
        for (String h : hh) {
            for (String m : mm) {
                memo.add(h + ":" + m);
            }
        }

        // 4. 排序。
        Collections.sort(memo);
        // 5. 获取下一个时间，所以没有下一个，就取第一个.
        int index = memo.indexOf(time);
        if (index == memo.size() - 1) {
            return memo.get(0);
        }

        return memo.get(index + 1);
    }
}
