package math;

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
        String ans = "";
        for (int i = array2.length - 1; i >= 0; i--) {
            int m = array2[i] - '0';
            int add = 0;
            StringBuilder res = new StringBuilder();
            // 1. 先一位一位的乘，得到结果。
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
            // 2. 再跟之前的结果相加。
            ans = add(ans, res.reverse().toString());
        }
        return ans;
    }

    private String add(String num1, String num2) {
        StringBuilder stringBuilder = new StringBuilder();
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int add = 0;
        while (index1 >= 0 || index2 >= 0) {
            int m = index1 >= 0 ? num1.charAt(index1) - '0' : 0;
            int n = index2 >= 0 ? num2.charAt(index2) - '0' : 0;
            int total = m + n + add;
            stringBuilder.append(total % 10);
            add = total / 10;
            index2--;
            index1--;
        }
        if (add != 0) {
            stringBuilder.append(add);
        }
        return stringBuilder.reverse().toString();
    }

}
