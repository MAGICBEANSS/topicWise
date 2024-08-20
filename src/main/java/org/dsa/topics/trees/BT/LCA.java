package org.dsa.topics.trees.BT;

import org.dsa.topics.trees.BT.TreeNode;

import java.util.Objects;

public class LCA {
    public static void main(String[] args) {
        TreeNode root = getNode();
        System.out.println(lowestCommonAncestor(root,root.left.left,root.left).val);
     //   System.out.println(lowestCommonAncestor(root,root.left.left.left,root.left.left.right).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        TreeNode lca =  lca(root,p.val,q.val);
        return lca;

    }

    private static TreeNode lca(TreeNode root, int a1,int a2) {
        if(root==null) return null;
        if(root.val==a1 || root.val == a2) {
            //search ahead or not
            return root;
        }
        TreeNode lca1 = lca(root.left,a1,a2);
        TreeNode lca2 = lca(root.right,a1,a2);
        if(Objects.isNull(lca1)|| Objects.isNull(lca2)){
            return Objects.isNull(lca1) ? Objects.isNull(lca2) ? null : lca2:lca1;
        }
        if(lca1.val!=lca2.val) {
            return root;
        }
        return lca1;
    }

    public static TreeNode getNode(){
        TreeNode root  = new TreeNode(1);
        TreeNode two  = new TreeNode(2);
        TreeNode three  = new TreeNode(3);
        TreeNode four  = new TreeNode(4);
        TreeNode five  = new TreeNode(5);
        TreeNode six  = new TreeNode(6);
        TreeNode seven  = new TreeNode(7);
        TreeNode eight  = new TreeNode(8);
        TreeNode nine  = new TreeNode(9);
        TreeNode ten  = new TreeNode(10);
        TreeNode eleven  = new TreeNode(11);
        TreeNode rdll  = new TreeNode(12);
        TreeNode rdlr  = new TreeNode(13);
        TreeNode rddl  = new TreeNode(14);
        TreeNode rddr  = new TreeNode(15);
        root.left = two;
        root.right = three;
        two.left = four;
        two.right = five;
        three.left = ten;
        three.right = eleven;
        five.right = six;
        six.left = seven;
        six.right = eight;
        eight.right = nine;
        return root;

    }
}
