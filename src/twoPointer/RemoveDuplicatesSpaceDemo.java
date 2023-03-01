package twoPointer;

/**
 * 移除字符串中的多余空格。
 */
public class RemoveDuplicatesSpaceDemo {

    public static void main(String[] args) {
        RemoveDuplicatesSpaceDemo demo = new RemoveDuplicatesSpaceDemo();
        System.out.println(demo.test("    aa  bb cc    dd    "));
        System.out.println(demo.test("       "));
    }


    private String test(String string) {
        int fastIndex = 0;
        int slowIndex = 0;
        char[] array = string.toCharArray();
        while (fastIndex < array.length) {
            if (array[fastIndex] != ' ' || (fastIndex > 0 && array[fastIndex] == ' ' && array[fastIndex - 1] != ' ')) {
                array[slowIndex++] = array[fastIndex];
            }
            fastIndex++;
        }
        // 最后可能会有空格尾巴，所以需要回退。
        while (slowIndex > 0 && array[slowIndex - 1] == ' ') {
            slowIndex--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < slowIndex; i++) {
            stringBuilder.append(array[i]);
        }
        return stringBuilder.toString();

    }

}
