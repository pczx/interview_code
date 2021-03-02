package jianZhiOffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution37 {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return preOrder(queue);
    }

    private TreeNode preOrder(Queue<String> queue) {
        String s = queue.poll();
        if ("null".equals(s)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = preOrder(queue);
        node.right = preOrder(queue);
        return node;
    }
}
