package binarySearch;

/**
 * 69. x 的平方根
 * <p>
 * https://leetcode.cn/problems/sqrtx/
 */
public class MySqrtDemo {

    public static void main(String[] args) {

    }

    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }

    public int mySqrtV2(int x) {
        int left = 0;
        int right = x;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left * left == x ? left : left - 1;
    }
}
