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
        // 1. 找到最后一个不是9的节点。
        while (head != null) {
            if (head.val != 9) {
                notNine = head;
            }
            head = head.next;
        }
        notNine.val++;
        notNine = notNine.next;
        // 2. 把最后一个不是9节点后面的节点都设置为0.
        while (notNine != null) {
            notNine.val = 0;
            notNine = notNine.next;
        }
        // 3. 判断最后一个非9节点是否第一个节点，如果是，则需要进位。
        return preHead.val == 0 ? preHead.next : preHead;
    }
}
