import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
47.全排列Ⅱ
 */
public class Solution47 {
    int[] seen;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        seen = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        backTrack(ans, list, 0, nums);
        return ans;
    }

    public void backTrack(List<List<Integer>> ans, List<Integer> list, int index, int[] nums) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (seen[i] == 1 || (i > 0 && nums[i] == nums[i - 1] && seen[i - 1] == 0)) {
                continue;
            }
            seen[i] = 1;
            list.add(nums[i]);
            backTrack(ans, list, index + 1, nums);
            seen[i] = 0;
            list.remove(list.size() - 1);
        }
    }
}
