package array;

/**
 * 616. 给字符串添加加粗标签
 * <p>
 * https://leetcode.cn/problems/add-bold-tag-in-string/?favorite=qg88wci
 */
public class AddBoldTagDemo {

    public static void main(String[] args) {
        AddBoldTagDemo demo = new AddBoldTagDemo();
        String s = "abcdef";
        String[] array = {"a", "c", "e", "g"};
        System.out.println(demo.addBoldTag(s, array));
    }

    public String addBoldTag(String s, String[] words) {
        boolean[] mask = new boolean[s.length()];
        for (String word : words) {

            for (int j = 0; j < s.length(); j++) {
                int start = s.indexOf(word, j);
                for (int i = start; i >= 0 && i < start + word.length(); i++) {
                    mask[i] = true;
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
