package prefix;

import java.util.Arrays;

/**
 * 除自身以外数组的乘积
 * 给你一个长度为n的整数数组nums，其中n>1，返回输出数组output，其中output[i]等于nums中除nums[i]之外其余各元素的乘积。
 * 前缀和
 */
public class ProductExceptSelfDemo {

    public static void main(String[] args) {
        ProductExceptSelfDemo demo = new ProductExceptSelfDemo();
        int[] array = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(demo.productExceptSelf(array)));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] value = new int[nums.length];
        value[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            value[i] = value[i - 1] * nums[i];
        }
        int[] value2 = new int[nums.length];
        value2[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            value2[i] = value2[i + 1] * nums[i];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int leftValue = i == 0 ? 1 : value[i - 1];
            int rightValue = i == nums.length - 1 ? 1 : value2[i + 1];
            result[i] = leftValue * rightValue;
        }
        return result;
    }
}
