package tree;

/**
 * 536. 从字符串生成二叉树
 * <p>
 * https://leetcode.cn/problems/construct-binary-tree-from-string/?favorite=qg88wci
 */
public class Str2TreeDemo {


    public static void main(String[] args) {
        Str2TreeDemo demo = new Str2TreeDemo();
        System.out.println(TreeUtils.levelOrder(demo.str2tree("4(2(3)(1))(6(5))")));

        System.out.println(TreeUtils.levelOrder(demo.str2tree("-4(-2(-3)(1))(6(5)(-7))")));

    }


    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0 || s.equals("()")) {
            return null;
        }
//        System.out.println(s);
        int rootEndIndex = s.length();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                rootEndIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(Integer.parseInt(s.substring(0, rootEndIndex)));
        if (rootEndIndex != s.length()) {
            int leftCount = 0;
            int index = 0;
            for (int i = rootEndIndex; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    leftCount++;
                } else if (c == ')') {
                    leftCount--;
                    if (leftCount <= 0) {
                        index = i;
                        break;
                    }
                }
            }

            String leftString = rootEndIndex + 1 <= index ? s.substring(rootEndIndex + 1, index) : "";
            String rightString = (!leftString.equals("")) && index + 2 <= s.length() - 1 ? s.substring(index + 2, s.length() - 1) : "";

//            System.out.println("s = " + s + " left = " + leftString + " right = " + rightString);
            root.left = str2tree(leftString);
            root.right = str2tree(rightString);
        }
        return root;
    }
}
