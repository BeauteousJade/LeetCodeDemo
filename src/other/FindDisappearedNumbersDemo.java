package other;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 * <p>
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 */
public class FindDisappearedNumbersDemo {

    public static void main(String[] args) {
        FindDisappearedNumbersDemo demo = new FindDisappearedNumbersDemo();
        System.out.println(demo.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            nums[(num - 1) % n] += n;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
