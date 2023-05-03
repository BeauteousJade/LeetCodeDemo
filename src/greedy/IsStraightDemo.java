package greedy;

import java.util.Arrays;

/**
 * 面试题61. 扑克牌中的顺子
 * <p>
 * https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 */
// TODO 下次
public class IsStraightDemo {

    public static void main(String[] args) {
        IsStraightDemo demo = new IsStraightDemo();
        System.out.println(demo.isStraight(new int[]{0, 0, 2, 2, 5}));
    }

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count0 = 0;
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                count0++;
            } else if (nums[i] == nums[i]) {
                return false;
            }
        }
        // 最大值和最小值的diff 小于5。
        return nums[4] - nums[count0] < 5;
    }
}
