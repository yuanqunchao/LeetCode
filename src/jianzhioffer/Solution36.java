package jianzhioffer;

import java.util.Stack;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {

    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution36 {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Stack<Node> stack = new Stack<>();
        Node preHead = new Node();
        preHead.left = preHead;
        preHead.right = preHead;
        Node pre = preHead;
        Node node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        while (!stack.isEmpty()) {
            node = stack.pop();
            Node right = node.right;
            node.left = pre;
            pre.right = node;
            node.right = preHead;
            preHead.left = node;
            pre = node;
            node = right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        pre.right = preHead.right;
        preHead.right.left = pre;
        return preHead.right;
    }
}
