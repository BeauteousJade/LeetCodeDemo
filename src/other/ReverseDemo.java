package other;

/**
 * 7. 整数反转
 * <p>
 * https://leetcode-cn.com/problems/reverse-integer/
 */
public class ReverseDemo {

    public static void main(String[] args) {
        ReverseDemo demo = new ReverseDemo();
        System.out.println(demo.reverse(1534236469));
    }


    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        long value = 0;
        while (x != 0) {
            if (Math.abs(value) > (Integer.MAX_VALUE - Math.abs(x % 10)) / 10) {
                return 0;
            }
            value = value * 10 + x % 10;
            x = x / 10;
        }
        return (int) value;
    }

    public int reverseV2(int x) {
        if (x == 0) {
            return 0;
        }
        String prefix = x < 0 ? "-" : "";
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(Math.abs(x)));
        stringBuilder.reverse();
        int startIndex = 0;
        while (stringBuilder.charAt(startIndex) == 0) {
            startIndex++;
        }
        stringBuilder.delete(0, startIndex);
        stringBuilder.insert(0, prefix);
        try {
            return Integer.parseInt(stringBuilder.toString());
        } catch (Exception e) {
            return 0;
        }
    }

}
