package tree;

import java.util.Stack;

public class InOrder {

    //中序遍历，递归方式，左 -> 根 -> 右
    public static void inOrderRecursively(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        if (root.left != null) {
            inOrderRecursively(root.left);
        }
        System.out.print(root.val + ", ");
        if (root.right != null) {
            inOrderRecursively(root.right);
        }
    }

    //中序遍历，非递归方式，左 -> 根 -> 右
    public static void inOrder(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode node = stack.pop();
            System.out.print(node.val + ", ");
            curr = node.right;
        }
    }


    public static void main(String[] args) {
        //创建二叉树节点
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(7);
        //生成二叉树
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        System.out.println("递归中序");
        inOrderRecursively(root);
        System.out.println();
        System.out.println("非递归中序");
        //非递归方式，先序遍历二叉树
        inOrder(root);
    }
}