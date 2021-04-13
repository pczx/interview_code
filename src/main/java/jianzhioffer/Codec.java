package jianzhioffer;

import java.util.Arrays;
import java.util.LinkedList;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(queue);
    }

    private TreeNode deserialize(LinkedList<String> queue) {
        String sVal = queue.poll();
        if ("#".equals(sVal))
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(sVal));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }
}
