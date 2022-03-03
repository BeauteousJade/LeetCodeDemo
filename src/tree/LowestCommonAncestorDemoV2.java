package tree;

/**
 * 236. 二叉树的最近公共祖先
 * <p>
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
// TODO pangbingyu 重点
public class LowestCommonAncestorDemoV2 {

    private TreeNode res;

    public static void main(String[] args) {

    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }

    /**
     * 检测当前root所在的树是否含有p或者q。
     * true表示含有其中一个；false表示没有。
     */
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean isLeft = dfs(root.left, p, q);
        boolean isRight = dfs(root.right, p, q);
        // isLeft && isRight: 左侧含有一个目标节点，右侧含有另外一个目标节点。
        // (root.val == q.val || root.val == p.val) && (isLeft || isRight): root 是目标节点，左侧或者右侧是另外一个节点。
        if ((isLeft && isRight) || ((root.val == q.val || root.val == p.val) && (isLeft || isRight))) {
            res = root;
        }
        return isLeft || isRight || root.val == q.val || root.val == p.val;
    }
}
