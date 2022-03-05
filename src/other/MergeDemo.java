package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * https://leetcode-cn.com/problems/merge-intervals/
 */
public class MergeDemo {

    public static void main(String[] args) {
        MergeDemo demo = new MergeDemo();
        int[][] array = new int[][]{{1, 4}, {0, 4}};
        int[][] merge = demo.merge(array);
        System.out.println();
        for (int[] a : merge) {
            System.out.println(Arrays.toString(a));
        }
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        list.addAll(Arrays.asList(intervals));
        list.sort((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        List<int[]> resultList = new ArrayList<>();
        resultList.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            int[] current = list.get(i);
            int[] pre = resultList.get(resultList.size() - 1);
            if (current[0] <= pre[1] && pre[1] <= current[1]) {
                pre[1] = current[1];
            } else if (current[0] > pre[1]) {
                int[] newArray = new int[2];
                newArray[0] = current[0];
                newArray[1] = current[1];
                resultList.add(newArray);
            }
        }
        return resultList.toArray(new int[resultList.size()][]);
    }
}
