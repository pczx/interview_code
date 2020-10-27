package leetcode;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

class Solution36 {
    private Node lastNode;

    public Node treeToDoublyList(Node root) {
        treeToDoublyListCore(root);

        Node head = lastNode;
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }

    private void treeToDoublyListCore(Node node) {
        if (node == null) {
            return;
        }

        Node currentNode = node;

        if (currentNode.left != null) {
            treeToDoublyList(currentNode.left);
        }

        currentNode.left = lastNode;
        if (lastNode != null) {
            lastNode.right = currentNode;
        }
        lastNode = currentNode;

        if (currentNode.right != null) {
            treeToDoublyList(currentNode.right);
        }
    }
}