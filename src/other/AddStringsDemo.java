package other;

/**
 * 415. 字符串相加
 * <p>
 * https://leetcode-cn.com/problems/add-strings/
 */
public class AddStringsDemo {


    public static void main(String[] args) {
        AddStringsDemo demo = new AddStringsDemo();
        System.out.println(demo.addStrings("163", "1239"));
    }

    public String addStrings(String num1, String num2) {
        int add = 0;
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        StringBuilder stringBuilder = new StringBuilder();
        while (index1 >= 0 || index2 >= 0) {
            int a = index1 >= 0 ? num1.charAt(index1--) - '0' : 0;
            int b = index2 >= 0 ? num2.charAt(index2--) - '0' : 0;
            int res = a + b + add;
            stringBuilder.append(res % 10);
            add = res / 10;
        }
        if (add != 0) {
            stringBuilder.append(add);
        }
        return stringBuilder.reverse().toString();
    }
}
