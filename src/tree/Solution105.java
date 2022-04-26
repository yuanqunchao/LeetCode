package tree;

/*
105.从前序与中序遍历序列构造二叉树
 */
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        if (l1 > r1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[l1]);
        // 在中序遍历中寻找根节点
        int k = l2;
        while (k <= r2) {
            if (inorder[k] == preorder[l1]) {
                break;
            }
            k++;
        }
        root.left = buildTree(preorder, l1 + 1, l1 + k - l2, inorder, l2, k - 1);
        root.right = buildTree(preorder, l1 + k - l2 + 1, r1, inorder, k + 1, r2);
        return root;
    }

}
