package other;

/**
 * 168. Excel表列名称
 * <p>
 * 进制转换。
 * <p>
 * https://leetcode-cn.com/problems/excel-sheet-column-title/
 */
public class ConvertToTitleDemo {

    public static void main(String[] args) {
        ConvertToTitleDemo demo = new ConvertToTitleDemo();
        System.out.println(demo.convertToTitle(26));
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        while (columnNumber > 0) {
            // 1 到 26
            // 如果是columnNumber % 26 那就是0 到 25。
            int a = (columnNumber - 1) % 26 + 1;
            stringBuilder.append((char) (a - 1 + 'A'));
            columnNumber = (columnNumber - a) / 26;
        }

        return stringBuilder.reverse().toString();
    }
}
