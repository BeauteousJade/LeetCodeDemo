package other;

import java.math.BigDecimal;
import java.util.*;

/**
 * 179. 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * https://leetcode-cn.com/problems/largest-number/
 */
public class LargestNumberDemo {

    public static void main(String[] args) {
        LargestNumberDemo demo = new LargestNumberDemo();
        int[] array = new int[]{3, 30, 34, 5, 9};
        System.out.println(demo.largestNumber(array));
    }

    public String largestNumber(int[] nums) {

        List<String> stringList = new ArrayList<>();
        for (int value : nums) {
            stringList.add(String.valueOf(value));
        }

        Collections.sort(stringList, (o1, o2) -> {

            String string1 = o1 + o2;
            String string2 = o2 + o1;
            return (string2).compareTo(string1);
        });

        StringBuilder res = new StringBuilder();
        for (String string : stringList) {
            res.append(string);
        }
        if (check(res.toString())) {
            return "0";
        }
        return res.toString();
    }

    private boolean check(String string) {
        boolean result = true;
        char[] charArray = string.toCharArray();
        for (char c : charArray) {
            if (c != '0') {
                result = false;
                break;
            }
        }
        return result;
    }
}
