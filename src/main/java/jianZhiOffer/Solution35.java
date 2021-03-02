package jianZhiOffer;

class Solution35 {
    public Node copyRandomList(Node root) {
        cloneNodes(root);
        connectRandomNodes(root);
        return reconnectNode(root);
    }

    private void cloneNodes(Node root) {
        Node node = root;
        while (node != null) {
            Node cloned = new Node(node.val);
            cloned.next = node.next;
            node.next = cloned;
            node = cloned.next;
        }
    }

    private void connectRandomNodes(Node root) {
        Node node = root;
        while (node != null) {
            Node cloned = node.next;
            if (node.random != null) {
                cloned.random = node.random.next;
            }
            node = cloned.next;
        }
    }

    private Node reconnectNode(Node root) {
        Node node = root;
        Node clonedHead = null;
        Node cloned = null;
        if (node != null) {
            clonedHead = cloned = node.next;
            node.next = cloned.next;
            node = node.next;
        }

        while (node != null) {
            cloned.next = node.next;
            cloned = cloned.next;
            node.next = cloned.next;
            node = node.next;
        }

        return clonedHead;
    }
}
