import java.util.ArrayList;
import java.util.List;

/*
93.复原IP地址
 */
public class Solution93 {
    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<>();
    int[] segments = new int[SEG_COUNT];  // 存放每一段ip

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0);
        return ans;
    }

    public void dfs(String s, int segId, int segStart) {
        // 如果找到了4段IP地址，并且遍历完了字符串，那么就是正确答案
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuilder ip = new StringBuilder();
                for (int i = 0; i < SEG_COUNT; i++) {
                    ip.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ip.append('.');
                    }
                }
                ans.add(ip.toString());
            }
            return;
        }
        // 如果还没有找到4段ip就已经遍历完了字符串，提前回溯
        if (segStart == s.length()) {
            return;
        }
        // 如果这一位为0的话，只能将这一位当做一段ip地址
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 255) {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }
}
