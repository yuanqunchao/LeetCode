/*
32.最长有效括号
 */
public class Solution32 {
    public int longestValidParentheses(String s) {
        int longest = 0;
        int[] dp = new int[s.length()];
        // 以第一个括号结尾的子串有效长度为0
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1] - 2) >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
                longest = Math.max(longest, dp[i]);
            }
        }
        return longest;
    }
}
