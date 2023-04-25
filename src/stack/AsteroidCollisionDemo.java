package stack;

import java.util.Stack;

/**
 * 735. 行星碰撞
 * <p>
 * https://leetcode.cn/problems/asteroid-collision/
 */
public class AsteroidCollisionDemo {

    public static void main(String[] args) {

    }

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            int res = asteroids[i];
            while (!stack.isEmpty() && stack.peek() > 0 && res < 0) {
                int pop = stack.pop();
                if (pop == -res) {
                    res = 0;
                } else {
                    res = Math.abs(res) > pop ? res : pop;
                }
            }
            if (res != 0) {
                stack.push(res);
            }
        }
        int[] res = new int[stack.size()];
        int index = 0;
        for (int value : stack) {
            res[index++] = value;
        }
        return res;
    }
}
