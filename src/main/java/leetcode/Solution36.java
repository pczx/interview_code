package leetcode;

import leetcode.node.Node;

public class Solution36 {

    private Node lastNode;

    public Node treeToDoublyList(Node root) {
        treeToDoublyListCore(root);
        Node head = lastNode;
        while (head != null && head.left != null) {
            head = head.left;
        }
        if (head != null) {
            head.left = lastNode;
            lastNode.right = head;
        }
        return head;
    }

    private void treeToDoublyListCore(Node root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            treeToDoublyListCore(root.left);
        }

        root.left = lastNode;
        if (lastNode != null) {
            lastNode.right = root;
        }
        lastNode = root;

        if (root.right != null) {
            treeToDoublyListCore(root.right);
        }
    }
}
