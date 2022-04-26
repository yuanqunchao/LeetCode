/*
5.最长回文子串
 */
public class Solution5 {
    String ans = "";

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            int left = i, right = i;
            while (right + 1 < s.length() && s.charAt(right) == s.charAt(right + 1)) {
                right++;
            }
            expand(s, left, right);
        }
        return ans;
    }

    public void expand(String s, int left, int right) {
        while (left > 0 && right < s.length() - 1) {
            if (s.charAt(left - 1) == s.charAt(right + 1)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        if (right - left + 1 > ans.length()) {
            ans = s.substring(left, right + 1);
        }
    }
}