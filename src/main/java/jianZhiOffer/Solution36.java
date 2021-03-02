package jianZhiOffer;

import jianZhiOffer.node.Node;

import java.util.Stack;

public class Solution36 {
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Stack<Node> stack = new Stack<Node>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            Node cur = stack.pop();
            if (pre == null) {
                head = cur;
            } else {
                pre.right = cur;
            }
            cur.left = pre;
            pre = cur;
            root = cur.right;
        }

        pre.right = head;
        head.left = pre;
        return head;
    }
}
