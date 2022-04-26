import java.util.ArrayList;
import java.util.List;

/*
22.括号生成
 */
public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(n, n, "", ans);
        return ans;
    }

    public void generate(int left, int right, String s, List<String> ans) {
        if (left == 0 && right == 0) {
            ans.add(s);
        } else if (left == right) {
            generate(left - 1, right, s + "(", ans);
        } else if (left < right) {
            if (left > 0) {
                generate(left - 1, right, s + "(", ans);
            }
            generate(left, right - 1, s + ")", ans);
        }
    }
}
