package dataStructure;

import java.util.LinkedList;

/**
 * 剑指 Offer II 041. 滑动窗口的平均值
 * <p>
 * https://leetcode.cn/problems/qIsx9U/
 */
class MovingAverage {

    private final int mSize;
    private int sum = 0;
    private final LinkedList<Integer> list = new LinkedList<>();

    public MovingAverage(int size) {
        mSize = size;
    }

    public double next(int val) {
        if (list.size() < mSize) {
            list.add(val);
            sum += val;
        } else {
            Integer first = list.removeFirst();
            sum -= first;
            sum += val;
            list.add(val);
        }
        return sum * 1.0 / list.size();
    }
}