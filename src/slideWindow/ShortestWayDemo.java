package slideWindow;

/**
 * 1055. 形成字符串的最短路径
 * <p>
 * https://leetcode.cn/problems/shortest-way-to-form-string/
 */
public class ShortestWayDemo {

    public static void main(String[] args) {

    }

    public int shortestWay(String source, String target) {
        int j = 0;
        int count = 0;
        while (j < target.length()) {
            int prev = j;
            for (int i = 0; i < source.length(); i++) {
                if (j < target.length() && source.charAt(i) == target.charAt(j)) {
                    j++;
                } else if (j >= target.length()) {
                    break;
                }
            }
            // 如果没有匹配上的，表示该字符在source里面没有出现过，直接返回。
            if (prev == j) {
                return -1;
            }
            count++;
        }
        return count;
    }
}
