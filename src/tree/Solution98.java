package tree;

/*
98.验证二叉搜索树
 */
public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean valid(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        return root.val < max && root.val > min && valid(root.left, min, root.val) && valid(root.right, root.val, max);
    }


}
