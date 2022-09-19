package greedy;

/**
 * 45. 跳跃游戏 II
 * <p>
 * https://leetcode.cn/problems/jump-game-ii/
 */
public class JumpDemoV2 {

    public static void main(String[] args) {
        JumpDemoV2 demo = new JumpDemoV2();
        demo.jump(new int[]{2, 3, 1, 1, 4});
    }


    public int jump(int[] nums) {
        int step = 0;
        int end = 0;
        int maxPosition = 0;
        // 如果刚刚跳到最后一个，i遍历到最后一个，多跳一次。所以这里直接 < nums.length - 1.
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }
        return step;
    }
}
