package dp;

/**
 * 926. 将字符串翻转到单调递增
 * <p>
 * https://leetcode.cn/problems/flip-string-to-monotone-increasing/
 */
public class MinFlipsMonoIncrDemo {

    public static void main(String[] args) {

    }

    /**
     * dp
     * <p>
     * 考虑s的当前字母:
     * <p>
     * 如果它是‘1’，则无需转变。
     * 如果它是‘0’：
     * <p>
     * 转变它，则答案为「使s的n−1个字母的转换次数」加上1。
     * 保留它，那么前面的所有‘1’都要都转变；
     * <p>
     * 设 count 为前 i 个字母中 ‘1’ 的个数。定义 f[i] 表示是s 的前 i 个字母的最少转换次数：
     * 如果第 i 个字母是 ‘1’，则 f[i]=f[i−1]；
     * 如果第 i 个字母是 ‘0’，则 f[i]=min(f[i−1]+1,count)。
     */
    public int minFlipsMonoIncr(String s) {
        int f = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                // count:将前面所有的1变成0.
                // f + 1:将当前的0变成1.
                f = Math.min(f + 1, count);
            }
        }
        return f;
    }

    /**
     * 非dp
     */
    public int minFlipsMonoIncrV2(String s) {
        // 记录的是当前右侧还有多少个0.
        int rightCount0 = 0;
        // 记录当前左侧有多少1.
        int leftCount1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                rightCount0++;
            }
        }
        int res = rightCount0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                // 当前出现0，会减-1，右侧1的个数就少了1个。
                rightCount0--;
            } else {
                leftCount1++;
            }
            // 结果就是把右侧的0翻转为1，和把左侧的1转成0.
            res = Math.min(res, rightCount0 + leftCount1);
        }
        return res;
    }
}
