package other;

/**
 * 245. 最短单词距离 III
 * <p>
 * https://leetcode.cn/problems/shortest-word-distance-iii/
 */
public class ShortestWordDistanceDemoV2 {

    public static void main(String[] args) {
        ShortestWordDistanceDemoV2 demo = new ShortestWordDistanceDemoV2();
        System.out.println(demo.shortestWordDistance(new String[]{"a", "c", "a", "b"}, "a", "b"));
    }

    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int ans = wordsDict.length;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1) && (index1 < index2 || !word1.equals(word2))) {
                index1 = i;
            } else if (wordsDict[i].equals(word2)) {
                index2 = i;
            }
            if (index1 >= 0 && index2 >= 0) {
                ans = Math.min(ans, Math.abs(index1 - index2));
            }
        }
        return ans;
    }

    public int shortestWordDistanceV2(String[] wordsDict, String word1, String word2) {
        int length = wordsDict.length;
        int ans = length;
        if (word1.equals(word2)) {
            int prev = -1;
            for (int i = 0; i < length; i++) {
                String word = wordsDict[i];
                if (word.equals(word1)) {
                    if (prev >= 0) {
                        ans = Math.min(ans, i - prev);
                    }
                    prev = i;
                }
            }
        } else {
            int index1 = -1, index2 = -1;
            for (int i = 0; i < length; i++) {
                String word = wordsDict[i];
                if (word.equals(word1)) {
                    index1 = i;
                } else if (word.equals(word2)) {
                    index2 = i;
                }
                if (index1 >= 0 && index2 >= 0) {
                    ans = Math.min(ans, Math.abs(index1 - index2));
                }
            }
        }
        return ans;
    }
}
