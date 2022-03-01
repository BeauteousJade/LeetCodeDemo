package singleStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 739. 每日温度
 * https://leetcode-cn.com/problems/daily-temperatures/
 * <p>
 * 单调栈
 */
public class DailyTemperaturesDemo {

    public static void main(String[] args) {
        DailyTemperaturesDemo demo = new DailyTemperaturesDemo();
        int[] array = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(demo.dailyTemperatures(array)));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            // 栈里面是单调递减的。
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                result[preIndex] = i - preIndex;

            }
            stack.push(i);
        }
        return result;
    }
}
