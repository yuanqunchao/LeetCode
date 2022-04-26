package tree;

/*
129.求根节点到叶子节点的数字之和
 */
public class Solution129 {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, root.val);
        return sum;
    }

    public void dfs(TreeNode root, int num) {
        if (root.left == null && root.right == null) {  // 叶子节点
            sum += num;
        } else {
            if (root.left != null) {
                dfs(root.left, num * 10 + root.left.val);
            }
            if (root.right != null) {
                dfs(root.right, num * 10 + root.right.val);
            }
        }
    }


}
