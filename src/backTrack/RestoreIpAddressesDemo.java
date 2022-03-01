package backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * <p>
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 */
public class RestoreIpAddressesDemo {

    public static void main(String[] args) {
        RestoreIpAddressesDemo demo = new RestoreIpAddressesDemo();
        System.out.println(demo.restoreIpAddresses("25525511135"));
    }

    private final List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backTrack(s, new ArrayList<>(), 0);
        return result;
    }

    private void backTrack(String string, List<String> list, int startIndex) {
        if (list.size() == 4) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                stringBuilder.append(list.get(i));
                if (i != list.size() - 1) {
                    stringBuilder.append(".");
                }
            }
            result.add(stringBuilder.toString());
        } else {
            for (int i = startIndex; i < string.length(); i++) {
                if (list.size() == 3 && i != string.length() - 1) {
                    continue;
                }
                String subString = string.substring(startIndex, i + 1);
                if (!check(subString)) {
                    continue;
                }
                list.add(subString);
                backTrack(string, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean check(String string) {
        if (string.length() == 1) {
            return true;
        }
        if (string.startsWith("0") || string.length() > 3) {
            return false;
        }
        return Integer.parseInt(string) <= 255;
    }
}
