package twoPointer;

import java.util.HashMap;
import java.util.Map;

/**
 * 246. 中心对称数
 * <p>
 * https://leetcode.cn/problems/strobogrammatic-number/
 */
public class IsStrobogrammaticDemo {

    public static void main(String[] args) {
        IsStrobogrammaticDemo demo = new IsStrobogrammaticDemo();
        System.out.println(demo.isStrobogrammatic("619"));
    }

    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');

        char[] charArray = num.toCharArray();
        int left = 0;
        int right = num.length() - 1;
        while (left < right && map.containsKey(charArray[left]) && charArray[right] == map.get(charArray[left])) {
            left++;
            right--;
        }
        if (left == right) {
            return map.containsKey(charArray[left]) && charArray[right] == map.get(charArray[left]);
        }
        return left > right;
    }
}
