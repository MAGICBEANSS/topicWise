package org.dsa.topics.trees.BT;

import org.dsa.topics.trees.BT.utils.TreeUtils;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class FlattenTreeToLinkedlIST {

    //https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
    //https://www.youtube.com/watch?v=NOKVBiJwkD0&t=9s

    /*
     *
     * Approach 2
     *
     * https://www.youtube.com/watch?v=NOKVBiJwkD0&t=9s
     *
     * @param args
     */

    public static void main(String[] args) {
        Integer[] list = {1,2,5,3,4,null,6};
        TreeNode root = TreeUtils.constructTree(list);
        flattenTree(root);
        System.out.println(root);
    }

    public static TreeNode flattenTree(TreeNode root) {
        if(Objects.isNull(root)) return null;
        TreeNode left = flattenTree(root.left);
        TreeNode right = flattenTree(root.right);

        if(Objects.isNull(left)) return root;
        if(Objects.isNull(right)) {
            root.right = left;
            root.left = null;
        }
        else {
            root.right = left;
            left.left = null;
            while(Objects.nonNull(left.right)) {
                left = left.right;
            }
            left.right = right;
            root.left = null;
        }
        return root;

    }
}
