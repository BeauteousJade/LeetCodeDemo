/**
 * 字符串转换整数 (atoi)
 */
public class MyAtoiDemo {

    public static void main(String[] args) {
        MyAtoiDemo demo = new MyAtoiDemo();
        System.out.println(demo.myAtoi("-2147483647"));
    }

    public int myAtoi(String s) {
        String newString = s.trim();
        if (newString.length() == 0) {
            return 0;
        }
        char[] array = newString.toCharArray();
        if (array[0] != '-' && array[0] != '+' && (array[0] < '0' || array[0] > '9')) {
            return 0;
        }
        int value = 0;
        int end = newString.length() - 1;
        for (int i = 1; i < newString.length(); i++) {
            if (array[i] >= '0' && array[i] <= '9') {
                if (value > Integer.MAX_VALUE / 10) {
                    return array[0] == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                if (value * 10 > Integer.MAX_VALUE - (array[i] - '0')) {
                    return array[0] == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                value = value * 10 + array[i] - '0';
            } else {
                end = i - 1;
                break;
            }
        }
        if (end == 0) {
            return array[0] >= '0' && array[0] < '9' ? array[0] - '0' : 0;
        }
        if (array[0] == '-' || array[0] == '+') {
            return value * (array[0] == '-' ? -1 : 1);
        }
        int newValue = array[0] - '0';
        for (int i = 0; i < end; i++) {
            if (newValue > Integer.MAX_VALUE / 10) {
                return Integer.MAX_VALUE;
            }
            newValue = newValue * 10;
        }
        return newValue > Integer.MAX_VALUE - value ? Integer.MAX_VALUE : newValue + value;
    }
}
