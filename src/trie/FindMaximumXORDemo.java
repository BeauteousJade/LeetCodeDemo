package trie;

/**
 * 421. 数组中两个数的最大异或值
 * <p>
 * https://leetcode.cn/problems/maximum-xor-of-two-numbers-in-an-array/
 */
public class FindMaximumXORDemo {

    public static void main(String[] args) {

    }

    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        int res = 0; //因为nums全是非负数，异或一定大于等于0，最小取0
        for (int n : nums) {
            trie.insert(n); //加入
            res = Math.max(res, n ^ trie.find(n)); //边加入边异或，加入的数不全也没关系，因为最后一定会异或
        }
        return res;
    }


    private static class Trie {

        private final Trie[] children = new Trie[2];

        public void insert(int num) {
            Trie node = this;
            for (int i = 30; i >= 0; i--) {
                //因为是求最大的异或，所以从最高位开始检查，先存最高位
                int bit = num >> i & 1; //左移i位，在与1就是求第i为是1还是0
                if (node.children[bit] == null) {
                    node.children[bit] = new Trie(); //没有的话就创建一个
                }
                node = node.children[bit];
            }
        }

        /**
         * 贪心算法，要想找到最大的异或值，尽可能的从高位让bit位不一样。
         */
        public int find(int num) {
            Trie node = this;
            int target = 0;
            for (int i = 30; i >= 0; i--) {
                int bit = num >> i & 1;
                int targetBit = bit ^ 1;
                if (node.children[targetBit] != null) {
                    target = (target << 1) + targetBit;
                    node = node.children[targetBit];
                } else {
                    target = (target << 1) + bit;
                    node = node.children[bit];
                }
            }
            return target;
        }
    }
}
