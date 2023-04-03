package greedy;

/**
 * 55. 跳跃游戏
 * <p>
 * https://leetcode-cn.com/problems/jump-game/
 * 贪心。
 */
public class CanJumpDemo {

    public static void main(String[] args) {
        CanJumpDemo demo = new CanJumpDemo();
        int[] array = new int[]{2, 3, 1, 1, 4};
        System.out.println(demo.canJump(array));
    }

    public boolean canJump(int[] nums) {

        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i <= max) {
                max = Math.max(i + nums[i], max);
                if (max >= nums.length - 1) {
                    return true;
                }
            }
        }

        return false;
    }
}
