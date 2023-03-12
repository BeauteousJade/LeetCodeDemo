package twoPointer;

/**
 * 剑指 Offer II 019. 最多删除一个字符得到回文
 * <p>
 * https://leetcode.cn/problems/RQku0D/
 */
public class ValidPalindromeDemo {

    public static void main(String[] args) {

    }

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            char leftC = s.charAt(left);
            char rightC = s.charAt(right);
            if (leftC == rightC) {
                left++;
                right--;
            } else {
                // 分别尝试删除左边和右边，用来验证剩下的字符是否能够构成回文串。
                return validPalindrome(s, left, right - 1) || validPalindrome(s, left + 1, right);
            }
        }
        return true;
    }

    private boolean validPalindrome(String string, int low, int high) {
        while (low <= high) {
            if (string.charAt(low) != string.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }

        return true;
    }
}
