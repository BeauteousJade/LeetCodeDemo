package binarySearch;

import java.util.Arrays;

/**
 * 39. 组合总和
 * <p>
 * https://leetcode-cn.com/problems/combination-sum/
 */
public class SearchRangeDemo {

    public static void main(String[] args) {
        SearchRangeDemo demo = new SearchRangeDemo();
        int[] array = new int[]{1};
        System.out.println(Arrays.toString(demo.searchRange(array, 8)));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        res[0] = search(true, nums, target);
        res[1] = search(false, nums, target);
        return res;
    }


    private int search(boolean isLeft, int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        boolean isFind = false;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                isFind = true;
                if (isLeft) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (!isFind) {
            return -1;
        }
        return isLeft ? left : right;
    }
}
