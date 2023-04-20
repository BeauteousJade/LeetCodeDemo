package dp;

/**
 * 313. 超级丑数
 * <p>
 * https://leetcode.cn/problems/super-ugly-number/
 */
public class NthSuperUglyNumberDemo {

    public static void main(String[] args) {

    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        //记录丑数的数组
        int nums[] = new int[n];
        nums[0] = 1;
        //每个因子的位置
        int primesIndex[] = new int[primes.length];
        int count = 1;
        while (count < n) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < primes.length; i++) {
                // 这里相乘可能会溢出，所以做一下判断。
                if (nums[primesIndex[i]] <= Integer.MAX_VALUE / primes[i]) {
                    //求乘以每一个因子得到的最小丑数
                    int temp = nums[primesIndex[i]] * primes[i];
                    min = Math.min(temp, min);
                }
            }
            for (int i = 0; i < primes.length; i++) {
                //更新index，可能更新多个index
                if (min == nums[primesIndex[i]] * primes[i]) {
                    primesIndex[i]++;
                }
            }
            nums[count++] = min;
        }
        return nums[count - 1];
    }
}
