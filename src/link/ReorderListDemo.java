package link;

/**
 * 143. 重排链表
 * <p>
 * https://leetcode.cn/problems/reorder-list/
 */
public class ReorderListDemo {

    public static void main(String[] args) {

    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        // 1. 先找到中间节点。
        ListNode middleNode = findMiddleNode(head);
        ListNode l1 = head;
        ListNode l2 = middleNode.next;
        middleNode.next = null;
        // 2. 将右侧部分的节点给反转了，记住上面将middle.next设置为空了，不然会形成环。
        l2 = reverseListNode(l2);
        // 3. 合并。
        mergeListNode(l1, l2);
    }


    private ListNode findMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseListNode(ListNode head) {
        ListNode preNode = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = preNode;
            preNode = head;
            head = next;
        }
        return preNode;
    }

    private void mergeListNode(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(0);
        ListNode node = preHead;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                node.next = l1;
                l1 = l1.next;
                node = node.next;
            }
            if (l2 != null) {
                node.next = l2;
                l2 = l2.next;
                node = node.next;
            }
        }
        preHead.next = null;
    }
}
