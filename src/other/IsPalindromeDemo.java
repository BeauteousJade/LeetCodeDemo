package other;

/**
 * 125. 验证回文串
 * <p>
 * https://leetcode-cn.com/problems/valid-palindrome/
 */
public class IsPalindromeDemo {

    public static void main(String[] args) {
        IsPalindromeDemo demo = new IsPalindromeDemo();
        System.out.println(demo.isPalindrome("    "));
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] charArray = s.toLowerCase().toCharArray();
        while (left < right) {
            char leftChar = charArray[left];
            char rightChar = charArray[right];
            if (isIllegalChar(leftChar) && isIllegalChar(rightChar)) {
                if (leftChar == rightChar) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            } else {
                if (!isIllegalChar(leftChar)) {
                    left++;
                } else if (!isIllegalChar(rightChar)) {
                    right--;
                }
            }
        }
        return true;
    }

    private boolean isIllegalChar(char c) {
        return c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' || c >= '0' && c <= '9';
    }
}
