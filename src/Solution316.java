import java.util.*;

/*
316.去除重复字母
 */
public class Solution316 {
    public String removeDuplicateLetters(String s) {
        boolean[] vis = new boolean[26];
        int[] num = new int[26];
        // 记录每一个字符出现的次数
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!vis[c - 'a']) {  // 如果还没遇见过这个字符
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c) {
                    // 如果前一个字符比当前字符大，且后面还有前一个字符
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                vis[c - 'a'] = true;
                sb.append(c);
            }
            // 如果没有遇见过这个字符，会执行完上面的内容之后，再-1，如果遇见过了，就直接-1
            num[c - 'a'] -= 1;
        }
        return sb.toString();
    }

}
