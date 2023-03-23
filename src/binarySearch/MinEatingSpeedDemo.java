package binarySearch;

/**
 * 875. 爱吃香蕉的珂珂
 * <p>
 * https://leetcode.cn/problems/koko-eating-bananas/
 */
public class MinEatingSpeedDemo {

    public static void main(String[] args) {

    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while (left < right) {
            int speed = (right - left) / 2 + left;
            long time = getTime(piles, speed);
            if (time <= h) {
                right = speed;
            } else {
                left = speed + 1;
            }
        }
        return left;
    }

    public long getTime(int[] piles, int speed) {
        long time = 0;
        for (int pile : piles) {
            int curTime = (int) Math.ceil(pile * 1.0 / speed);
            time += curTime;
        }
        return time;
    }
}
