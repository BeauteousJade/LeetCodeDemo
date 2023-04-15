package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 * <p>
 * https://leetcode.cn/problems/unique-binary-search-trees/
 */
public class GenerateTreesDemo {

    public static void main(String[] args) {

    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> list = new LinkedList<>();
        if (start > end) {
            // 这里需要添加null,否则下面遍历Child,添加不上去.
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i++) {

            List<TreeNode> left = generateTrees(start, i - 1);
            List<TreeNode> right = generateTrees(i + 1, end);
            for (TreeNode leftChild : left) {
                for (TreeNode rightChild : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftChild;
                    root.right = rightChild;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
