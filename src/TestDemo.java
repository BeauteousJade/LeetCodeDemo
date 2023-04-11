import java.util.*;

public class TestDemo {

    public static void main(String[] args) {
        TestDemo demo = new TestDemo();
    }

    public String alienOrder(String[] words) {
        boolean[] rec = new boolean[26];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                rec[words[i].charAt(j) - 'a'] = true;
            }
        }

        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            String current = words[i];
            String next = words[i + 1];
            int length = Math.min(current.length(), next.length());
            int index = 0;
            while (index < length) {
                char c1 = current.charAt(index);
                char c2 = next.charAt(index);
                if (c1 != c2) {
                    map.computeIfAbsent(c2, s -> new HashSet<>()).add(c1);
                    break;
                }
                index++;
            }
            // 不合法
            if (index == length && current.length() > next.length()) {
                return "";
            }
        }
        Queue<Character> queue = new LinkedList<>();

        int count = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            if (rec[c - 'a']) {
                count++;
                if (!map.containsKey(c)) {
                    queue.offer(c);
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        Set<Character> keySet = map.keySet();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            stringBuilder.append(c);
            for (char key : keySet) {
                Set<Character> set = map.get(key);
                boolean removed = set.remove(c);
                if (set.isEmpty() && removed) {
                    queue.offer(key);
                }
            }
        }
        return count == stringBuilder.length() ? stringBuilder.toString() : "";
    }
}
