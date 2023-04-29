package tree;

/**
 * 255. 验证前序遍历序列二叉搜索树
 * <p>
 * https://leetcode.cn/problems/verify-preorder-sequence-in-binary-search-tree/
 */
public class VerifyPreorderDemo {

    public static void main(String[] args) {
        VerifyPreorderDemo demo = new VerifyPreorderDemo();
        System.out.println(demo.verifyPreorder(new int[]{1,3,4,2}));
    }

    public boolean verifyPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);
    }


    private boolean helper(int[] array, int left, int right) {
        if (left > right) {
            return true;
        }
        // 前序遍历。那么第一个就是root.
        int root = left;
        int index = left + 1;
        // 1. 先找到左节点。左节点都小于root.
        while (index <= right && array[index] < array[root]) {
            index++;
        }
        // 2. 再找到右节点，右节点都大于root.
        int m = index;
        while (index <= right && array[index] > array[root]) {
            index++;
        }
        // 3. 如果合法二叉搜索数，那么index最后肯定等于root + 1
        return index == right + 1 && helper(array, left + 1, m - 1) && helper(array, m, right);
    }
}
