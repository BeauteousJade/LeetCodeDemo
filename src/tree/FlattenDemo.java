package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 114. 二叉树展开为链表
 * <p>
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */
// TODO 下次
public class FlattenDemo {

    public static void main(String[] args) {

    }

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        flatten(root, list);
        TreeNode preNode = null;
        for (int i = 0; i < list.size(); i++) {
            TreeNode treeNode = list.get(i);
            if (preNode != null) {
                preNode.right = treeNode;
                preNode.left = null;
            }
            preNode = treeNode;
        }
    }

    private void flatten(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        flatten(root.left, list);
        flatten(root.right, list);
    }
}
