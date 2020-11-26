package leetcode;

class Solution54 {

    private int k;

    private int res;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        kthLargestCore(root);
        return res;
    }

    private void kthLargestCore(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.right != null) {
            kthLargestCore(root.right);
        }


        if (k == 0) {
            return;
        }

        if (--k == 0) {
            res = root.val;
        }


        if (root.left != null) {
            kthLargestCore(root.left);
        }
    }
}