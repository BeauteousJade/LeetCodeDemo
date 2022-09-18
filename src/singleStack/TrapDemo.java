package singleStack;

import java.util.Stack;

/**
 * 42. 接雨水
 * <p>
 * https://leetcode.cn/problems/trapping-rain-water/
 */
// TODO 重点。
public class TrapDemo {

    public static void main(String[] args) {

    }


    public int trap(int[] height) {

        int res = 0;
        Stack<Integer> queue = new Stack<>();

        for (int i = 0; i < height.length; i++) {

            // 单调递减，遇到大的，需要计算。
            while (!queue.isEmpty() && height[i] > height[queue.peek()]) {
                int top = queue.pop();
                if (queue.isEmpty()) {
                    break;
                }
                int left = queue.peek();
                int width = i - left - 1;
                // height[i] 可能会小于height[left], 所以需要取最小。
                // Math.min(height[left], height[i]) 是定边，height[top]是底边。
                int useHeight = Math.min(height[left], height[i]) - height[top];
                res += width * useHeight;
            }

            queue.push(i);
        }

        return res;
    }

}
