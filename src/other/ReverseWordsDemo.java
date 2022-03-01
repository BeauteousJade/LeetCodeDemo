package other;

import java.util.ArrayList;
import java.util.List;

/**
 * 151. 翻转字符串里的单词
 * <p>
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
public class ReverseWordsDemo {

    public static void main(String[] args) {
        ReverseWordsDemo demo = new ReverseWordsDemo();
        System.out.println(demo.reverseWords("a good   example"));
    }

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        List<String> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c != ' ') {
                stringBuilder.append(c);
            } else if (stringBuilder.length() != 0) {
                list.add(0, stringBuilder.toString());
                stringBuilder.delete(0, stringBuilder.length());
            }
        }
        if (stringBuilder.length() != 0) {
            list.add(0, stringBuilder.toString());
            stringBuilder.delete(0, stringBuilder.length());
        }
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i));
            if (i != list.size() - 1) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
