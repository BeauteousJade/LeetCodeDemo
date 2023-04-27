package tree;

import link.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 109. 有序链表转换二叉搜索树
 * <p>
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p/>
 * <p>
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class SortedListToBSTDemo {

    public static void main(String[] args) {

    }


    public TreeNode sortedListToBST(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        return sortedListToBST(list, 0, list.size() - 1);
    }

    private TreeNode sortedListToBST(List<ListNode> list, int start, int end) {
        if (start < 0 || end >= list.size() || start > end) {
            return null;
        }
        TreeNode root = new TreeNode();
        root.val = list.get((start + end) / 2).val;
        root.left = sortedListToBST(list, start, (start + end) / 2 - 1);
        root.right = sortedListToBST(list, (start + end) / 2 + 1, end);
        return root;
    }


    public TreeNode sortedListToBSTV2(ListNode head) {
        return buildTree(head, null);
    }

    public TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
