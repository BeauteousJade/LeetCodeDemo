package link;

import java.util.Stack;

/**
 * 445. 两数相加 II
 * <p>
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 */
public class AddTwoNumbersDemoV2 {

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        Stack<Integer> stack2 = new Stack<>();
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int add = 0;
        ListNode nextNode = null;
        ListNode resNode = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int value = (stack1.isEmpty() ? 0 : stack1.pop()) + (stack2.isEmpty() ? 0 : stack2.pop()) + add;
            resNode = new ListNode(value % 10);
            resNode.next = nextNode;
            nextNode = resNode;
            add = value / 10;
        }
        if (add != 0) {
            resNode = new ListNode(add % 10);
            resNode.next = nextNode;
        }
        return resNode;
    }
}
