package tree;

import java.util.Stack;

public class PostOrder {

    //先序遍历，递归方式，左 -> 右 -> 根
    public static void postOrderRecursively(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        if (root.left != null) {
            postOrderRecursively(root.left);
        }
        if (root.right != null) {
            postOrderRecursively(root.right);
        }
        System.out.print(root.val + ", ");
    }

    //先序遍历，非递归方式，左 -> 右 -> 根
    public static void postOrder(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode prev = null;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode node = stack.peek();
            //如果右子树已经遍历过或者右子树为空，直接遍历该节点
            if (prev == node.right || node.right == null) {
                System.out.print(node.val + ", ");
                stack.pop();
                prev = node;
            } else {
                // 右子树没有遍历过，遍历右子树
                curr = node.right;
            }
        }
    }

    //先序遍历，非递归方式
    //使用两个栈，一个压入的顺序是先左后右，从第一个栈弹出再压入第二个栈的时候就是先右后左了，并且此时根节点最先压入，打印的时候就会是左、右、根了。
    public static void postOrder2(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            TreeNode node = stack2.pop();
            System.out.print(node.val + ", ");
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
        System.out.println("递归后序");
        postOrderRecursively(root);
        System.out.println();
        System.out.println("非递归后序");
        postOrder(root);
        System.out.println();
        System.out.println("非递归后序双栈法");
        postOrder2(root);
    }
}