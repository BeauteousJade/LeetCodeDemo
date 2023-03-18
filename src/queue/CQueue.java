package queue;

import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * <p>
 * https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */
public class CQueue {


    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        // 只有2为空了，才把1的push 到2中。
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty() ? -1 : stack2.pop();
    }
}
