package tree;

/**
 * 剑指 Offer 26. 树的子结构
 * <p>
 * https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/
 */
public class IsSubStructureDemo {


    public static void main(String[] args) {
        IsSubStructureDemo demo = new IsSubStructureDemo();
        TreeNode roo1 = TreeUtils.buildTree(new Integer[]{1, 0, 1, -4, -3});
        TreeNode roo2 = TreeUtils.buildTree(new Integer[]{1, -4});

        System.out.println(demo.isSubStructure(roo1, roo2));
    }

    /**
     * 先序遍历的思想。
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        // 先判断根。
        boolean res = dfs(A, B);
        // 在判断左右节点。
        res = res || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        return res;
    }

    private boolean dfs(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null || root1.val != root2.val) {
            return false;
        }
        return dfs(root1.left, root2.left) && dfs(root1.right, root2.right);
    }
}
