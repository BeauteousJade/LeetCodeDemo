package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 266. 回文排列
 * <p>
 * https://leetcode.cn/problems/palindrome-permutation/
 */
// TOOD 下次
public class CanPermutePalindromeDemo {

    public static void main(String[] args) {
        CanPermutePalindromeDemo demo = new CanPermutePalindromeDemo();
        System.out.println(demo.canPermutePalindrome("abc"));
    }

    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }
        int count = 0;
        for (Character key : map.keySet()) {
            if (map.get(key) % 2 != 0) {
                if (count > 0) {
                    return false;
                }
                count++;
            }
        }
        return true;
    }
}
