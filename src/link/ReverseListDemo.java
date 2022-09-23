package link;

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
// TODO 重点
public class ReverseListDemo {

    public static void main(String[] args) {

        ReverseListDemo demo = new ReverseListDemo();
        int[] array = new int[]{1, 2, 3, 4};
        ListNode listNode = LinkUtils.buildListNode(array);
        LinkUtils.listNodeToString(listNode);
        System.out.println();
        LinkUtils.listNodeToString(demo.reverseList(listNode));
    }

    public ListNode reverseList(ListNode head) {
        ListNode listNode = head;
        ListNode preNode = null;
        while (listNode != null) {
            ListNode nextNode = listNode.next;
            listNode.next = preNode;
            preNode = listNode;
            listNode = nextNode;
        }
        return preNode;
    }
}
