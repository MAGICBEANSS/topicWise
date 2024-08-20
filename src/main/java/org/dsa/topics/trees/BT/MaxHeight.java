package org.dsa.topics.trees.BT;

import org.dsa.topics.trees.BT.utils.TreeUtils;

public class MaxHeight {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.getNode();
        root.left.left.left.left = new TreeNode(23);
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
            if(root==null) return 0;
            else return 1+Math.max(
                    maxDepth(root.right),
                    maxDepth(root.left)
            );
    }
}
