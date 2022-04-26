package tree;

/*
124.二叉树中的最大路径和
 */
public class Solution124 {
    int maxPath = Integer.MIN_VALUE;  // 最大路径和

    public int maxPathSum(TreeNode root) {
        pathGain(root);
        return maxPath;
    }

    public int pathGain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左右子树的贡献值可能为负数，如果为负数的话还不如不经过该子树
        int leftGain = pathGain(root.left);
        int rightGain = pathGain(root.right);
        leftGain = Math.max(leftGain, 0);
        rightGain = Math.max(rightGain, 0);
        // 判断是否是最大路径和
        maxPath = Math.max(maxPath, leftGain + rightGain + root.val);
        // 返回当前数的贡献值
        return Math.max(leftGain, rightGain) + root.val;
    }

}
