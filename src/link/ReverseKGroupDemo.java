package link;

/**
 * 25. K 个一组翻转链表
 * <p>
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/
 */
public class ReverseKGroupDemo {

    public static void main(String[] args) {

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode pre = preHead;
        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return preHead.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] listNodes = reverse(head, tail);
            head = listNodes[0];
            tail = listNodes[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = next;
            pre = tail;
            head = tail.next;
        }
        return preHead.next;

    }

    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode p = head;
        while (pre != tail) {
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return new ListNode[]{tail, head};
    }
}
