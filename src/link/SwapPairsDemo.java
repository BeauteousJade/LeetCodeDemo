package link;

import java.util.ArrayList;
import java.util.List;

/**
 * 24. 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class SwapPairsDemo {

    public static void main(String[] args) {

    }


    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode listNode = head;
        while (listNode != null) {
            list.add(listNode);
            listNode = listNode.next;
        }

        for (int i = 0; i + 1 < list.size(); i += 2) {
            ListNode temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        list.get(list.size() - 1).next = null;
        return list.get(0);
    }
}
