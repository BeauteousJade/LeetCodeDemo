package link;

/**
 * 剑指 Offer II 028. 展平多级双向链表
 * <p>
 * https://leetcode.cn/problems/Qv1Da2/?favorite=e8X3pBZi
 */
public class FlattenDemo {

    public static void main(String[] args) {

    }

    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    private Node preNode;

    /**
     * 类似于树的中序遍历，优先遍历root，然后遍历child，最后遍历next.
     */
    private void dfs(Node head) {
        if (head == null) {
            return;
        }
        // 需要将当前next给记录下来，因为下面的递归可能污染它。
        Node next = head.next;
        if (preNode != null) {
            preNode.next = head;
        }
        head.prev = preNode;
        preNode = head;
        dfs(head.child);
        // 这里要将child设置为空空。
        head.child = null;
        dfs(next);
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
