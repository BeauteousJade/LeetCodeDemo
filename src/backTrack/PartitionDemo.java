package backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 086. 分割回文子字符串
 * <p>
 * https://leetcode.cn/problems/M99OJA/
 */
public class PartitionDemo {

    public static void main(String[] args) {

    }

    private final List<List<String>> list = new ArrayList<>();

    public String[][] partition(String s) {
        dfs(0, s, new ArrayList<>());
        String[][] res = new String[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i).toArray(new String[0]);
        }
        return res;
    }


    private void dfs(int index, String s, List<String> list) {
        if (index == s.length()) {
            this.list.add(new ArrayList<>(list));
        } else {
            for (int i = index; i < s.length(); i++) {
                String str = s.substring(index, i + 1);
                if (check(str)) {
                    list.add(str);
                    dfs(i + 1, s, list);
                    list.remove(list.size() - 1);
                }
            }
        }
    }


    private boolean check(String string) {
        int left = 0;
        int right = string.length() - 1;
        while (left <= right) {
            if (string.charAt(left) != string.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
