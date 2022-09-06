package twoPointer;

/**
 * 回文数
 */
// TODO 下次
public class IsPalindromeDemo {

    public static void main(String[] args) {
        IsPalindromeDemo demo = new IsPalindromeDemo();
        System.out.println(demo.isPalindrome(13));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        char[] chars = String.valueOf(x).toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
