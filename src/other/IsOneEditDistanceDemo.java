package other;

import java.util.Objects;

/**
 * 161. 相隔为 1 的编辑距离
 * <p>
 * https://leetcode.cn/problems/one-edit-distance/
 */
public class IsOneEditDistanceDemo {

    public static void main(String[] args) {
        IsOneEditDistanceDemo demo = new IsOneEditDistanceDemo();
        System.out.println(demo.isOneEditDistance("abbb", "cabbb"));
    }

    public boolean isOneEditDistance(String s, String t) {
        if (Objects.equals(s, t)) {
            return false;
        }
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        int index1 = 0;
        int index2 = 0;
        char[] charArray1 = s.toCharArray();
        char[] charArray2 = t.toCharArray();
        int count = 0;


        while (index1 < s.length() && index2 < t.length()) {
            if (charArray1[index1] == charArray2[index2]) {
                index1++;
                index2++;
            } else {
                if (count == 1) {
                    return false;
                }
                if (s.length() == t.length()) {
                    // 替换。
                    index1++;
                    index2++;
                } else if (s.length() < t.length()) {
                    // 插入。
                    index2++;
                } else {
                    // 删除。
                    index1++;
                }
                count++;
            }
        }
        return true;
    }
}
