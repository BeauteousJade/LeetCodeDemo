package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 527. 单词缩写
 * <p>
 * https://leetcode.cn/problems/word-abbreviation/
 */
public class WordsAbbreviationDemo {


    public static void main(String[] args) {
        WordsAbbreviationDemo demo = new WordsAbbreviationDemo();
//        List<String> list = Arrays.asList("like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion");
        List<String> list = Arrays.asList("aa", "aaa");
        System.out.println(demo.wordsAbbreviation(list));
    }


    /**
     * 贪心，从最短的缩写可以判断。
     */
    public List<String> wordsAbbreviation(List<String> words) {

        List<String> res = new ArrayList<>();

        for (String string : words) {
            if (string.length() <= 3) {
                res.add(string);
                continue;
            }
            String resString = string;
            for (int i = 1; i < string.length() - 2; i++) {
                String prefixString = string.substring(0, i);
                String suffixString = String.valueOf(string.charAt(string.length() - 1));
                boolean isFlag = true;
                for (String tempString : words) {
                    if (string.equals(tempString) || string.length() != tempString.length()) {
                        continue;
                    }
                    if (tempString.startsWith(prefixString) && tempString.endsWith(suffixString)) {
                        isFlag = false;
                        break;
                    }
                }
                if (isFlag) {
                    resString = prefixString + "" + (string.length() - i - 1) + suffixString;
                    break;
                }
            }
            res.add(resString);
        }
        return res;
    }
}
