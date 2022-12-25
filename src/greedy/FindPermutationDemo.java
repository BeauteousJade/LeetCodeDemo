package greedy;

import java.util.Arrays;

/**
 * 484. 寻找排列
 * <p>
 * https://leetcode.cn/problems/find-permutation/
 */
public class FindPermutationDemo {


    public static void main(String[] args) {
        FindPermutationDemo demo = new FindPermutationDemo();
        System.out.println(Arrays.toString(demo.findPermutation("DI")));
    }

    /**
     * 字符串由 n 个 D和 m 个 I随机组成。其中 n 个 D 是由 n + 1个数字降序组成，m 个 I 由 m + 1个数组升序组成。
     * 所以算法核心就是找到D I的分割线，将之前属于D的部分倒序即可。
     */
    public int[] findPermutation(String s) {
        int n = s.length();
        int res[] = new int[n + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        int i = 1;
        while (i < res.length) {
            int j = i;
            // 找到属于D的区间，然后将这个区间给倒叙。
            while (i < res.length && s.charAt(i - 1) == 'D') {
                i++;
            }
            reverse(res, j - 1, i);
            i++;
        }
        return res;
    }


    private void reverse(int[] res, int start, int end) {
        int left = start;
        int right = end - 1;
        while (left < right) {
            int temp = res[left];
            res[left] = res[right];
            res[right] = temp;
            left++;
            right--;
        }
    }
}
