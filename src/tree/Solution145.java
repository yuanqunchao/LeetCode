package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
145.二叉树的后序遍历
 */
public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;  // 初始前一个节点为null
        // 当root不为空或者栈不为空，进入循环
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果右子树为null或者右子树遍历过了
            if (root.right == null || root.right == prev) {
                ans.add(root.val);
                prev = root;
                root = null;  // 下一次需要重新弹出
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return ans;
    }
}
