package twoPointer;

/**
 * 1790. 仅执行一次字符串交换能否使两个字符串相等
 * <p>
 * https://leetcode.cn/problems/check-if-one-string-swap-can-make-strings-equal/
 */
public class AreAlmostEqualDemo {


    public static void main(String[] args) {
        AreAlmostEqualDemo demo = new AreAlmostEqualDemo();
        System.out.println(demo.areAlmostEqual("attack", "defend"));
    }

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s2.equals(s1)) {
            return true;
        }
        int firstIndex = -1;
        int secondIndex = -1;
        int currentIndex = 0;
        int count = 0;

        while (currentIndex < s1.length()) {
            if (s1.charAt(currentIndex) != s2.charAt(currentIndex)) {
                count++;
                if (count == 1) {
                    firstIndex = currentIndex;
                } else {
                    secondIndex = currentIndex;
                }
            }
            currentIndex++;
        }

        if (count != 2) {
            return false;
        }
        return s1.charAt(firstIndex) == s2.charAt(secondIndex) && s1.charAt(secondIndex) == s2.charAt(firstIndex);
    }
}
