package queue;

import java.util.*;

/**
 * 358. K 距离间隔重排字符串
 * <p>
 * https://leetcode.cn/problems/rearrange-string-k-distance-apart/
 */
public class RearrangeStringDemo {


    public static void main(String[] args) {
        RearrangeStringDemo demo = new RearrangeStringDemo();
        System.out.println(demo.rearrangeString("aa", 0));
    }

    public String rearrangeString(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 大顶堆。
        Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        queue.addAll(map.entrySet());
        StringBuilder stringBuilder = new StringBuilder();
        Queue<Map.Entry<Character, Integer>> queue1 = new LinkedList<>();
        while (!queue.isEmpty()) {
            // 1. 从大顶堆取出当前出现次数最多的字符。追加到新字符串的后面 -- 贪心。
            Map.Entry<Character, Integer> entry = queue.poll();
            stringBuilder.append(entry.getKey());
            // 用来记录当前字符。
            queue1.offer(entry);
            entry.setValue(entry.getValue() - 1);
            // 2. 如果当前字符距离已经超过K。那么表示可以重复出现了。因此将记录的最前面字符进入大顶堆，表示可以重复出现了。
            if (queue1.size() >= k) {
                Map.Entry<Character, Integer> entry1 = queue1.poll();
                if (entry1.getValue() > 0) {
                    queue.offer(entry1);
                }
            }
        }
        return stringBuilder.length() == s.length() ? stringBuilder.toString() : "";
    }


}
