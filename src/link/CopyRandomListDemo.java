package link;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 35. 复杂链表的复制
 * <p>
 * https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 */
public class CopyRandomListDemo {

    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node node = head;
        Node newNode;
        Node preNode = null;
        Node preHead = new Node(0);
        // 1. 先把next 节点一个一个拷贝出来，并且将旧节点到新节点的映射存起来。
        while (node != null) {
            newNode = new Node(node.val);
            map.put(node, newNode);
            if (preNode == null) {
                preNode = preHead;
            }
            preNode.next = newNode;
            preNode = newNode;
            node = node.next;
        }

        // 2. 根据建立好的新旧节点映射关系，处理random的指针。
        node = head;
        while (node != null) {
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return preHead.next;
    }

    public class Node {
        public int val;
        public Node next;
        Node random;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
