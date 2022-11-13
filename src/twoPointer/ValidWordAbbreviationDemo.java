package twoPointer;

/**
 * 408. 有效单词缩写
 * <p>
 * https://leetcode.cn/problems/valid-word-abbreviation/?favorite=qg88wci
 */
public class ValidWordAbbreviationDemo {

    public static void main(String[] args) {

    }

    public boolean validWordAbbreviation(String word, String abbr) {
        int wordLength = word.length();
        int length = abbr.length();
        int num = 0;
        int newLength = 0;
        for (int i = 0; i < length; i++) {
            char c = abbr.charAt(i);
            if (c >= 'a' && c <= 'z') {
                newLength += num + 1;
                num = 0;
                if (newLength > wordLength || c != word.charAt(newLength - 1)) {
                    return false;
                }
            } else {
                if (num == 0 && c == '0') {
                    return false;
                }
                num = num * 10 + c - '0';
            }
        }

        return newLength + num == wordLength;
    }
}
