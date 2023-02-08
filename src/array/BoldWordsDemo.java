package array;

/**
 * 758. 字符串中的加粗单词
 * <p>
 * https://leetcode.cn/problems/bold-words-in-string/
 *
 * @see AddBoldTagDemo 跟此题是一样的
 */
public class BoldWordsDemo {

    public static void main(String[] args) {
        BoldWordsDemo demo = new BoldWordsDemo();
        String[] array = {"ab", "bc"};

        System.out.println(demo.boldWords(array, "aabcd"));
    }

    public String boldWords(String[] words, String s) {
        boolean[] mask = new boolean[s.length()];
        for (String word : words) {
            for (int i = 0; i < s.length(); i++) {
                int start = s.indexOf(word, i);
                for (int j = start; j >= 0 && j < start + word.length(); j++) {
                    mask[j] = true;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (mask[i] && (i == 0 || !mask[i - 1])) {
                stringBuilder.append("<b>");
            }
            stringBuilder.append(s.charAt(i));
            if (mask[i] && (i == s.length() - 1 || !mask[i + 1])) {
                stringBuilder.append("</b>");
            }
        }
        return stringBuilder.toString();
    }
}
