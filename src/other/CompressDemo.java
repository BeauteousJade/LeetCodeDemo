package other;

import java.util.Arrays;

/**
 * 443. 压缩字符串
 * <p>
 * https://leetcode-cn.com/problems/string-compression/
 */
public class CompressDemo {

    public static void main(String[] args) {
        CompressDemo demo = new CompressDemo();
        char[] array = new char[]{'a', 'a', 'a'};
        System.out.println(demo.compress(array));
        System.out.println(Arrays.toString(array));
    }

    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0;
        int read = 0;
        int left = 0;
        for (read = 0; read < n; read++) {
            if (read == n - 1 || chars[read + 1] != chars[read]) {
                chars[write++] = chars[read];
                int num = read - left + 1;
                if (num > 1) {
                    char[] charArray = String.valueOf(num).toCharArray();
                    for (char c : charArray) {
                        chars[write++] = c;
                    }
                }
                left = read + 1;
            }
        }

        return write;
    }
}
