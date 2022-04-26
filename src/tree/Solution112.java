package tree;

/*
112.路径总和
 */
public class Solution112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum);
    }

    public boolean dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        } else {
            if (root.left == null && root.right == null) {
                return root.val == targetSum;
            } else {
                return dfs(root.left, targetSum - root.val) || dfs(root.right, targetSum - root.val);
            }
        }
    }

}
