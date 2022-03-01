package link;

import java.util.ArrayList;
import java.util.List;

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseListDemo {

    public static void main(String[] args) {

        ReverseListDemo demo = new ReverseListDemo();
        int[] array = new int[]{1, 2, 3, 4};
        ListNode listNode = demo.buildListNode(array);
        demo.listNodeToString(listNode);
        System.out.println();
        demo.listNodeToString(demo.reverseList(listNode));
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


    private void listNodeToString(ListNode listNode) {
        List<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        System.out.println(list);
    }

    private ListNode buildListNode(int[] array) {
        ListNode header = new ListNode(array[0]);
        ListNode listNode = header;
        for (int i = 1; i < array.length; i++) {
            listNode.next = new ListNode(array[i]);
            listNode = listNode.next;
        }
        return header;
    }
}
