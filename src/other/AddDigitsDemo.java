package other;

/**
 * 258. 各位相加
 * <p>
 * https://leetcode-cn.com/problems/add-digits/
 */
public class AddDigitsDemo {

    public static void main(String[] args) {
        AddDigitsDemo demo = new AddDigitsDemo();
        System.out.println(demo.addDigits(0));
    }

    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int result = 0;
        while (num != 0) {
            result += num % 10;
            num /= 10;
        }
        return addDigits(result);
    }
}
