package other;

/**
 * 165. 比较版本号
 * <p>
 * https://leetcode-cn.com/problems/compare-version-numbers/
 */
public class CompareVersionDemo {

    public static void main(String[] args) {
        CompareVersionDemo demo = new CompareVersionDemo();
        System.out.println(demo.compareVersion("0.1", "0.0"));
    }

    public int compareVersion(String version1, String version2) {
        String[] strings1 = version1.split("\\.");
        String[] strings2 = version2.split("\\.");
        int count = Math.min(strings1.length, strings2.length);
        for (int i = 0; i < count; i++) {
            int value1 = Integer.parseInt(strings1[i]);
            int value2 = Integer.parseInt(strings2[i]);
            if (value1 > value2) {
                return 1;
            } else if (value1 < value2) {
                return -1;
            }
        }

        int index = count;
        while (index < strings1.length) {
            int value1 = Integer.parseInt(strings1[index]);
            if (value1 != 0) {
                return 1;
            }
            index++;
        }
        while (index < strings2.length) {
            int value2 = Integer.parseInt(strings2[index]);
            if (value2 != 0) {
                return -1;
            }
            index++;
        }
        return 0;
    }
}
