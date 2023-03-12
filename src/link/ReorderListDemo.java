package link;

/**
 * 143. 重排链表
 * <p>
 * https://leetcode.cn/problems/reorder-list/
 */
public class ReorderListDemo {

    public static void main(String[] args) {

    }

    private ListNode firstNode;

    public boolean isPalindrome(ListNode head) {
        firstNode = head;
        return dfs(head);
    }

    private boolean dfs(ListNode head) {
        if (head == null) {
            return true;
        }
        if (!dfs(head.next)) {
            return false;
        }
        if (firstNode.val != head.val) {
            return false;
        }
        firstNode = firstNode.next;
        return true;
    }
}
