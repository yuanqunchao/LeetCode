package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
662.二叉树最大宽度
 */
public class Solution662 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxWidth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int left = 0, right = 0;
            boolean findFirst = true;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    if (findFirst) {
                        left = i;
                        right = i;
                        findFirst = false;
                    } else {
                        right = i;
                    }
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    queue.offer(null);
                    queue.offer(null);
                }
            }
            if (findFirst) {
                break;
            }
            maxWidth = Math.max(maxWidth, right - left + 1);
        }
        return maxWidth;
    }
}
