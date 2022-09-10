package twoPointer;

/**
 * 删除有序数组中的重复项
 * <p>
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesDemo {

    public static void main(String[] args) {
        RemoveDuplicatesDemo demo = new RemoveDuplicatesDemo();
        System.out.println(demo.removeDuplicates(new int[]{1, 2, 2, 2, 3}));
    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}
