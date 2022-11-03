package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 311. 稀疏矩阵的乘法
 * <p>
 * https://leetcode.cn/problems/sparse-matrix-multiplication/
 */
public class MultiplyDemo {

    public static void main(String[] args) {

        MultiplyDemo demo = new MultiplyDemo();
        int[][] mat1 = {{1, 0, 0}, {-1, 0, 3}}, mat2 = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};
        int[][] res = demo.multiply(mat1, mat2);
        for (int[] array : res) {
            System.out.println(Arrays.toString(array));
        }

    }

    /**
     * 1. 什么是稀疏矩阵？
     * 在矩阵中，若数值为0的元素数目远远多于非0元素的数目，并且非0元素分布没有规律时，则称该矩阵为稀疏矩阵
     * <p>
     * 2. 稀疏矩阵可以用三元组存储 （行标， 列标， 值）
     * 因为矩阵的乘法是第一个矩阵的行和第二个矩阵的列相乘，所以我们建立两个哈希表分别存储第一个矩阵的值和第二个矩阵的值。
     * 并且这个哈希表是一个嵌套的格式
     * 矩阵1的哈希表格式Map<行标, Map<列标，值>>
     * 矩阵2的哈希表格式Map<列标, Map<行标，值>>
     */
    public int[][] multiply(int[][] mat1, int[][] mat2) {

        Map<Integer, Map<Integer, Integer>> map1 = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> map2 = new HashMap<>();

        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[0].length; j++) {
                Map<Integer, Integer> integerMap = map1.computeIfAbsent(i, k -> new HashMap<>());
                integerMap.put(j, mat1[i][j]);
            }
        }

        for (int i = 0; i < mat2.length; i++) {
            for (int j = 0; j < mat2[0].length; j++) {
                Map<Integer, Integer> integerMap = map2.computeIfAbsent(j, k -> new HashMap<>());
                integerMap.put(i, mat2[i][j]);
            }
        }

        int[][] res = new int[mat1.length][mat2[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                Map<Integer, Integer> rowMap = map1.get(i);
                Map<Integer, Integer> colMap = map2.get(j);
                for (int index : rowMap.keySet()) {
                    if (colMap != null && colMap.containsKey(index)) {
                        res[i][j] += rowMap.get(index) * colMap.get(index);
                    }
                }
            }
        }

        return res;

    }
}
