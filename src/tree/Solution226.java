package tree;

/*
226.翻转二叉树
 */
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    public void invert(TreeNode root) {
        if (root != null) {
            TreeNode tree = root.left;
            root.left = root.right;
            root.right = tree;
            invert(root.left);
            invert(root.right);
        }
    }
}
