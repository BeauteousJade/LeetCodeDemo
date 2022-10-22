package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 293. 翻转游戏
 * <p>
 * https://leetcode.cn/problems/flip-game/
 */
public class GeneratePossibleNextMovesDemo {

    public static void main(String[] args) {
        GeneratePossibleNextMovesDemo demo = new GeneratePossibleNextMovesDemo();
        System.out.println(demo.generatePossibleNextMoves("++++"));
    }

    public List<String> generatePossibleNextMoves(String currentState) {

        List<String> list = new ArrayList<>();
        if (currentState.length() <= 1) {
            return list;
        }
        char[] array = currentState.toCharArray();
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == '+' && array[i + 1] == '+') {
                array[i] = '-';
                array[i + 1] = '-';
                list.add(new String(array));
                array[i] = '+';
                array[i + 1] = '+';
            }
        }

        return list;
    }


}
