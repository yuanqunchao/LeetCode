package tree;

import java.util.ArrayList;
import java.util.List;

/*
113.路径总和Ⅱ
 */
public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(root, targetSum, list, ans);
        return ans;
    }

    public void dfs(TreeNode root, int targetSum, List<Integer> list, List<List<Integer>> ans) {
        if (root != null) {  // root不为null才执行
            list.add(root.val);
            targetSum -= root.val;
            if (root.left == null && root.right == null && targetSum == 0) {
                ans.add(new ArrayList<>(list));
            } else {
                dfs(root.left, targetSum, list, ans);
                dfs(root.right, targetSum, list, ans);
            }
            list.remove(list.size() - 1);
        }
    }
}
