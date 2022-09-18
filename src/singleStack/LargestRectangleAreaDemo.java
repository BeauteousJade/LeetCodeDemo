package singleStack;

import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * <p>
 * https://leetcode.cn/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleAreaDemo {

    public static void main(String[] args) {


    }

    /**
     * 单调栈，核心思想：以当前坐标为中心，往两边扩散，找到第一个小于当前值的元素。
     */
    public int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            // 单调递增。遇到小的，需要向前找到比它小的。
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            // 没有的话，左侧长度应该是当前的index + 1。所以left index是-1.
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = heights.length - 1; i >= 0; i--) {
            // 单调递增。遇到小的，需要向后找到比它小的。
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            // 没有的话，右侧长度应该是length - 当前的index.所以 right index是length.
            right[i] = stack.isEmpty() ? heights.length : stack.peek();
            stack.push(i);
        }
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }
        return res;
    }
}
