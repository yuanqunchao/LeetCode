/*
165.比较版本号
 */
public class Solution165 {
    public static int compareVersion(String version1, String version2) {
        String[] version1s = version1.split("\\.");
        String[] version2s = version2.split("\\.");
        for (int i = 0; i < version1s.length || i < version2s.length; i++) {
            int x = 0, y = 0;
            if (i < version1s.length) {
                x = Integer.parseInt(version1s[i]);
            }
            if (i < version2s.length) {
                y = Integer.parseInt(version2s[i]);
            }
            if (x > y) return 1;
            if (x < y) return -1;
        }
        return 0;
    }
}
