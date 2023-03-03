package tree;

import java.util.*;

/**
 * 501. 二叉搜索树中的众数
 * <p>
 * https://leetcode.cn/problems/find-mode-in-binary-search-tree/
 */
public class FindModeDemo {

    public static void main(String[] args) {
        Integer[] array = {6, 2, 8, 0, 4, 7, 9, null, null, 2, 6};
        TreeNode tree = TreeUtils.buildTree(array);
        System.out.println(TreeUtils.levelOrder(tree));
        FindModeDemo demo = new FindModeDemo();
        System.out.println(Arrays.toString(demo.findMode(tree)));
    }

    int base, count, maxCount;
    List<Integer> answer = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] mode = new int[answer.size()];
        for (int i = 0; i < answer.size(); ++i) {
            mode[i] = answer.get(i);
        }
        return mode;
    }

    public void dfs(TreeNode o) {
        if (o == null) {
            return;
        }
        dfs(o.left);
        update(o.val);
        dfs(o.right);
    }

    public void update(int x) {
        if (x == base) {
            ++count;
        } else {
            count = 1;
            base = x;
        }
        if (count == maxCount) {
            answer.add(base);
        }
        if (count > maxCount) {
            maxCount = count;
            answer.clear();
            answer.add(base);
        }
    }

}
