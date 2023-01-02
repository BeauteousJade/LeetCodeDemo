package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class LevelOrderDemo {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        return TreeUtils.levelOrder(root);
    }
}
