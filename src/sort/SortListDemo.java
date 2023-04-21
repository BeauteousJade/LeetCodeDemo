package sort;

import link.ListNode;

/**
 * 148. 排序链表
 * <p>
 * https://leetcode-cn.com/problems/sort-list/
 */
public class SortListDemo {

    public static void main(String[] args) {

    }

    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    /**
     * 类似归并排序
     **/
    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode listNode1 = sortList(head, mid);
        ListNode listNode2 = sortList(mid, tail);
        return merge(listNode1, listNode2);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode preHead = new ListNode(0);
        ListNode currentNode = preHead;
        while (head1 != null || head2 != null) {
            if (head2 == null || head1 != null && head1.val <= head2.val) {
                currentNode.next = head1;
                head1 = head1.next;
            } else {
                currentNode.next = head2;
                head2 = head2.next;
            }
            currentNode = currentNode.next;
        }
        return preHead.next;
    }
}
