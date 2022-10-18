package tree;

/**
 * 255. 验证前序遍历序列二叉搜索树
 * <p>
 * https://leetcode.cn/problems/verify-preorder-sequence-in-binary-search-tree/
 */
public class VerifyPreorderDemo {

    public static void main(String[] args) {
        VerifyPreorderDemo demo = new VerifyPreorderDemo();
        System.out.println(demo.verifyPreorder(new int[]{5, 2, 6, 1, 3}));
    }

    public boolean verifyPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    private boolean helper(int[] array, int left, int right, int min, int max) {
        if (left >= array.length || left > right) {
            return true;
        }
        if (left == right) {
            return array[left] > min && array[right] < max;
        }
        int root = left;
        if (array[root] <= min || array[root] >= max) {
            return false;
        }
        int newLeft = left + 1;
        while (newLeft < array.length && array[newLeft] < array[root]) {
            newLeft++;
        }
        return helper(array, left + 1, newLeft - 1, min, array[root]) && helper(array, newLeft, right, array[root], max);
    }
}
