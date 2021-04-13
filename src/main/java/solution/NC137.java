package solution;

import java.util.*;

public class NC137 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode buildTree(int[] xianxu, int[] zhongxu) {
        if (xianxu == null || xianxu.length == 0) return null;
        int val = xianxu[0], pos = 0, len = xianxu.length;
        TreeNode root = new TreeNode(val);
        for (; pos < len; pos++) {
            if (zhongxu[pos] == val) {
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(xianxu, 1, pos + 1), Arrays.copyOfRange(zhongxu, 0, pos));
        root.right = buildTree(Arrays.copyOfRange(xianxu, pos + 1, len), Arrays.copyOfRange(zhongxu, pos + 1, len));
        return root;
    }

    public int[] solve(int[] xianxu, int[] zhongxu) {
        // write code here
        ArrayList<Integer> ans = new ArrayList<>();
        TreeNode root = buildTree(xianxu, zhongxu);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode node = null;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            ans.add(node.val);
        }
        Arrays.stream(new Integer[]{1}).mapToInt(i -> i).toArray();
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }
}
