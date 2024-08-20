package org.dsa.topics.trees.BT;

import org.dsa.topics.trees.BT.utils.TreeUtils;

public class Diameter {
    //https://leetcode.com/problems/diameter-of-binary-tree/description/
    private static int diameter = 0;
    public static void main(String[] args) {
        TreeNode node = TreeUtils.getNode();
        node.left.left.left = null;
        node.left.left.right = null;
        node.left.right.left = null;
        node.left.right.right = null;
        node.right.right=null;
        node.right.left=null;
        diameter = 0;
        diameterOfBinaryTree(node);
        System.out.println(diameter);
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int left = 1+diameterOfBinaryTree(root.left);
        int right = 1+diameterOfBinaryTree(root.right);
        int x =  Math.max(left,right);
        diameter = Math.max(left+right-2,diameter);
        return x;
    }
}
