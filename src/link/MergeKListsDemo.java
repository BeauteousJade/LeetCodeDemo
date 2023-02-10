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

}
