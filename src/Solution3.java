import java.util.HashSet;
import java.util.Set;

/*
3.无重复字符的最长子串
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int left = 0, right = -1;
        int longest = 0;
        while (right < s.length()) {
            // 如果还有下一个字符并且下一个字符不重复
            while (right + 1 < s.length() && !set.contains(s.charAt(right + 1))) {
                right++;
                set.add(s.charAt(right));
            }
            longest = Math.max(longest, right - left + 1);
            if (right == s.length() - 1) {
                return longest;
            }
            set.remove(s.charAt(left++));
        }
        return longest;
    }
}
