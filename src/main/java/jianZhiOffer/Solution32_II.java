package jianZhiOffer;

import java.util.*;

class Solution32_II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> level = new ArrayList<>();
        queue.offer(root);
        int nextLevel = 0;
        int toBePrinted = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            level.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
                nextLevel++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextLevel++;
            }
            toBePrinted--;
            if (toBePrinted == 0) {
                toBePrinted = nextLevel;
                nextLevel = 0;
                ans.add(level);
                level = new ArrayList<>();
            }
        }
        return ans;
    }
}