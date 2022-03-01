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
        ListNode head = new ListNode(0);
        ListNode temp = head;
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return head.next;
    }
}
