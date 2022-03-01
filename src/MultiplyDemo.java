public class MultiplyDemo {

    public static void main(String[] args) {

    }

    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num1.equals("1")) {
            return num2;
        }
        if (num1.equals("0")) {
            return num2;
        }
        if (num2 == null || num2.length() == 0 || num2.equals("1")) {
            return "0";
        }
        if (num2.equals("0")) {
            return "0";
        }

        StringBuilder stringBuilder = new StringBuilder();
        char[] charArray1 = num1.toCharArray();
        char[] charArray2 = num2.toCharArray();
        int length = Math.min(charArray1.length - 1, charArray2.length - 1);
        int index = 0;
        int add = 0;
        while (index <= length) {
            int value1 = charArray1[charArray1.length - index] - '0';
            int value2 = charArray2[charArray2.length - index] - '0';
            int res = value1 * value2 + add;
            stringBuilder.insert(0, res % 10);
            add = res / 10;
            index++;
        }

        while (index <= charArray1.length - 1) {
            int value1 = charArray1[charArray1.length - index] - '0';

        }

        return "";
    }
}
