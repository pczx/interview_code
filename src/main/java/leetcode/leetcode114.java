package leetcode;

public class leetcode114 {


    public void flatten(TreeNode root) {
        preOrder(root);
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        root.left = null;
        TreeNode right = root.right;

        preOrder(left);

    }
}
