package link;

/**
 * 141. 环形链表
 * <p>
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class HasCycleDemo {

    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
