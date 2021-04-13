package jianzhioffer;

import java.util.*;

public class Solution32_III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                if (ans.size() % 2 == 0) {
                    level.addLast(node.val);
                } else {
                    level.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}
