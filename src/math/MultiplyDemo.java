package math;

import java.util.ArrayList;
import java.util.List;

/**
 * 43. 字符串相乘
 * <p>
 * https://leetcode.cn/problems/multiply-strings/
 */
public class MultiplyDemo {

    public static void main(String[] args) {

    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        char[] array1 = num1.toCharArray();
        char[] array2 = num2.toCharArray();
        // 1. 先把num1分别与num2的每位相乘，得到对应的结果。存储到List中。
        List<String> list = new ArrayList<>();
        for (int i = array2.length - 1; i >= 0; i--) {
            int m = array2[i] - '0';
            int add = 0;
            StringBuilder res = new StringBuilder();
            // 最终结果，低位需要补0.
            for (int k = i; k < array2.length - 1; k++) {
                res.append(0);
            }
            for (int j = array1.length - 1; j >= 0; j--) {
                int n = array1[j] - '0';
                int total = m * n + add;
                add = total / 10;
                res.append(total % 10);
            }
            if (add != 0) {
                res.append(add);
            }
            list.add(res.reverse().toString());
        }
        int maxLength = list.get(list.size() - 1).length();
        int index = 0;
        StringBuilder res = new StringBuilder();
        int add = 0;
        // 2. 将所有的结果相加，得到最终结果。
        while (index < maxLength) {
            int total = add;
            for (String string : list) {
                int newIndex = string.length() - 1 - index;
                if (newIndex >= 0) {
                    total += string.charAt(newIndex) - '0';
                }
            }
            res.append(total % 10);
            add = total / 10;
            index++;
        }
        if (add != 0) {
            res.append(add);
        }
        return res.reverse().toString();
    }

}
