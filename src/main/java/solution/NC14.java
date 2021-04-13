package solution;

import jianzhioffer.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class NC14 {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> rows = new ArrayList<>();
        if (root == null) {
            return rows;
        }
        LinkedList<TreeNode> q = new LinkedList<TreeNode>() {{
            add(root);
        }};
        boolean flag = false;
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> row = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                row.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            if (flag) {
                Collections.reverse(row);
            }
            flag = !flag;
            rows.add(row);
        }
        return rows;
    }
}
