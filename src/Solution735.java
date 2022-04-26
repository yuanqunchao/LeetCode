import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
735.行星碰撞
 */
public class Solution735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {  // 如果行星向右走，直接入栈
                stack.push(asteroid);
            } else if (asteroid < 0) {  // 如果向左走
                if (stack.isEmpty() || stack.peek() < 0) {  // 如果栈为空或者栈顶元素小于0，直接入栈
                    stack.push(asteroid);
                } else {
                    while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                        stack.pop();
                    }
                    // while循环结束说明，栈为空，或者栈顶小于0，或者栈顶元素绝对值大于等于当前行星
                    if (stack.isEmpty() || stack.peek() < 0) {
                        stack.push(asteroid);
                    } else if (stack.peek() == Math.abs(asteroid)) {
                        stack.pop();
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            return new int[0];
        } else {
            int[] ans = new int[stack.size()];
            for (int i = ans.length - 1; i >= 0; i--) {
                ans[i] = stack.pop();
            }
            return ans;
        }
    }
}
