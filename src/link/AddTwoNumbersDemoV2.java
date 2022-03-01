package link;

import java.math.BigDecimal;

/**
 * 445. 两数相加 II
 * <p>
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 */
public class AddTwoNumbersDemoV2 {

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder value1 = new StringBuilder();
        StringBuilder value2 = new StringBuilder();
        while (l1 != null) {
            value1.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            value2.append(l2.val);
            l2 = l2.next;
        }
        BigDecimal bigDecimal = new BigDecimal(value1.toString());
        char[] charArray = bigDecimal.add(new BigDecimal(value2.toString())).toString().toCharArray();
        ListNode listNode = new ListNode(charArray[0] - '0');
        ListNode header = listNode;
        for (int i = 1; i < charArray.length; i++) {
            listNode.next = new ListNode(charArray[0] - '0');
            listNode = listNode.next;
        }
        return header;
    }
}
