package link;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文链表
 * <p>
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class IsPalindromeDemo {

    public static void main(String[] args) {
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (list.get(left).equals(list.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private ListNode frontPointer;

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public boolean isPalindromeV2(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }
}
