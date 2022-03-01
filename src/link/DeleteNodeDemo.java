package link;

/**
 * 237. 删除链表中的节点
 * <p>
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
public class DeleteNodeDemo {

    public static void main(String[] args) {

    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
