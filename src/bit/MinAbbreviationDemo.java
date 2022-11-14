package bit;

import java.util.ArrayList;
import java.util.List;

/**
 * 411. 最短独占单词缩写
 * <p>
 * https://leetcode.cn/problems/minimum-unique-word-abbreviation/
 */
public class MinAbbreviationDemo {


    public static void main(String[] args) {
        MinAbbreviationDemo demo = new MinAbbreviationDemo();
        String str = "apple";
        String[] dictionary = {"blade", "plain", "amber"};
        System.out.println(demo.minAbbreviation(str, dictionary));
    }

    public String minAbbreviation(String target, String[] dictionary) {
        int n = target.length();

        //1. 剪枝，字典和当前字符串长度不一致的不要，找出与target相同字母位置的掩码
        List<Integer> sames = new ArrayList<>();
        for (String word : dictionary) {
            if (word.length() == target.length()) {
                int reproduce = 0;
                for (int j = 0; j < n; j++) {
                    if (word.charAt(j) == target.charAt(j)) {
                        reproduce |= (1 << j);
                    }
                }

                sames.add(reproduce);
            }
        }

        //2. 剪枝，如果筛选后没字典，直接返回长度对应数字
        if (sames.size() == 0) {
            return String.valueOf(n);
        }
        //3.获取最优情况对应的长度，掩码
        int max = (1 << n);
        int len = Integer.MAX_VALUE;
        int mask = Integer.MAX_VALUE;
        label:
        for (int i = 0; i < max; i++) {
            int strLen = getLen(target, i);
            if (strLen >= len) {
                continue;
            }
            for (int curr : sames) {
                //4.如果和完全包含当前掩码，说明和这个单词形成的结果与原单词一致，不能作为结果
                if ((curr & i) == i) {
                    // 相当于break,但是不执行下面的逻辑。
                    continue label;
                }
            }
            len = strLen;
            mask = i;

        }

        //5.优化，最后再切字符串，合成字符串的时机越晚越好
        return getShortStr(target, mask);
    }

    private int getLen(String str, int mask) {
        int cnt = 0;
        int n = str.length();
        int len = 0;
        // 如果当前位置上的bit是1，表示不省掉当前字符；反之则省掉。
        // 由于字符长度不超过1，所以简化字符的所有情况映射成为二进制，不超过1 << 21。
        // 所以，只需要遍历这个范围即可。
        for (int i = 0; i < n; i++) {
            // 1. 省掉
            if ((mask & (1 << i)) == 0) {
                ++cnt;
                continue;
            } else if (cnt > 0) {
                // 2. 结束省掉，并且添加数字，长度只算1
                cnt = 0;
                ++len;
            }
            // 3. 不省当前字符，追加当前字符。
            ++len;
        }

        if (cnt > 0) {
            ++len;
        }
        return len;
    }

    /**
     * 根据当前mask,计算省略字符。
     */
    private String getShortStr(String str, int mask) {
        int cnt = 0;
        int n = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) == 0) {
                ++cnt;
                continue;
            } else if (cnt > 0) {
                sb.append(cnt);
                cnt = 0;
            }
            sb.append(str.charAt(i));
        }

        if (cnt > 0) {
            sb.append(cnt);
        }
        return sb.toString();
    }
}
