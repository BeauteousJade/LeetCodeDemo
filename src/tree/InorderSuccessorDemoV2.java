package tree;

/**
 * 510. 二叉搜索树中的中序后继 II
 * <p>
 * https://leetcode.cn/problems/inorder-successor-in-bst-ii/
 */
public class InorderSuccessorDemoV2 {


    public static void main(String[] args) {

    }

    public Node inorderSuccessor(Node node) {
        // 若node结点有右孩子，则它的后继在树中相对较低的位置。我们向右走一次，再尽可能的向左走，返回最后所在的结点。
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            // 若 node 结点没有右孩子，则它的后继在树中相对较高的位置。我们向上走到直到结点 tmp 的左孩子是 node 的父节点时，则 node 的后继为 tmp。
            while (node.parent != null && node == node.parent.right) {
                node = node.parent;
            }
            return node.parent;
        }
    }

}
