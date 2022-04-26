import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
46.全排列
 */
public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        // Arrays.sort(nums);  // 加上可以使输出的全排列按字典序排序
        for (int num : nums) {
            list.add(num);
        }
        backTrack(ans, list, 0);
        return ans;
    }

    public void backTrack(List<List<Integer>> ans, List<Integer> list, int index) {
        if (index == list.size()) {
            ans.add(new ArrayList<>(list));
        }

        for (int i = index; i < list.size(); i++) {
            Collections.swap(list, index, i);
            backTrack(ans, list, index + 1);
            Collections.swap(list, index, i);
        }
    }
}
