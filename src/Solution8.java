import java.util.*;

/*
8.字符串转整数
 */
public class Solution8 {
    class Auto {
        long ans = 0;
        String state = "start";
        int sign = 1;
        Map<String, String[]> map = new HashMap<>();

        Auto() {
            map.put("start", new String[]{"start", "sign", "in_number", "end"});
            map.put("sign", new String[]{"end", "end", "in_number", "end"});
            map.put("in_number", new String[]{"end", "end", "in_number", "end"});
            map.put("end", new String[]{"end", "end", "end", "end"});
        }

        public void get(char c) {
            state = map.get(state)[getCol(c)];  // 进行状态变化
            if (state.equals("sign")) {
                sign = c == '+' ? 1 : -1;
            } else if (state.equals("in_number")) {
                ans = ans * 10 + c - '0';
                // 截断
                ans = sign == 1 ? Math.min((long) Integer.MAX_VALUE, ans) : Math.min(-(long) Integer.MIN_VALUE, ans);
            }
        }


        public int getCol(char c) {
            if (c == ' ') {
                return 0;
            } else if (c == '+' || c == '-') {
                return 1;
            } else if (Character.isDigit(c)) {
                return 2;
            } else {
                return 3;
            }
        }
    }

    public int myAtoi(String str) {
        Auto auto = new Auto();
        for (int i = 0; i < str.length(); i++) {
            auto.get(str.charAt(i));
        }
        return (int) (auto.sign * auto.ans);
    }
}