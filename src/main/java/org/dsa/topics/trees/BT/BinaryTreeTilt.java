package org.dsa.topics.trees.BT;

import org.dsa.topics.trees.BT.TreeNode;

import java.util.Objects;

public class BinaryTreeTilt {
    private static int sum;
    public static void main(String[] args) {
    //    TreeNode root = TreeUtils.getNode();
        TreeNode root = getNode();
        //root.left.left.left.left = new TreeNode(45);
        int z= findTiltAndSum(root);
        System.out.println(sum);

    }

    public static int findTilt(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftval = Objects.isNull(root.left)? 0: root.left.val;
        int rightval = Objects.isNull(root.right)? 0: root.right.val;
        return Math.abs(leftval-rightval)+findTilt(root.right)+findTilt(root.left);
    }
    public static int findTiltAndSum(TreeNode root) {
            if(root==null){
                return 0;
            }
            int rightSum = findTiltAndSum(root.right);
            int leftSum = findTiltAndSum(root.left);
            int totalSum = leftSum+rightSum+root.val;
            sum = sum+Math.abs(rightSum-leftSum);
            return totalSum;
    }

    private static TreeNode getNode() {
        TreeNode root = new TreeNode(4);
        TreeNode rl = new TreeNode(2);
        TreeNode rr = new TreeNode(9);
        TreeNode rrr = new TreeNode(7);
        TreeNode rll = new TreeNode(3);
        TreeNode rlr = new TreeNode(5);
        root.right = rr;
        root.left = rl;
        rl.left = rll;
        rl.right = rlr;
        rr.right = rrr;
        return root;


    }
}
