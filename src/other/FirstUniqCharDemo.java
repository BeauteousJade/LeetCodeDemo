package other;

/**
 * 387. 字符串中的第一个唯一字符
 * <p>
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqCharDemo {

    public static void main(String[] args) {

    }

    public int firstUniqChar(String s) {
        int[] array = new int[26];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            array[charArray[i] - 'a']++;
        }
        for (int i = 0; i < charArray.length; i++) {
            if (array[charArray[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
