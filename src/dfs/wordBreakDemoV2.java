package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 140. 单词拆分 II
 * <p>
 * https://leetcode.cn/problems/word-break-ii/
 */
public class wordBreakDemoV2 {

    public static void main(String[] args) {

    }

    private final List<String> res = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        dfs(s, 0, wordDict, new LinkedList<>());
        return res;
    }

    private void dfs(String s, int start, List<String> wordDict, List<String> list) {
        if (start == s.length()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                String string = list.get(i);
                stringBuilder.append(string);
                if (i == list.size() - 1) {
                    stringBuilder.append(" ");
                }
            }
            res.add(stringBuilder.toString());
        } else {
            for (int i = start; i < s.length(); i++) {
                String subString = s.substring(start, i + 1);
                if (wordDict.contains(subString)) {
                    list.add(subString);
                    dfs(s, i + 1, wordDict, list);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
