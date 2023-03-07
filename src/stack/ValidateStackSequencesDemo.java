package stack;

import java.util.Stack;

/**
 * 剑指 Offer 31. 栈的压入、弹出序列
 * <p>
 * https://leetcode.cn/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 */
public class ValidateStackSequencesDemo {

    public static void main(String[] args) {

    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        int pushIndex = 0;
        while (popIndex < popped.length || pushIndex < pushed.length) {
            // 如果当前栈顶等于popped当前元素，那么就是表示可以弹出。
            if (popIndex < popped.length && !stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            } else if (pushIndex < pushed.length) {
                // 如果不等于，那么尝试push新的元素
                stack.push(pushed[pushIndex++]);
            } else {
                // 其他 就return false。
                return false;
            }
        }
        return stack.isEmpty();
    }
}
