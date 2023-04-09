package link;

/**
 * 23. 合并K个升序链表
 * <p>
 * https://leetcode.cn/problems/merge-k-sorted-lists/?favorite=2cktkvj
 */
public class MergeKListsDemo {

    public static void main(String[] args) {
        MergeKListsDemo demo = new MergeKListsDemo();
        ListNode[] lists = new ListNode[3];
        lists[0] = LinkUtils.buildListNode(new int[]{1, 4, 5});
        lists[1] = LinkUtils.buildListNode(new int[]{1, 3, 4});
        lists[2] = LinkUtils.buildListNode(new int[]{2, 6});

        ListNode listNode = demo.mergeKLists(lists);
        LinkUtils.listNodeToString(listNode);
    }


    /**
     * 顺序合并
     */
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode listNode = new ListNode(0);
        ListNode head = listNode;

        boolean isEnd = false;

        while (!isEnd) {
            int index = 0;
            ListNode midNode = null;
            for (int i = 0; i < lists.length; i++) {
                if (midNode == null || (lists[i] != null && lists[i].val < midNode.val)) {
                    midNode = lists[i];
                    index = i;
                }
            }
            listNode.next = midNode;
            listNode = listNode.next;
            if (midNode != null) {
                lists[index] = midNode.next;
            }
            isEnd = midNode == null;
        }
        return head.next;
    }


    /**
     * 归并的方式。
     *
     */
    public ListNode mergeKListsV2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeLists(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = (start + end) / 2;
        ListNode listNode = mergeLists(lists, start, mid);
        ListNode listNode1 = mergeLists(lists, mid + 1, end);
        return mergeListNode(listNode, listNode1);

    }


    private ListNode mergeListNode(ListNode head1, ListNode head2) {
        ListNode preHead = new ListNode(0);
        ListNode currentNode = preHead;
        while (head1 != null || head2 != null) {
            if (head2 == null || head1 != null && head1.val <= head2.val) {
                currentNode.next = head1;
                head1 = head1.next;
            } else {
                currentNode.next = head2;
                head2 = head2.next;
            }
            currentNode = currentNode.next;
        }
        return preHead.next;
    }

}
