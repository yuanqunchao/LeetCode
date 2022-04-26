package tree;

import java.util.*;

/*
剑指Offer32.从上到下打印二叉树Ⅲ
 */
public class Solution32 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean left = true;
        while (!queue.isEmpty()) {
            Deque<Integer> deque = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (left) {
                    deque.offerLast(node.val);
                } else {
                    deque.offerFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            left = !left;
            ans.add(new ArrayList<>(deque));
        }
        return ans;
    }
}
