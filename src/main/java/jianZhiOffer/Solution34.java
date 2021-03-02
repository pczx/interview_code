package jianZhiOffer;

import java.util.ArrayList;
import java.util.List;

class Solution34 {

    private List<List<Integer>> paths = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return paths;
        }
        int currentSum = 0;
        pathSum(root, sum, currentSum);
        return paths;
    }

    private void pathSum(TreeNode root, int expectedSum, int currentSum) {
        currentSum += root.val;
        path.add(root.val);
        boolean isLeaf = root.left == null && root.right == null;
        if (currentSum == expectedSum && isLeaf) {
            paths.add(new ArrayList<>(path));
        }

        if (root.left != null) {
            pathSum(root.left, expectedSum, currentSum);
        }

        if (root.right != null) {
            pathSum(root.right, expectedSum, currentSum);
        }

        path.remove(path.size() - 1);
    }
}
