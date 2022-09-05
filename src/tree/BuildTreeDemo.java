package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 * <p>
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
// TODO 重点。
public class BuildTreeDemo {
    public static void main(String[] args) {

    }

    private final Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        // 前序第一个节点是root
        int preRoot = preLeft;
        // 通过root节点的值，找到root在中序的index
        int inRoot = map.get(preorder[preRoot]);
        // 构造root
        TreeNode root = new TreeNode(inorder[inRoot]);
        // 左child的数量。
        int leftSize = inRoot - inLeft;
        root.left = buildTree(preorder, inorder, preLeft + 1, preLeft + leftSize, inLeft, inRoot - 1);
        root.right = buildTree(preorder, inorder, preLeft + 1 + leftSize, preRight, inRoot + 1, inRight);
        return root;
    }
}
