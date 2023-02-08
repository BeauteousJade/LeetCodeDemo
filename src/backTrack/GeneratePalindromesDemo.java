package backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 267. 回文排列 II
 * <p>
 * https://leetcode.cn/problems/palindrome-permutation-ii/?favorite=qg88wci
 */
public class GeneratePalindromesDemo {

    public static void main(String[] args) {
        GeneratePalindromesDemo demo = new GeneratePalindromesDemo();
        System.out.println(demo.generatePalindromes("aaaabb"));
    }

    public List<String> generatePalindromes(String s) {
        int[] array = help(s);
        List<String> res = new ArrayList<>();
        if (array == null) {
            return res;
        }
        int index = -1;
        for (int i = 0; i < 26; i++) {
            if (array[i] % 2 != 0) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            dfs(array, res, new StringBuilder(), s.length());
        } else {
            array[index]--;
            System.out.println(Arrays.toString(array));
            dfs(array, res, new StringBuilder(String.valueOf((char) (index + 'a'))), s.length());
        }
        return res;
    }


    private void dfs(int[] array, List<String> res, StringBuilder stringBuilder, int length) {
        if (length == stringBuilder.length()) {
            res.add(stringBuilder.toString());
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == 0) {
                    continue;
                }
                stringBuilder.append((char) (i + 'a'));
                stringBuilder.insert(0, (char) (i + 'a'));
                array[i] -= 2;
                dfs(array, res, stringBuilder, length);
                stringBuilder.delete(0, 1);
                stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
                array[i] += 2;
            }
        }
    }


    private int[] help(String s) {
        int[] array = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            array[chars[i] - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (array[i] % 2 != 0) {
                if (count > 0) {
                    return null;
                }
                count++;
            }
        }
        return array;
    }
}
