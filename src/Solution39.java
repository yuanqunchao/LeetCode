import java.util.ArrayList;
import java.util.List;

/*
39.组合总和
 */
public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(candidates, target, 0, list, ans);
        return ans;
    }

    public void dfs(int[] candidates, int target, int start, List<Integer> list, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (target >= candidates[i]) {
                    list.add(candidates[i]);
                    dfs(candidates, target - candidates[i], i, list, ans);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

}
