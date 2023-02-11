package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * <p>
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
// TODO 重点。
public class BuildTreeV2Demo {

    public static void main(String[] args) {

    }

    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeV2(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }


    private TreeNode buildTreeV2(int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft, int postRight) {
        if (postLeft > postRight) {
            return null;
        }
        int postRoot = postRight;
        int inRoot = map.get(postorder[postRoot]);
        int rightSize = inRight - inRoot;
        TreeNode root = new TreeNode(inorder[inRoot]);
        root.right = buildTreeV2(inorder, postorder, inRoot + 1, inRight, postRoot - rightSize, postRoot - 1);
        root.left = buildTreeV2(inorder, postorder, inLeft, inRoot - 1, postLeft, postRoot - rightSize - 1);
        return root;
    }
}
