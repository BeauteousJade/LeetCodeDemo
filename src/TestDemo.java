import link.ListNode;

public class TestDemo {

    public static void main(String[] args) {
        TestDemo demo = new TestDemo();

    }

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node listNode = new Node(insertVal);
            listNode.next = listNode;
            return listNode;
        }
        if (head.next == null) {
            Node listNode = new Node(insertVal);
            head.next = listNode;
            listNode.next = head;
            return head;
        }

        Node current = head;
        Node next = head.next;
        while (next != head) {
            if (current.val <= insertVal && next.val >= insertVal) {
                break;
            }
            // 环
            if (current.val > next.val) {
                if (insertVal >= current.val || insertVal <= next.val) {
                    break;
                }
            }
            current = current.next;
            next = next.next;
        }
        current.next = new Node(insertVal);
        current.next.next = next;
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
}
