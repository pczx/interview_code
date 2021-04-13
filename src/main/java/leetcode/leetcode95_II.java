package leetcode;

import java.util.LinkedList;
import java.util.List;

public class leetcode95_II {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        LinkedList<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = generateTrees(start, i - 1);
            List<TreeNode> rightTree = generateTrees(i + 1, end);
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode curNode = new TreeNode(i);
                    curNode.left = left;
                    curNode.right = right;
                    allTrees.add(curNode);
                }
            }
        }
        return allTrees;
    }
    
}
