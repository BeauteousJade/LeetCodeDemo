package other;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 406. 根据身高重建队列
 * <p>
 * https://leetcode.cn/problems/queue-reconstruction-by-height/
 */
public class ReconstructQueueDemo {

    public static void main(String[] args) {
        ReconstructQueueDemo demo = new ReconstructQueueDemo();
        demo.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
    }

    public int[][] reconstructQueue(int[][] people) {
        // 按照高度从小到大排序，然后比它高的个数从大到小排序。
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person1[0] - person2[0];
                } else {
                    return person2[1] - person1[1];
                }
            }
        });
        int n = people.length;
        int[][] ans = new int[n][];
        for (int[] person : people) {
            int spaces = person[1] + 1;
            for (int i = 0; i < n; ++i) {
                // 如果不为null, 表示当前person的高度 > 第i 个Person的高度。那么直接跳过，因为第i 个Person不会算在>=当前person高度的count中。
                if (ans[i] == null) {
                    --spaces;
                    if (spaces == 0) {
                        ans[i] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }

}
