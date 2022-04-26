/*
14.最长公共前缀
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        String cp = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String current = strs[i];
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < cp.length() && j < current.length(); j++) {
                if (cp.charAt(j) == current.charAt(j)) {
                    stringBuilder.append(cp.charAt(j));
                } else {
                    break;
                }
            }
            cp = stringBuilder.toString();
            if (cp.length() == 0) {
                break;
            }
        }
        return cp;
    }
}
