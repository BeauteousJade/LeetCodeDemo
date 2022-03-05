package other;

/**
 * 7. 整数反转
 * <p>
 * https://leetcode-cn.com/problems/reverse-integer/
 */
public class ReverseDemo {

    public static void main(String[] args) {
        ReverseDemo demo = new ReverseDemo();
        System.out.println(demo.reverse(-123));
    }


    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        int value = 0;
        while (x != 0) {
            if (Math.abs(value) > Integer.MAX_VALUE / 10 || Math.abs(value) * 10 > Integer.MAX_VALUE - Math.abs(x % 10)) {
                return 0;
            }
            value = value * 10 + x % 10;
            x = x / 10;
        }
        return value;
    }
}
