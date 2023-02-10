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
        ListNode lastKNode = null;
        // 当前节点，用来遍历。
        ListNode currentNode = head;
        // 当前节点的上一个节点。
        ListNode preNode = null;
        // 新的头节点。
        ListNode newHead = null;
        while (currentNode != null) {
            ListNode next = currentNode.next;
            // 如果当前节点小于K，那么需要移动当前节点。
            if (currentNode.val < k) {
                // 如果lastKNode不为空，那么就直接将currentNode放在lastKNode的后面。
                if (lastKNode != null) {
                    ListNode nextNode = lastKNode.next;
                    lastKNode.next = currentNode;
                    currentNode.next = nextNode;
                    lastKNode = lastKNode.next;
                } else {
                    // 如果lastKNode为空，需要更新lastKNode节点

                    // 如果head == currentNode,表示是第一个节点，直接赋值
                    if (currentNode == head) {
                        lastKNode = currentNode;
                    } else {
                        // 如果不是，那么就将currentNode赋值给lastKNode，且将lastKNode节点插入到第一个。
                        currentNode.next = head;
                        lastKNode = currentNode;
                        newHead = currentNode;
                    }
                }
                // 删除原来的newHead节点。
                if (preNode != null) {
                    preNode.next = next;
                }
            } else {
                // 小于K的时候，因为移动了currentNode,所以preNode没有变，不需要更新。
                // 所以只在大于K，才更新preNode.
                preNode = currentNode;
            }
            currentNode = next;
        }
        return newHead == null ? head : newHead;
    }
}
