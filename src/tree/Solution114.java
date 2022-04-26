package tree;

import java.util.Stack;

/*
114.二叉树展开为链表
 */
public class Solution114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode preHead = new TreeNode();
        TreeNode pre = preHead;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            pre.right = node;
            pre = pre.right;
            if (node.right != null) {
                stack.push(node.right);
                node.right = null;
            }
            if (node.left != null) {
                stack.push(node.left);
                node.left = null;
            }
        }
    }
}
