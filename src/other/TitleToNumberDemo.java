package other;

import java.util.HashMap;
import java.util.Map;

/**
 * 171. Excel 表列序号
 * <p>
 * https://leetcode-cn.com/problems/excel-sheet-column-number/
 */
public class TitleToNumberDemo {

    public static void main(String[] args) {
        TitleToNumberDemo demo = new TitleToNumberDemo();
        System.out.println(demo.titleToNumber("ZY"));
    }

    public int titleToNumber(String columnTitle) {
        Map<Character, Integer> map = new HashMap<>();
        for (char i = 'A'; i <= 'Z'; i++) {
            map.put(i, i - 'A' + 1);
        }
        char[] charArray = columnTitle.toCharArray();
        int index = charArray.length - 1;
        int value = 1;
        int result = 0;
        while (index >= 0) {
            result += map.get(charArray[index]) * value;
            index--;
            value *= 26;
        }
        return result;
    }
}
