package link;

/**
 * 708. 循环有序列表的插入 -- 链表插入。
 * <p>
 * https://leetcode.cn/problems/insert-into-a-sorted-circular-linked-list/
 */
public class InsertDemo {

    public static void main(String[] args) {
        InsertDemo demo = new InsertDemo();
        int[] array = {3, 5, 1};
        Node node = demo.buildNode(array);
        demo.printNode(node);
        node = demo.insert(node, 5);
        demo.printNode(node);
    }


    private Node buildNode(int[] array) {
        Node node = new Node(array[0]);
        Node head = node;
        for (int i = 1; i < array.length; i++) {
            node.next = new Node(array[i]);
            node = node.next;
        }
        node.next = head;
        return head;
    }

    private void printNode(Node node) {
        Node head = node;
        System.out.print(head.val + " ");
        node = node.next;
        while (node != head) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        }
        if (head.next == head) {
            head.next = node;
            node.next = head;
            return head;
        }
        Node curr = head, next = head.next;
        while (next != head) {
            // 连续的值，插入两个中间。
            if (insertVal >= curr.val && insertVal <= next.val) {
                break;
            }
            // 当前值小于下一个值，表示出现最大值和最小值。此时可能需要将新的值插入到他俩中间。
            // 出现环的地方，curren是最大值，next是最小值。
            if (curr.val > next.val) {
                // 如果说插入值比当前值或者当前值比下一个值小，可以插入。
                if (insertVal > curr.val || insertVal < next.val) {
                    break;
                }
            }
            curr = curr.next;
            next = next.next;
        }
        // 1. 前面break的，需要插入。
        // 2. 如果前面没有break，那么就插入到最后一个。
        curr.next = node;
        node.next = next;
        return head;
    }


    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    ;
}
