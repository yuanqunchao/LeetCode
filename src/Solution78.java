import java.util.ArrayList;
import java.util.List;

/*
78.子集
 */
public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        ans.add(new ArrayList<>(list));
        dfs(nums, 0, list, ans);
        return ans;
    }

    public void dfs(int[] nums, int start, List<Integer> list, List<List<Integer>> ans) {
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            ans.add(new ArrayList<>(list));
            dfs(nums, i + 1, list, ans);
            list.remove(list.size() - 1);
        }
    }
}
