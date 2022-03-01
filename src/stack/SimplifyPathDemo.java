package stack;

import java.util.Stack;

/**
 * 简化路径
 */
public class SimplifyPathDemo {

    public static void main(String[] args) {
        SimplifyPathDemo demo = new SimplifyPathDemo();
        System.out.println(demo.simplifyPath("/../"));
    }

    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return null;
        }
        String[] array = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String string : array) {
            if (string.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!string.equals("") && !string.equals(".")) {
                stack.push(string);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (stack.isEmpty()) {
            stringBuilder.append("/");
        }
        while (!stack.isEmpty()) {
            stringBuilder.insert(0, stack.pop());
            stringBuilder.insert(0, "/");
        }
        return stringBuilder.toString();
    }
}
