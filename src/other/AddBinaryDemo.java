package other;

/**
 * 剑指 Offer II 002. 二进制加法
 * <p>
 * https://leetcode.cn/problems/JFETK5/?favorite=e8X3pBZi
 */
public class AddBinaryDemo {

    public static void main(String[] args) {
        AddBinaryDemo demo = new AddBinaryDemo();
        System.out.println(demo.addBinary("11", "10"));
    }

    public String addBinary(String a, String b) {
        int index1 = a.length() - 1;
        int index2 = b.length() - 1;
        int add = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (index1 >= 0 || index2 >= 0) {
            int num1 = index1 >= 0 ? a.charAt(index1--) - '0' : 0;
            int num2 = index2 >= 0 ? b.charAt(index2--) - '0' : 0;
            int sum = add + num1 + num2;
            stringBuilder.append(sum % 2);
            add = sum / 2;
        }
        if (add != 0) {
            stringBuilder.append(add);
        }
        return stringBuilder.reverse().toString();
    }
}
