import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
139.单词拆分
 */
public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] find = new boolean[s.length() + 1];
        find[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (find[j] == true && set.contains(s.substring(j, i))) {
                    find[i] = true;
                    break;
                }
            }
        }
        return find[s.length()];
    }

}
