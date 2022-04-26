package tree;

/*
235.二叉树的最近公共祖先
 */
public class Solution236 {
    // 定义返回的最近公共祖先
    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        if (left && right || (left || right) && (root.val == p.val || root.val == q.val)) {
            ans = root;
        }
        return left || right || root.val == p.val || root.val == q.val;
    }


}
