package dp;

/**
 * 418. 屏幕可显示句子的数量
 * <p>
 * https://leetcode.cn/problems/sentence-screen-fitting/
 */
public class WordsTypingDemo {


    public static void main(String[] args) {

    }

    /**
     * 暴力。
     */
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int n = sentence.length;
        int[] lens = new int[n];
        for (int i = 0; i < sentence.length; i++) {
            lens[i] = sentence[i].length();
        }
        int res = 0;
        int index = 0;
        int currentCol = 0;
        int wordIndex = 0;
        while (index < rows) {
            currentCol = 0;
            while (currentCol + lens[wordIndex] <= cols) {
                currentCol += lens[wordIndex] + 1;
                wordIndex++;
                if (wordIndex == n) {
                    res++;
                    wordIndex = 0;
                }
            }
            index++;
        }
        return res;
    }


    /**
     * dp
     */
    public int wordsTypingV2(String[] sentence, int rows, int cols) {
        int n = sentence.length;
        int wordIndex = 0;
        int[] len = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = sentence[i].length();
        }
        // dp[i]:表示以第i个word开始，dp[i]的值，下一行以哪个word开始。
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            wordIndex = i;
            int currRowLen = 0;
            int times = 0;
            while (currRowLen + len[wordIndex] <= cols) {
                currRowLen += len[wordIndex++] + 1;
                if (wordIndex == n) {
                    wordIndex = 0;
                    times++;
                }
            }
            // 单词数量不超过100，所以这里* 100.
            // times 表示重复次数，wordIndex表示下一行以哪个word开始。
            dp[i] = wordIndex + times * 100;
        }
        int index = 0;
        int res = 0;
        wordIndex = 0;
        while (index < rows) {
            index++;
            // dp[i] / 100是填充完这一行以后增加的遍历sentence的次数
            res += dp[wordIndex] / 100;
            // dp[i] % 100是下一行从哪个word开始
            wordIndex = dp[wordIndex] % 100;
        }
        return res;
    }
}
