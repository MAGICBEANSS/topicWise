package org.dsa.topics.trees.BT;

import org.dsa.topics.trees.BT.TreeNode;
import org.dsa.topics.trees.BT.utils.TreeUtils;

public class MaxPathSum {

    private static  int maxSum = Integer.MIN_VALUE;
    public static void main(String[] args) {
       // Integer[] arr = {-10,9,20,null,null,15,7};
        Integer[] arr = {9,6,-3,null,null,-6,2,null,null,2,null,-6,-6,-6};
        //TreeNode node = TreeUtils.getNode();
        TreeNode node = TreeUtils.constructTree(arr);
        System.out.println(maxPathSum(node));
    }


    public static int maxPathSum(TreeNode root) {
            if(root==null) return 0;
            maxPathSumF(root);
            return maxSum;
    }

    public static int maxPathSumF(TreeNode root) {
        if(root==null) return 0;
        int val = root.val;
        int maxLeft = maxPathSumF(root.left);
        int maxRight = maxPathSumF(root.right);

        /**
         * To mark a path as maximum , we have many possibilities
         * val alone can be a possibility
         * val + maxLeft can be a possibility
         * val + maxRight can be a possibility
         * val+maxLeft+MaxRight can be a possibility
         *
         *
         */
        maxSum = Math.max(maxSum,Math.max(val,Math.max(val+maxLeft,Math.max(val+maxRight,val+maxLeft+maxRight))));

        /*
Below code is doing the same thing , in a simple way , without using nested comparison
maxSum = Math.max(maxSum,Math.max(val,Math.max(val+maxLeft,Math.max(val+maxRight,val+maxLeft+maxRight))));
         */

        /*
        int max1 = Math.max(maxLeft+val,val);
        max1 = Math.max(maxRight+val,max1);
        maxSum = Math.max(max1,maxSum);
        int totalSumTaking = maxLeft+maxRight+val;
        maxSum = Math.max(totalSumTaking,maxSum);
        */


        /**
         * To return from here , it can be values of only current node , if current node is grater than
         * sum using left or right.
         * If you include left or right , actual path becomes maxLeft+Math.max(maxRight,maxLeft);
         */
        int maxSumHere = Math.max(maxRight,maxLeft);
        return Math.max(val,val+maxSumHere);
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
