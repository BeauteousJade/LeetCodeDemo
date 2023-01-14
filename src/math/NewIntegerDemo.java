package math;

/**
 * 660. 移除 9
 * <p>
 * https://leetcode.cn/problems/remove-9/?favorite=qg88wci
 */
public class NewIntegerDemo {

    public static void main(String[] args) {

    }

    public int newInteger(int n) {
        // 移除9的话，表示所有数字由9进制来代替，所以去掉9的数字中第n个，就是9进制的第n个。
        return Integer.parseInt(Integer.toString(n, 9));
    }
}
