package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的后序遍历
 */
public class PostorderTraversalDem {
    public static void main(String[] args) {

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        post(list, root);
        return list;
    }

    private void post(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        post(list, root.left);
        post(list, root.right);
        list.add(root.val);

    }

}
