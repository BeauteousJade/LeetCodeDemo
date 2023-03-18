package dataStructure;

import tree.TreeNode;

import java.util.Stack;

/**
 * 剑指 Offer II 055. 二叉搜索树迭代器
 * <p>
 * https://leetcode.cn/problems/kTOapQ/
 */
class BSTIterator {

    private TreeNode currentNode;
    private final Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        currentNode = root;
        stack = new Stack<>();
    }

    /**
     * 二叉搜索树，中序遍历是从小到大的序列。
     * 所以这里类似于二叉搜索的中序遍历。
     */
    public int next() {
        // 1. 优先遍历left。
        while (currentNode != null) {
            stack.push(currentNode);
            currentNode = currentNode.left;
        }
        // 2. 处理 root.
        currentNode = stack.pop();
        int ret = currentNode.val;
        // 3. 记录right，以待下次遍历。
        currentNode = currentNode.right;
        return ret;
    }

    public boolean hasNext() {
        return currentNode != null || !stack.isEmpty();
    }
}