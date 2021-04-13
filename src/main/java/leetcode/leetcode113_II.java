package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode113_II {

    private List<List<Integer>> paths = new ArrayList<>();

    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return paths;
    }

    public void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        targetSum -= root.val;
        path.add(root.val);
        if (root.left == null && root.right == null && targetSum == 0) {
            paths.add(new ArrayList<>(path));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path.remove(path.size() - 1);
    }
}
