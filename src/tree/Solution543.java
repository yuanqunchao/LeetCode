package tree;

/*
543.二叉树的直径
 */
public class Solution543 {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        pathGain(root);
        return diameter;
    }

    public int pathGain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftPath = pathGain(root.left);
        int rightPath = pathGain(root.right);
        diameter = Math.max(diameter, leftPath + rightPath);
        return Math.max(leftPath, rightPath) + 1;
    }
}
