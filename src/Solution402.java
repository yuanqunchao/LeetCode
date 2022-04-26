import java.util.Deque;
import java.util.LinkedList;

/*
402.移掉K位数字
 */
public class Solution402 {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        int length = num.length();
        for (int i = 0; i < length; i++) {
            char digit = num.charAt(i);
            // 如果队列不空，且还能删除元素，且前一个比当前大，就删除
            while (!deque.isEmpty() && digit < deque.peekLast() && k > 0) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }
        // 如果还能删除
        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }
        StringBuilder ans = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ans.append(digit);
        }
        return ans.length() == 0 ? "0" : ans.toString();
    }
}
