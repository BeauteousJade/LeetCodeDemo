package link;

/**
 * 移动小于K的节点。
 * <p>
 * 给定一个链表和一个k值，将链表中小于k的节点，移动到链表的左侧，要求:
 * 1. 时间复杂度是O(n)，空间复杂都是O(1)。
 * 2. 移动之后，节点之间的相对位置不能变。
 * <p>
 * 假设链表：2-5-7-4-1，k为3，移动之后：2-1-5-7-4
 */
public class MoveKDemo {

    public static void main(String[] args) {

    }

    private ListNode test(ListNode head, int k) {
        // 记录当前小于K左侧的最后一个节点。
        ListNode node = null;
        // 当前节点，用来遍历。
        ListNode newHead = head;
        // 当前节点的上一个节点。
        ListNode preHead = null;
        // 新的头节点。
        ListNode listNode = null;
        while (newHead != null) {
            ListNode next = newHead.next;
            // 如果当前节点小于K，那么需要移动当前节点。
            if (newHead.val < k) {
                // 如果node不为空，那么就直接将newHead放在node的后面。
                if (node != null) {
                    ListNode nextNode = node.next;
                    node.next = newHead;
                    newHead.next = nextNode;
                } else {
                    // 如果node为空，需要更新node节点

                    // 如果head == newHead,表示是第一个节点，直接赋值
                    if (newHead == head) {
                        node = newHead;
                    } else {
                        // 如果不是，那么就将newHead赋值给node，且将node节点插入到第一个。
                        newHead.next = head;
                        node = newHead;
                        listNode = newHead;
                    }
                }
                // 删除原来的newHead节点。
                if (preHead != null) {
                    preHead.next = next;
                }
            } else {
                // 小于K的时候，因为移动了newHead,所以preHead没有变，不需要更新。
                preHead = newHead;
            }
            newHead = next;
        }
        return listNode == null ? head : listNode;
    }
}
