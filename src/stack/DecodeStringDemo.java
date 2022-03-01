package stack;

import java.util.Stack;

/**
 * 394. 字符串解码
 * <p>
 * https://leetcode-cn.com/problems/decode-string/
 */
public class DecodeStringDemo {

    public static void main(String[] args) {
        DecodeStringDemo demo = new DecodeStringDemo();
        System.out.println(demo.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }

    /**
     * 数字存放在数字栈，字符串存放在字符串栈，遇到右括号时候弹出一个数字栈，字母栈弹到左括号为止。就是逆波兰式那种题。
     */
    public String decodeString(String s) {
        //数字栈
        Stack<Integer> digStack = new Stack<>();
        //字符串栈
        Stack<String> stringStack = new Stack<>();
        //当前正在累积的字符串
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (isDig(c)) { //遇到数字
                int num = c - '0';
                char newC = charArray[++i];
                // 计算数字。
                while (isDig(newC)) {
                    num = num * 10 + (newC - '0');
                    newC = charArray[++i];
                }
                digStack.push(num);
                i--;
            } else if (c == '[') { //遇到左括号
                //将当前累积的字符串入栈
                stringStack.push(stringBuilder.toString());
                //开始记录新的一段字符串
                stringBuilder.delete(0, stringBuilder.length());
            } else if (c == ']') {//遇到右括号
                int count = digStack.pop();
                StringBuilder newStringBuilder = new StringBuilder();
                //将当前字符串按数字栈栈顶元素为倍数进行扩展
                for (int j = 0; j < count; j++) {
                    newStringBuilder.append(stringBuilder);
                }
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append(newStringBuilder);
                if (!stringStack.isEmpty()) {
                    //字符串栈栈顶元素弹出来并与当前字符串拼接，作为新的当前正在累积的字符串
                    stringBuilder.insert(0, stringStack.pop());
                }
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    private boolean isDig(char c) {
        return c >= '0' && c <= '9';
    }
}
