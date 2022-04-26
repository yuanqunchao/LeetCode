/*
28.实现strStr()
 */
public class Solution28 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        } else if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                String str = haystack.substring(i, i + needle.length());
                if (str.equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
