import link.ListNode;

public class TestDemo {

    public static void main(String[] args) {
        TestDemo demo = new TestDemo();
        demo.test();
    }

    private void test() {
        long time = System.currentTimeMillis();
        boolean a = false;
        for (int i = 0; i < Integer.MAX_VALUE / 10; i++) {
            a = !a;
        }
        System.out.println(System.currentTimeMillis() - time);
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
