package jianzhioffer;

class Solution26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean result = false;

        if (A != null && B != null) {
            if (A.val == B.val) {
                result = doesTree1HasTree2(A, B);
            }
            if (!result) {
                result = isSubStructure(A.left, B);
            }
            if (!result) {
                result = isSubStructure(A.right, B);
            }
        }
        return result;
    }

    private boolean doesTree1HasTree2(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a != null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        return doesTree1HasTree2(a.left, b.left) && doesTree1HasTree2(a.right, b.right);
    }

}