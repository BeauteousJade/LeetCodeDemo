package twoPointer;

import java.util.Arrays;

/**
 * 186. 反转字符串中的单词 II
 * <p>
 * https://leetcode.cn/problems/reverse-words-in-a-string-ii/
 */
public class ReverseWordsV2Demo {

    public static void main(String[] args) {
        ReverseWordsV2Demo demo = new ReverseWordsV2Demo();
        char[] s = new char[]{'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        System.out.println(Arrays.toString(s));
        demo.reverseWords(s);
        System.out.println(Arrays.toString(s));
    }

    public void reverseWords(char[] s) {
        int length = s.length;
        // 全部反向
        reverseRange(s, 0, length - 1);
        System.out.println(Arrays.toString(s));
        int start = 0;
        for (int i = 0; i < length; i++) {
            if (s[i] == ' ') {
                // 局部反向。
                int end = i - 1;
                reverseRange(s, start, end);
                start = i + 1;
            }
        }
        reverseRange(s, start, length - 1);
    }

    public void reverseRange(char[] s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}
