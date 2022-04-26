package tree;

/*
572.另一棵树的子树
 */
public class Solution572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    // 判断subRoot是否是root的子树
    public boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null) {  // 如果root为空，则肯定不是
            return false;
        }
        // check是检查root和subRoot是否一样
        // 如果root和subRoot一样，或者看root的左子树包不包含subRoot，或者右子树包不包含subRoot
        return check(root, subRoot) || dfs(root.left, subRoot) || dfs(root.right, subRoot);
    }

    public boolean check(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null) {
            return false;
        } else {
            return root.val == subRoot.val && check(root.left, subRoot.left) && check(root.right, subRoot.right);
        }
    }
}
