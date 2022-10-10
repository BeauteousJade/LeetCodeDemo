package backTrack;

import java.util.*;

/**
 * 247. 中心对称数 II
 * <p>
 * https://leetcode.cn/problems/strobogrammatic-number-ii/
 */
public class FindStrobogrammaticDemo {

    public static void main(String[] args) {
        FindStrobogrammaticDemo demo = new FindStrobogrammaticDemo();
        System.out.println(demo.findStrobogrammatic(14));
    }

    public List<String> findStrobogrammatic(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');

        List<String> list = new ArrayList<>();
        if (n % 2 == 0) {
            dfs(map, n, new StringBuilder(), list);
        } else {
            dfs(map, n, new StringBuilder("0"), list);
            dfs(map, n, new StringBuilder("1"), list);
            dfs(map, n, new StringBuilder("8"), list);
        }
        return list;
    }

    private void dfs(Map<Character, Character> map, int n, StringBuilder stringBuilder, List<String> res) {
        if (stringBuilder.length() >= n) {
            if (stringBuilder.length() == n) {
                res.add(stringBuilder.toString());
            }
        } else {
            Set<Character> keySet = map.keySet();
            for (Character key : keySet) {
                if (key == '0' && (n - stringBuilder.length() == 2)) {
                    continue;
                }
                stringBuilder.insert(0, map.get(key));
                stringBuilder.append(key);
                dfs(map, n, stringBuilder, res);
                stringBuilder.delete(0, 1);
                stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
            }
        }
    }
}
