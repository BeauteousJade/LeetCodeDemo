package other;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphicDemo {

    public static void main(String[] args) {
        IsIsomorphicDemo demo = new IsIsomorphicDemo();
        System.out.println(demo.isIsomorphic("abc", "adf"));
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] a = new int[s.length()];
        int[] b = new int[t.length()];
        char[] sArray = s.toCharArray();
        char[] chars = t.toCharArray();
        return true;
    }
}
