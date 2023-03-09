package tree;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * <p>
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 */
public class VerifyPostorderDemo {

    public static void main(String[] args) {

    }

    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    boolean recur(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int startIndex = start;
        // 1.从数组左侧开始遍历，看是否都小于root。(此时应该是root的左节点)
        while (postorder[startIndex] < postorder[end]) {
            startIndex++;
        }
        // 2.左节点遍历完了，看是否都大于root。(此时应该是root的右节点)
        int m = startIndex;
        while (postorder[startIndex] > postorder[end]) {
            startIndex++;
        }
        // 3. 最后肯定会 == end。如果不等于end，那么表示不是二叉搜索树。
        return startIndex == end && recur(postorder, start, m - 1) && recur(postorder, m, end - 1);
    }
}
