package binarySearch;

/**
 * 287. 寻找重复数
 * <p>
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 */
// TODO 下次
public class FindDuplicateDemo {

    public static void main(String[] args) {
        FindDuplicateDemo demo = new FindDuplicateDemo();
        System.out.println(demo.findDuplicateV2(new int[]{1, 3, 4, 2, 2}));
    }

    /**
     * 解释：https://leetcode.cn/problems/find-the-duplicate-number/solution/mei-kan-dong-er-fen-cha-zhao-ti-jie-de-x-0ixw/
     */
    public int findDuplicate(int[] nums) {
        final int n = nums.length;
        int ans = 0;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int i = 0; i < n; i++) {
                // 计算小于mid的个数
                if (nums[i] <= mid) {
                    count++;
                }
            }
            // <=,答案肯定不在左边。
            // 重复数：target,小于等于target的count > target。
            if (count <= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }


    /**
     * 判断环的方法。
     */
    public int findDuplicateV2(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

}
