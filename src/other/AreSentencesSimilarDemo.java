package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 734. 句子相似性 -- 遍历
 * <p>
 * https://leetcode.cn/problems/sentence-similarity/
 */
public class AreSentencesSimilarDemo {


    public static void main(String[] args) {
        AreSentencesSimilarDemo demo = new AreSentencesSimilarDemo();
        String[] word1 = {"great"};
        String[] word2 = {"doubleplus", "good"};
        String[][] array = {{"great", "doubleplus"}};
        List<List<String>> list = new ArrayList<>();
        for (String[] array1 : array) {
            list.add(Arrays.asList(array1));
        }
        System.out.println(demo.areSentencesSimilar(word1, word2, list));
    }


    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }

        int length = sentence1.length;
        for (int i = 0; i < length; i++) {
            String word1 = sentence1[i];
            String word2 = sentence2[i];
            if (!checkSimilar(word1, word2, similarPairs)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSimilar(String word1, String word2, List<List<String>> similarPairs) {
        if (word1.equals(word2)) {
            return true;
        }
        for (List<String> similarPair : similarPairs) {
            if (similarPair.get(0).equals(word1) && similarPair.get(1).equals(word2) || similarPair.get(0).equals(word2) && similarPair.get(1).equals(word1)) {
                return true;
            }
        }
        return false;
    }
}
