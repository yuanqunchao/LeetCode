import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
76.最小覆盖子串
 */
public class Solution76 {
    Map<Character, Integer> sc = new HashMap<>();
    Map<Character, Integer> tc = new HashMap<>();

    public String minWindow(String s, String t) {
        for (int i = 0; i < t.length(); i++) {  // tc来记录字符串t中每一个字符出现的次数
            char c = t.charAt(i);
            tc.put(c, tc.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        while (right < s.length()) {
            // 第一次进来，right+1之后肯定还是满足right<s.length()
            right++;
            if (right < s.length() && tc.containsKey(s.charAt(right))) {
                sc.put(s.charAt(right), sc.getOrDefault(s.charAt(right), 0) + 1);
            }
            while (check()) {
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    ansL = left;
                    ansR = left + len;
                }
                if (tc.containsKey(s.charAt(left))) {
                    sc.put(s.charAt(left), sc.getOrDefault(s.charAt(left), 0) - 1);
                }
                left++;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        Iterator iterator = tc.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (sc.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }
}
