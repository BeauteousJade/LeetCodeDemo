package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1487. 保证文件名唯一
 * <p>
 * https://leetcode.cn/problems/making-file-names-unique/
 */
public class GetFolderNamesDemo {

    public static void main(String[] args) {
        GetFolderNamesDemo demo = new GetFolderNamesDemo();
        String[] string = {"kaido", "kaido(1)", "kaido", "kaido(1)"};
        System.out.println(Arrays.toString(demo.getFolderNames(string)));
    }

    public String[] getFolderNames(String[] names) {
        String[] res = new String[names.length];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            if (!map.containsKey(names[i])) {
                res[i] = names[i];
                map.put(names[i], 1);
            } else {
                int count = map.get(names[i]);
                String name = null;
                boolean isFlag = true;
                while (isFlag) {
                    name = names[i] + "(" + count + ")";
                    isFlag = map.containsKey(name);
                    count++;
                }
                res[i] = name;
                map.put(name, 1);
                map.put(names[i], count - 1);
            }
        }
        return res;
    }
}
