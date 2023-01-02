package array;

/**
 * 544. 输出比赛匹配对
 * <p>
 * https://leetcode.cn/problems/output-contest-matches/
 */
public class FindContestMatchDemo {

    public static void main(String[] args) {
        FindContestMatchDemo demo = new FindContestMatchDemo();
        System.out.println(demo.findContestMatch(8));
    }

    public String findContestMatch(int n) {
        String[] teams = new String[n];
        for (int i = 1; i <= n; i++) {
            teams[i - 1] = String.valueOf(i);
        }
        for (; n > 1; n /= 2) {
            for (int i = 0; i < n / 2; i++) {
                teams[i] = "(" + teams[i] + "," + teams[n - i - 1] + ")";
            }
        }
        return teams[0];
    }
}
