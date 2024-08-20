package org.dsa.topics.trees.BT.utils;


import org.dsa.topics.trees.BT.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtils {

    public static TreeNode getNode(){
        TreeNode root  = new TreeNode(1);
        TreeNode rl  = new TreeNode(2);
        TreeNode rr  = new TreeNode(3);
        TreeNode rll  = new TreeNode(4);
        TreeNode rlr  = new TreeNode(5);
        TreeNode rrl  = new TreeNode(6);
        TreeNode rrr  = new TreeNode(7);
        TreeNode rlld  = new TreeNode(8);
        TreeNode rlll  = new TreeNode(9);
        TreeNode rldl  = new TreeNode(10);
        TreeNode rldr  = new TreeNode(11);
        TreeNode rdll  = new TreeNode(12);
        TreeNode rdlr  = new TreeNode(13);
        TreeNode rddl  = new TreeNode(14);
        TreeNode rddr  = new TreeNode(15);
        root.left = rl;
        root.right = rr;
        rl.left = rll;
        rl.right = rlr;
        rr.left = rrl;
        rr.right = rrr;
        rll.left = rlll;
        rll.right = rlld;
        rlr.left = rldl;
        rlr.right = rldr;
        rrl.left = rdll;
        rrl.right = rdlr;
        rrr.left = rddl;
        rrr.right = rddr;
        return root;

    }


    public static TreeNode constructTree(Integer[] levelOrder) {
        if (levelOrder == null || levelOrder.length == 0 || levelOrder[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(levelOrder[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < levelOrder.length; i += 2) {
            TreeNode parent = queue.poll();
            if (levelOrder[i] != null) {
                parent.left = new TreeNode(levelOrder[i]);
                queue.offer(parent.left);
            }
            if (i + 1 < levelOrder.length && levelOrder[i + 1] != null) {
                parent.right = new TreeNode(levelOrder[i + 1]);
                queue.offer(parent.right);
            }
        }

        return root;
    }
}
