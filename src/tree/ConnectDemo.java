package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * <p>
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
// TODO 下次
public class ConnectDemo {

    public static void main(String[] args) {

    }


    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node preNode = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (preNode != null) {
                    preNode.next = node;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                preNode = node;
            }
        }
        return root;
    }
}
