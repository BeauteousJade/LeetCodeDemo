package link;

import link.ListNode;

/**
 * 142. 环形链表 II
 */
public class DetectCycleDemo {

    public static void main(String[] args) {

    }

    /**
     * 假设从起点到入口：a
     * 入口到相遇点：b
     * 相遇点到入口：c
     * 快指针走了n 步相遇：n = a + x (b + c)  在环里面转了x圈
     * a + x(b + c) = 2(a + b)
     * a = c + (x - 1)(b + c)
     * 也就是说，当他们相遇，此来再来一个指针从起点开始，肯定会在入口相遇。
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            slow = slow.next;
            if (slow == fast) {
                ListNode node = head;
                while (node != slow) {
                    node = node.next;
                    slow = slow.next;
                }
                return node;
            }
        }
        return null;
    }
}
