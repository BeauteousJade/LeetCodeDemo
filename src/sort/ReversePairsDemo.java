package sort;

/**
 * 剑指 Offer 51. 数组中的逆序对 -- 归并排序
 * <p>
 * https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 */
public class ReversePairsDemo {

    public static void main(String[] args) {

    }


    int[] nums;
    int[] tmp;

    public int reversePairs(int[] nums) {
        this.nums = nums;
        tmp = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }

    private int mergeSort(int left, int right) {
        // 终止条件
        if (left >= right) {
            return 0;
        }
        // 递归划分
        int mid = (left + right) / 2;
        int res = mergeSort(left, mid) + mergeSort(mid + 1, right);
        // 合并阶段
        int leftStart = left;
        int rightStart = mid + 1;
        for (int k = left; k <= right; k++) {
            tmp[k] = nums[k];
        }
        for (int k = left; k <= right; k++) {
            if (leftStart == mid + 1) {
                nums[k] = tmp[rightStart++];
            } else if (rightStart == right + 1 || tmp[leftStart] <= tmp[rightStart]) {
                nums[k] = tmp[leftStart++];
            } else {
                nums[k] = tmp[rightStart++];
                res += mid - leftStart + 1; // 统计逆序对
            }
        }
        return res;
    }
}
