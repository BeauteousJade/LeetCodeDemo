package link;

/**
 * 2. 两数相加
 * <p>
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class AddTwoNumbersDemo {
    public static void main(String[] args) {

        AddTwoNumbersDemo demo = new AddTwoNumbersDemo();
        ListNode l1 = LinkUtils.buildListNode(new int[]{3, 9, 9, 9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = LinkUtils.buildListNode(new int[]{7});
        ListNode listNode = demo.addTwoNumbers(l1, l2);
        LinkUtils.listNodeToString(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode header = new ListNode(0);
        ListNode newNode = header;
        int add = 0;
        while (l1 != null || l2 != null) {
            int value = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + add;
            newNode.next = new ListNode(value % 10);
            add = value / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            newNode = newNode.next;
        }
        if (add != 0) {
            newNode.next  = new ListNode(add);
        }
        return header.next;
    }

}
