package disjointSet;

import java.util.HashMap;
import java.util.Map;

/**
 * 839. 相似字符串组
 * <p>
 * https://leetcode.cn/problems/similar-string-groups/
 */
public class NumSimilarGroupsDemo {


    public static void main(String[] args) {

    }

    public int numSimilarGroups(String[] strs) {
        parent = new int[strs.length];
        for (String string : strs) {
            int id = putMap(string);
            parent[id] = id;
        }
        count = map.size();

        for (int i = 0; i < strs.length - 1; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (check(strs[i], strs[j])) {
                    add(map.get(strs[i]), map.get(strs[j]));
                }
            }
        }
        return count;
    }

    private boolean check(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        if (string1.equals(string2)) {
            return true;
        }
        int index1 = -1;
        int index2 = -1;
        int index = 0;
        while (index < string1.length()) {
            if (string1.charAt(index) != string2.charAt(index)) {
                if (index1 == -1) {
                    index1 = index;
                } else if (index2 == -1) {
                    index2 = index;
                } else {
                    return false;
                }
            }
            index++;
        }

        return index1 != -1 && index2 != -1 && string1.charAt(index1) == string2.charAt(index2) && string1.charAt(index2) == string2.charAt(index1);
    }

    private int putMap(String string) {
        if (map.containsKey(string)) {
            return map.get(string);
        } else {
            int id = map.size();
            map.put(string, id);
            return id;
        }
    }

    private Map<String, Integer> map = new HashMap<>();
    private int count = 0;

    private int[] parent;

    private int find(int a) {
        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }

    private void add(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return;
        }
        parent[rootB] = rootA;
        count--;
    }
}
