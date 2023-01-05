package greedy;

/**
 * 555. 分割连接字符串
 * <p>
 * https://leetcode.cn/problems/split-concatenated-strings/?favorite=qg88wci
 */
public class SplitLoopedStringDemo {


    public static void main(String[] args) {

        SplitLoopedStringDemo demo = new SplitLoopedStringDemo();
        String[] strings = {"abc", "xyz"};
        System.out.println(demo.splitLoopedStringV2(strings));
    }


    private String ans = "";

    /**
     * 深搜解法 -- 超时。
     */
    public String splitLoopedString(String[] strs) {
        dfs("", strs, 0);
        return ans;
    }

    private void dfs(String prefix, String[] strings, int index) {
        if (index == strings.length) {
            for (int i = 0; i < prefix.length(); i++) {
                String newString = prefix.substring(i) + prefix.substring(0, i);
                if (newString.compareTo(ans) > 0) {
                    ans = newString;
                }
            }
        } else {
            String currString = strings[index];
            String nextPrefix = prefix + currString;
            dfs(nextPrefix, strings, index + 1);
            nextPrefix = prefix + new StringBuilder(currString).reverse();
            dfs(nextPrefix, strings, index + 1);

        }
    }


    /**
     * 贪心。
     */
    public String splitLoopedStringV2(String[] strs) {
        // 1. 想将每个String替换成为正序和倒序中最大的String.
        // 以备在切割String，再重新拼接的时候，字典序是最大的。
        for (int i = 0; i < strs.length; i++) {
            String string = strs[i];
            String reverse = new StringBuilder(strs[i]).reverse().toString();
            if (reverse.compareTo(string) > 0) {
                strs[i] = reverse;
            }
        }
        String ans = "";

        // 2. 尝试切割每个String，分为倒序和正序方式拼接String，比较大小。
        for (int i = 0; i < strs.length; i++) {

            String string = strs[i];
            String reverse = new StringBuilder(string).reverse().toString();

            StringBuilder other = new StringBuilder();
            for (int j = i + 1; j < strs.length; j++) {
                other.append(strs[j]);
            }
            for (int j = 0; j < i; j++) {
                other.append(strs[j]);
            }

            for (int j = 0; j < string.length(); j++) {
                String current = string.substring(j) + other + string.substring(0, j);
                if (current.compareTo(ans) > 0) {
                    ans = current;
                }
            }
            for (int j = 0; j < string.length(); j++) {
                String current = reverse.substring(j) + other + reverse.substring(0, j);
                if (current.compareTo(ans) > 0) {
                    ans = current;
                }
            }
        }
        return ans;
    }
}
