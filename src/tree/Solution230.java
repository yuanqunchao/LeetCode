package tree;

import java.util.Stack;

/*
230.二叉搜索树中第k小的元素
 */
public class Solution230 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        int index = 0;
        while (!stack.isEmpty()) {
            node = stack.pop();
            index++;
            if (index == k) {
                return node.val;
            }
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return 0;
    }
}
