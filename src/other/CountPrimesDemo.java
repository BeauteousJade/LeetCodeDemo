package other;

import java.util.Arrays;
import java.util.Map;

/**
 * 204. 计数质数
 * <p>
 * https://leetcode-cn.com/problems/count-primes/
 */
public class CountPrimesDemo {

    public static void main(String[] args) {
        CountPrimesDemo demo = new CountPrimesDemo();
        System.out.println(demo.countPrimes(500000));
    }

    public int countPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                ans += 1;
                // 注意强转。
                if ((long) i + i < n) {
                    // 从 i * i，开始，因为2 * i,3 * i等已经被标记了。
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }

    public boolean isPrime(int x) {
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
