package leetcode;

class Solution54 {
    int count = 0;
    TreeNode node;
    public int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return node.val;
    }

    public void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        // 右 -> 根 -> 左
        dfs(root.right, k);
        if (++count == k) {
            node = root;
        }
        dfs(root.left, k);
    }
}