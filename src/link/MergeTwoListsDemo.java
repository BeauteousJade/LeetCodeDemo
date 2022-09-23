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
        ListNode listNode1 = LinkUtils.buildListNode(new int[]{});
        ListNode listNode2 = LinkUtils.buildListNode(new int[]{1, 3, 4, 6});
        LinkUtils.listNodeToString(demo.mergeTwoLists(listNode1, listNode2));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode header = new ListNode(0);
        ListNode newNode = header;
        while (list1 != null || list2 != null) {
            if (list2 == null || (list1 != null && list1.val < list2.val)) {
                newNode.next = list1;
                list1 = list1.next;
            } else {
                newNode.next = list2;
                list2 = list2.next;
            }
            newNode = newNode.next;
        }
        return header.next;
    }

}
