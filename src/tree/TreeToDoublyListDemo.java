package tree;

/**
 * 426. 将二叉搜索树转化为排序的双向链表
 * <p>
 * https://leetcode.cn/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 */
// TODO 下次
public class TreeToDoublyListDemo {


    public static void main(String[] args) {

    }

    private Node last;
    private Node first;


    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        helper(root);
        last.right = first;
        first.left = last;
        return first;
    }

    private void helper(Node root) {
        if (root == null) {
            return;
        }
        // 先构建左侧
        helper(root.left);
        // 再构建root.
        if (last != null) {
            last.right = root;
            root.left = last;
        } else {
            first = root;
        }
        last = root;
        // 最后构建右侧
        helper(root.right);
    }
}
