package org.dsa.topics.trees.BT;

import org.dsa.topics.trees.BT.utils.TreeUtils;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class FlattenTreeToBinaryTree {

    //https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

    /**
     * Idea is to first fetch preorder , now this preorder needs to be arranged in suh a way that
     * every link is on the right and none on the left.
     * So we store this preorder in a queue
     * Now everytime , we poll out a element , and stick the next element on it right
     * and adds null to left , as null might have some value as we are still referring to
     * old treenode objects as in the input
     *     private static TreeNode helper(Queue<TreeNode> nodesQueue)
     *     This method does the job for it.
     *
     *
     * @param args
     */

    public static void main(String[] args) {
        Integer[] list = {1,2,5,3,4,null,6};
        TreeNode root = TreeUtils.constructTree(list);
        flatten(root);
    }

    public static void flatten(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        preOrder(root,queue);
        /*TreeNode newRoot = queue.poll();
        while (!queue.isEmpty()){
            TreeNode child = queue.poll();
            newRoot.right = child;

        }*/
        TreeNode newRoot = helper(queue);
        System.out.println(newRoot);
    }


    private static TreeNode helper(Queue<TreeNode> nodesQueue) {
        TreeNode data = nodesQueue.poll();
        if(Objects.isNull(data)) return null;
        data.left = null;
        data.right = helper(nodesQueue);
        return data;
    }

    private static void preOrder(TreeNode root, Queue<TreeNode> queue) {
        if(Objects.isNull(root))
            return;
        queue.offer(root);
        preOrder(root.left,queue);
        preOrder(root.right,queue);
    }
}
