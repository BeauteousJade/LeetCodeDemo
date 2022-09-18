package singleStack;

import java.util.Stack;

/**
 * 85. 最大矩形
 * <p>
 * https://leetcode.cn/problems/maximal-rectangle/
 *
 * @see LargestRectangleAreaDemo
 */
public class MaximalRectangleDemo {

    public static void main(String[] args) {
        MaximalRectangleDemo demo = new MaximalRectangleDemo();
        char[][] c = {{'1'}};
        System.out.println(demo.maximalRectangle(c));
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] height = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height[i].length; j++) {
                if (matrix[i][j] == '1') {
                    // 计算每一行的高度。
                    height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int[] rowHeight = height[i];
            // 复用柱状图的计算。计算每一行的最大面积。
            res = Math.max(res, largestRectangleArea(rowHeight));
        }

        return res;
    }

    /**
     * 单调栈，核心思想：以当前坐标为中心，往两边扩散，找到第一个小于当前值的元素。
     */
    public int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            // 没有的话，左侧长度应该是当前的index + 1。所以left index是-1.
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = heights.length - 1; i >= 0; i--) {
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
