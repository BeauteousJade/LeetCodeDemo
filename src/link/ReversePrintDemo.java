package link;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * <p>
 * https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class ReversePrintDemo {

    public static void main(String[] args) {
        ReversePrintDemo demo = new ReversePrintDemo();
        System.out.println(Arrays.toString(demo.reversePrint(LinkUtils.buildListNode(new int[]{1, 2, 3, 4, 5}))));
    }

    private final List<Integer> res = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        dfs(head);
        int[] array = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            array[i] = res.get(i);
        }
        return array;
    }

    private void dfs(ListNode head) {
        if (head == null) {
            return;
        }
        dfs(head.next);
        res.add(head.val);
    }
}
