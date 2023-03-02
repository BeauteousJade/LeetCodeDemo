package other;

/**
 * 面试题 05.02. 二进制数转字符串
 * <p>
 * https://leetcode.cn/problems/bianry-number-to-string-lcci/
 */
public class PrintBinDemo {

    public static void main(String[] args) {

    }

    public String printBin(double num) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        while (count < 6) {
            double newNum = num * 2;
            if (newNum >= 1) {
                stringBuilder.append("1");
                num = newNum - 1;
            } else {
                stringBuilder.append(0);
                num = newNum;
            }
            if (count == 5 && num != 0) {
                return "ERROR";
            }
            count++;
        }
        int index = stringBuilder.length() - 1;
        while (index >= 0 && stringBuilder.charAt(index) == '0') {
            stringBuilder.delete(index, index + 1);
            index--;
        }
        if (stringBuilder.length() == 0) {
            return "ERROR";
        }
        stringBuilder.insert(0, "0.");
        return stringBuilder.toString();
    }
}
