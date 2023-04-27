package tree;

/**
 * 536. 从字符串生成二叉树
 * <p>
 * https://leetcode.cn/problems/construct-binary-tree-from-string/?favorite=qg88wci
 */
public class Str2TreeDemo {


    public static void main(String[] args) {
        Str2TreeDemo demo = new Str2TreeDemo();
        System.out.println(TreeUtils.levelOrder(demo.str2tree("4(2(3)(1))(6(5))")));

        System.out.println(TreeUtils.levelOrder(demo.str2tree("-4(-2(-3)(1))(6(5)(-7))")));

    }


    public TreeNode str2tree(String s) {
        // 当字符串长度为0时，构造空结点
        if (s.length() == 0) {
            return null;
        }
        // 找到‘(’第一次出现的位置
        int pos = s.indexOf("(");
        // 如果没找到，说明字符串里不再包含子树信息，为叶子节点，用它来直接构并返回
        if (pos == -1) {
            return new TreeNode(Integer.parseInt(s));
        }
        // 构建根节点
        int rootVal = Integer.parseInt(s.substring(0, pos));
        TreeNode root = new TreeNode(rootVal);
        // 记录起始位置，从pos开始
        int start = pos;
        // 需要右括号的数量
        int rightCount = 0;
        for (int i = pos; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                rightCount++;
            } else if (s.charAt(i) == ')') {
                rightCount--;
            }
            // 当count 为0，且起始位置是从第一个'(' 开始的，那么就去构建左子树
            if (rightCount == 0 && start == pos) {
                root.left = str2tree(s.substring(start + 1, i));
                start = i + 1;// 构建完之后更新起始位置
            } else if (rightCount == 0 && start != pos) { // 如果起始位置不是第一次出现'(',就去构建右子树
                root.right = str2tree(s.substring(start + 1, i));
            }
        }
        return root;
    }
}
