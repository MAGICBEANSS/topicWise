package org.dsa.topics.trees.BT;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InPrePostTraversal {


    public static void main(String[] args) {
        TreeNode node = getNode();
        List<Integer> list = new ArrayList<>();
        System.out.println("PRE ORDER TRAVERSAL ");
        preOrderTraversal(node,list);
        System.out.println("\nIN ORDER TRAVERSAL ");
        list = new ArrayList<>();
        inOrderTraversal(node,list);
        System.out.println("\nPOST ORDER TRAVERSAL ");
        list = new ArrayList<>();
        postOrderTraversal(node,list);
    }

    private static void inOrderTraversal(TreeNode node, List<Integer> list) {
        if(Objects.isNull(node)) {
            return;
        }
        inOrderTraversal(node.left, list);
        System.out.print(node.val+" ");
        inOrderTraversal(node.right, list);
    }

    private static void preOrderTraversal(TreeNode node, List<Integer> list) {
        if(Objects.isNull(node)) {
            return;
        }
        //System.out.print(node.val+" ");
        list.add(node.val);
        preOrderTraversal(node.left, list);
        preOrderTraversal(node.right, list);
    }

    private static void postOrderTraversal(TreeNode node, List<Integer> list) {
        if(Objects.isNull(node)) {
            return;
        }
        postOrderTraversal(node.left, list);
        postOrderTraversal(node.right, list);
        list.add(node.val);
    }


    private static TreeNode getNode(){
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

    private static TreeNode getNode(int[] arr) {
        if(arr.length==0) return null;
        TreeNode treeNode = new TreeNode();
        int i =0;
        int k =0;
        while (i<arr.length) {
            int totalOnLevel = (int) Math.pow(2,i);
            for (int j = 0; j < totalOnLevel && i< arr.length; j++) {

            }
        }
        return treeNode;
    }

    }

