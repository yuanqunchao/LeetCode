package tree;

/*
110.平衡二叉树
 */
public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        // 求root的高度，如果能正常求出高度，那就说明中间没有被截断，就说明是平衡二叉树
        return height(root) >= 0;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = height(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
