package link;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * <p>
 * https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class GetKthFromEndDemo {

    public static void main(String[] args) {

    }

    private ListNode res;
    private int count = 0;

    public ListNode getKthFromEnd(ListNode head, int k) {
        dfs(head, k);
        return res;
    }

    private void dfs(ListNode head, int k) {
        if (head == null) {
            return;
        }
        dfs(head.next, k);
        count++;
        if (count == k) {
            res = head;
        }
    }


    public ListNode getKthFromEndV2(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        while (count < k) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            count++;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
