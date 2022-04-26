import java.util.*;

/*
43.字符串相乘
 */
public class Solution43 {
    public String multiply(String num1, String num2) {
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
            return "0";
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = num2.length() - 1; i >= 0; i--) {
            Deque<Integer> deque = new LinkedList<>();
            int r = 0;
            int y = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int mul = x * y + r;
                deque.offerFirst(mul % 10);
                r = mul / 10;
            }
            if (r > 0) {
                deque.offerFirst(r);
            }
            for (int k = 0; k < num2.length() - i - 1; k++) {
                deque.offerLast(0);
            }
            list.add(new ArrayList<>(deque));
        }
        for (int i = 0; i < list.size(); i++) {
            Collections.reverse(list.get(i));
        }
        List<Integer> ans = new ArrayList<>();
        int len = list.get(list.size() - 1).size();
        int r = 0;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = 0; j < list.size(); j++) {
                int add = i < list.get(j).size() ? list.get(j).get(i) : 0;
                sum += add;
            }
            sum += r;
            ans.add(sum % 10);
            r = sum / 10;
        }
        if (r > 0) {
            ans.add(r);
        }
        Collections.reverse(ans);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < ans.size(); i++) {
            stringBuilder.append(ans.get(i));
        }
        return stringBuilder.toString();
    }
}
