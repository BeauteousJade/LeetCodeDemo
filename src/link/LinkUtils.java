package link;

import java.util.ArrayList;
import java.util.List;

public class LinkUtils {


    public static ListNode buildListNode(int[] array) {
        ListNode header = new ListNode(array[0]);
        ListNode listNode = header;
        for (int i = 1; i < array.length; i++) {
            listNode.next = new ListNode(array[i]);
            listNode = listNode.next;
        }
        return header;
    }


    public static void listNodeToString(ListNode listNode) {
        List<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        System.out.println(list);
    }
}
