package backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 320. 列举单词的全部缩写
 * <p>
 * https://leetcode.cn/problems/generalized-abbreviation/
 */
public class GenerateAbbreviationsDemo {


    public static void main(String[] args) {
        GenerateAbbreviationsDemo demo = new GenerateAbbreviationsDemo();
        System.out.println(demo.generateAbbreviations("word"));
    }

    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        backTrack(res, new StringBuilder(), word, 0, 0);
        return res;
    }


    private void backTrack(List<String> res, StringBuilder stringBuilder, String word, int i, int k) {
        int length = stringBuilder.length();
        if (i == word.length()) {
            if (k != 0) {
                stringBuilder.append(k);
            }
            res.add(stringBuilder.toString());
        } else {

            // 1. 将当前字符省略。
            backTrack(res, stringBuilder, word, i + 1, k + 1);


            // 2. 不省略当前字符。
            if (k != 0) {
                stringBuilder.append(k);
            }
            stringBuilder.append(word.charAt(i));
            backTrack(res, stringBuilder, word, i + 1, 0);
        }
        // 重置
        stringBuilder.setLength(length);
    }


}
