package link;

import java.util.ArrayList;
import java.util.List;

/**
 * 2. 两数相加
 * <p>
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class AddTwoNumbersDemo {
    public static void main(String[] args) {

        AddTwoNumbersDemo demo = new AddTwoNumbersDemo();
        ListNode l1 = demo.buildListNode(new int[]{3, 9, 9, 9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = demo.buildListNode(new int[]{7});
        ListNode listNode = demo.addTwoNumbers(l1, l2);
        demo.listNodeToString(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int value = 0;
        ListNode header = new ListNode((l1.val + l2.val) % 10);
        int add = (l1.val + l2.val) / 10;
        ListNode listNode = header;

        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null && l2 != null) {
            value = (l1.val + l2.val + add) % 10;
            listNode.next = new ListNode(value);
            listNode = listNode.next;
            add = (l1.val + l2.val + add) / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            value = (add + l1.val) % 10;
            listNode.next = new ListNode(value);
            listNode = listNode.next;
            add = (add + l1.val) / 10;
            l1 = l1.next;
        }
        while (l2 != null) {
            value = (add + l2.val) % 10;
            listNode.next = new ListNode(value);
            listNode = listNode.next;
            add = (add + l2.val) / 10;
            l2 = l2.next;
        }
        if (add != 0) {
            listNode.next = new ListNode(add);
        }

        return header;
    }

    private int listToInt(ListNode listNode) {
        int value = 0;
        ListNode newListNode = listNode;
        while (newListNode != null) {
            value = value * 10 + newListNode.val;
            newListNode = newListNode.next;
        }
        return value;
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
