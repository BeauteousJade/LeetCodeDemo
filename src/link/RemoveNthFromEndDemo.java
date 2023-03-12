package link;

import java.util.ArrayList;
import java.util.List;

/**
 * 19. 删除链表的倒数第 N 个结点
 * <p>
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
// TODO 重点
public class RemoveNthFromEndDemo {

    public static void main(String[] args) {
        RemoveNthFromEndDemo demo = new RemoveNthFromEndDemo();
        ListNode listNode = demo.buildListNode(new int[]{1});
        demo.listNodeToString(listNode);
        listNode = demo.removeNthFromEnd(listNode, 1);
        demo.listNodeToString(listNode);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode leftNode = preHead;
        ListNode rightNode = head;
        int count = 0;
        while (count != n) {
            rightNode = rightNode.next;
            count++;
        }

        while (rightNode != null) {
            rightNode = rightNode.next;
            leftNode = leftNode.next;
        }
        ListNode next = leftNode.next;
        leftNode.next = next.next;
        next.next = null;
        return preHead.next;
    }


    private int count = 0;
    private ListNode deleteNode;
    private ListNode preNode;

    public ListNode removeNthFromEndV2(ListNode head, int n) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        dfs(n, head);
        if (preNode == null) {
            preNode = preHead;
        }
        preNode.next = deleteNode.next;
        deleteNode.next = null;
        return preHead.next;
    }


    private void dfs(int n, ListNode head) {
        if (head == null) {
            return;
        }
        dfs(n, head.next);
        count++;
        if (n == count) {
            deleteNode = head;
        }
        if (n + 1 == count) {
            preNode = head;
        }
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
