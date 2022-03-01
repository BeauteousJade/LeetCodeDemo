package link;

import java.util.ArrayList;
import java.util.List;

/**
 * 21. 合并两个有序链表
 * <p>
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoListsDemo {

    public static void main(String[] args) {
        MergeTwoListsDemo demo = new MergeTwoListsDemo();
        ListNode listNode1 = demo.buildListNode(new int[]{});
        ListNode listNode2 = demo.buildListNode(new int[]{1, 3, 4, 6});
        demo.listNodeToString(demo.mergeTwoLists(listNode1, listNode2));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode listNode = null;
        ListNode preListNode = null;
        ListNode header = null;
        while (list1 != null && list2 != null) {
            System.out.println(1);
            if (list1.val <= list2.val) {
                listNode = list1;
                list1 = list1.next;
            } else {
                listNode = list2;
                list2 = list2.next;
            }
            listNode.next = null;
            if (preListNode != null) {
                preListNode.next = listNode;
            }
            preListNode = listNode;
            if (header == null) {
                header = listNode;
            }
        }

        while (list1 != null) {
            listNode = list1;
            preListNode.next = listNode;
            preListNode = preListNode.next;
            list1 = list1.next;
            listNode.next = null;
        }

        while (list2 != null) {
            listNode = list2;
            preListNode.next = listNode;
            preListNode = preListNode.next;
            list2 = list2.next;
            listNode.next = null;
        }

        return header;
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
