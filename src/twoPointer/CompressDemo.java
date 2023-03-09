package twoPointer;

import java.util.Arrays;

/**
 * 443. 压缩字符串
 * <p>
 * https://leetcode-cn.com/problems/string-compression/
 */
// TODO 重点
public class CompressDemo {

    public static void main(String[] args) {
        CompressDemo demo = new CompressDemo();
        char[] array = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(demo.compress(array));
        System.out.println(Arrays.toString(array));
    }

    public int compress(char[] chars) {
        int n = chars.length;
        int slowIndex = 0;
        int fastIndex = 0;
        int left = 0;
        while (fastIndex < n) {
            if (fastIndex == n - 1 || chars[fastIndex + 1] != chars[fastIndex]) {
                chars[slowIndex++] = chars[fastIndex];
                int num = fastIndex - left + 1;
                if (num > 1) {
                    char[] charArray = String.valueOf(num).toCharArray();
                    for (char c : charArray) {
                        chars[slowIndex++] = c;
                    }
                }
                left = fastIndex + 1;
            }
            fastIndex++;
        }
        return slowIndex;
    }

}
