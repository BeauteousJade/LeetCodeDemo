package twoPointer;

/**
 * 11. 盛最多水的容器
 * <p>
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class MaxAreaDemo {

    public static void main(String[] args) {
        MaxAreaDemo demo = new MaxAreaDemo();
        System.out.println(demo.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = Integer.MIN_VALUE;
        while (left < right) {
            result = Math.max(result, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
