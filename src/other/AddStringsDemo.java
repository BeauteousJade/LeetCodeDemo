package other;

public class AddStringsDemo {


    public static void main(String[] args) {
        AddStringsDemo demo = new AddStringsDemo();
        System.out.println(demo.addStrings("163", "1239"));
    }

    public String addStrings(String num1, String num2) {

        int length = Math.min(num1.length() - 1, num2.length() - 1);
        int index = 0;
        int add = 0;

        StringBuilder stringBuilder = new StringBuilder();
        while (index <= length) {
            int value = num1.charAt(num1.length() - index - 1) - '0' + num2.charAt(num2.length() - index - 1) - '0' + add;
            stringBuilder.insert(0, value % 10);
            add = value / 10;
            index++;
        }

        while (index < num1.length()) {
            int value = num1.charAt(num1.length() - index - 1) - '0' + add;
            stringBuilder.insert(0, value % 10);
            add = value / 10;
            index++;
        }

        while (index < num2.length()) {
            int value = num2.charAt(num2.length() - index - 1) - '0' + add;
            stringBuilder.insert(0, value % 10);
            add = value / 10;
            index++;
        }

        if (add != 0) {
            stringBuilder.insert(0, add);
        }

        return stringBuilder.toString();
    }
}
