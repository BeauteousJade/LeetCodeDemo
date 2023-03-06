package dp;

/**
 * 1653. 使字符串平衡的最少删除次数
 * <p>
 * https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced/
 */
public class MinimumDeletionsDemo {

    public static void main(String[] args) {

    }

    public int minimumDeletions(String s) {
        int n = s.length();
        // 字符串右侧还剩下多少个字符a.
        int rightA = 0;
        // 字符串左侧出现了多少个字符b.
        int leftB = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                rightA++;
            }
        }
        int res = rightA;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                rightA--;
            } else {
                leftB++;
            }
            // 此时就是删除右侧的a，同时删除左侧的b。
            res = Math.min(res, rightA + leftB);
        }
        return res;
    }

    /**
     * 考虑s的最后一个字母:
     * <p>
     * 如果它是‘b’，则无需删除，问题规模缩小，变成「使s的前n−1个字母平衡的最少删除次数」。
     * 如果它是‘a’：
     * <p>
     * 删除它，则答案为「使s的n−1个字母平衡的最少删除次数」加上1。
     * 保留它，那么前面的所有‘b’都要删除；
     * <p>
     * 设 cntB 为前 i 个字母中 ‘b’ 的个数。定义 f[i] 表示是s 的前 i 个字母平衡的最少删除次数：
     * 如果第 i 个字母是 ‘b’，则 f[i]=f[i−1]；
     * 如果第 i 个字母是 ‘a’，则 f[i]=min(f[i−1]+1,cntB)。
     */
    public int minimumDeletionsV2(String s) {
        int f = 0;
        int countB = 0;
        for (char c : s.toCharArray()) {
            if (c == 'b') {
                ++countB; // f 值不变
            } else {
                f = Math.min(f + 1, countB);
            }
        }
        return f;
    }
}