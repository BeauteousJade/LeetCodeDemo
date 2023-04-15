package other;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * <p>
 * https://leetcode.cn/problems/pascals-triangle-ii/
 */
public class GetRowDemo {

    public static void main(String[] args) {

    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i < rowIndex; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = list;
        }
        return pre;
    }
}
