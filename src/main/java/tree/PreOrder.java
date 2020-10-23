package tree;

import java.util.Stack;

public class PreOrder {

    //先序遍历，递归方式，根 -> 左 -> 右
    public static void preOrderRecursively(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        System.out.print(root.val + ", ");
        if (root.left != null) {
            preOrderRecursively(root.left);
        }
        if (root.right != null) {
            preOrderRecursively(root.right);
        }
    }

    //先序遍历，非递归方式，根 -> 左 -> 右
    public static void preOrder(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + ", ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
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
        System.out.println("递归前序");
        preOrderRecursively(root);
        System.out.println();
        System.out.println("非递归前序");
        //非递归方式，先序遍历二叉树
        preOrder(root);
    }
}