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
        int index1 = 0;
        int index2 = 0;
        while (index1 < strings1.length || index2 < strings2.length) {
            int a = index1 < strings1.length ? Integer.parseInt(strings1[index1++]) : 0;
            int b = index2 < strings2.length ? Integer.parseInt(strings2[index2++]) : 0;
            if (a < b) {
                return -1;
            } else if (a > b) {
                return 1;
            }
        }
        return 0;
    }
}
