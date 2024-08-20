package org.dsa.topics.trees.BT;

import org.dsa.topics.trees.BT.utils.TreeUtils;

public class CheckForBalancedBinaryTree {

    //https://leetcode.com/problems/balanced-binary-tree/description/

    private static boolean isNotBalanced = false;
    public static void main(String[] args) {
        TreeNode node = TreeUtils.getNode();
        node.left.left = null;
        node.left.right = null;
        node.right.right.right = null;
        node.right.right.left = null;
        node.right.left.left = null;
        node.right.left.right = null;
        System.out.println(isBalanced(node));
    }

    public static boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        isNotBalanced = false;
        isBalancedH(root);
        return !isNotBalanced;
    }

    public static int isBalancedH(TreeNode root) {
        if(root==null) return 0;
        if(isNotBalanced) {
            return 0;
        }
        int leftTree = 1+isBalancedH(root.left);
        int rightTree = 1+isBalancedH(root.right);
        if(Math.abs(leftTree-rightTree)>1) {
            isNotBalanced = true;
        }
        return Math.max(leftTree,rightTree);

    }
}
