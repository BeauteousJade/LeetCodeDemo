package other;

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
        char[] array = s.trim().toCharArray();
        // 1. 整体反转。
        reverse(array, 0, array.length - 1);
        int left = 0;
        for (int i = left; i < array.length - 1; i++) {
            // 2. 单个反转。
            if (array[i] == ' ' && array[i + 1] != ' ') {
                reverse(array, left, i - 1);
                left = i + 1;
            }
        }
        // 3. 反转最后一个单词。
        reverse(array, left, array.length - 1);

        // 4. 使用快慢指针，消除多余的空格。
        int fastIndex = 0;
        int slowIndex = 0;
        while (fastIndex < array.length) {
            if (array[fastIndex] != ' ' || fastIndex < array.length - 1 && array[fastIndex] == ' ' && array[fastIndex + 1] != ' ') {
                array[slowIndex++] = array[fastIndex];
            }
            fastIndex++;
        }
        // 将多余字符设置为空格。
        for (int i = slowIndex; i < array.length; i++) {
            array[i] = ' ';
        }
        // 记得trim一下，因为上面会把多余字符设置为空格。
        return new String(array).trim();
    }

    private void reverse(char[] array, int start, int end) {
        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}
