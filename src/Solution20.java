import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
20.有效的括号
 */
public class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put(')', '(');
        map.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                if (map.containsKey(s.charAt(i))) {
                    return false;
                }
                stack.push(s.charAt(i));
            } else {
                if (map.containsKey(s.charAt(i)) && stack.peek() != map.get(s.charAt(i))) {
                    return false;
                } else if (map.containsKey(s.charAt(i))) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        return stack.isEmpty();
    }
}
