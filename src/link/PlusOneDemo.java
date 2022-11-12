package link;

/**
 * 369. 给单链表加一
 * <p>
 * https://leetcode.cn/problems/plus-one-linked-list/
 */
public class PlusOneDemo {

    public static void main(String[] args) {

    }

    public ListNode plusOne(ListNode head) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode notNine = preHead;
        while (head != null) {
            if (head.val != 9) {
                notNine = head;
            }
            head = head.next;
        }
        notNine.val++;
        notNine = notNine.next;
        while (notNine != null) {
            notNine.val = 0;
            notNine = notNine.next;
        }
        return notNine.val == 0 ? notNine.next : notNine;
    }
}
