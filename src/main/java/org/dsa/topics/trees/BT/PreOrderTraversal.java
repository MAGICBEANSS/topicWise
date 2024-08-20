package org.dsa.topics.trees.BT;

import java.util.Objects;

import static java.lang.System.*;

public class PreOrderTraversal {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(16);
        TreeNode node5 = new TreeNode(11);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(25);
        TreeNode node8 = new TreeNode(23);
        TreeNode node9 = new TreeNode(12);
        node1.left = node2;
        node1.right = node3;
        node2.left=node4;
        node4.left=node7;
        node4.right=node8;
        node3.left = node5;
        node3.right = node6;
        node5.right = node9;
        inorder(node1);

    }

    private static void inorder(TreeNode node) {
        if(Objects.isNull(node)) return;
        out.print(node.val+",");
        inorder(node.left);
        inorder(node.right);
    }
}
