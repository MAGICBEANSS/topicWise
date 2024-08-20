package org.dsa.topics.trees.BT;

import org.dsa.topics.trees.BT.TreeNode;
import org.dsa.topics.trees.BT.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IncreasingorderSubTree {


    public static void main(String[] args) {
        TreeNode root = TreeUtils.getNode();
        root = increasingBST(root);
        while (Objects.nonNull(root)) {
            System.out.print(root.val+" ");
            root = root.right;
        }
    }

    public static TreeNode increasingBST(TreeNode root) {
        if(root==null) return root;
        if(root.left==null && root.right==null) return root;
        List<Integer> list = new ArrayList<>();
        TreeNode result = new TreeNode();
        preOrderTraversal(root,list);
        if(list.isEmpty()) {
            return null;
        }
        TreeNode child = new TreeNode();

        result.val = list.get(0);
        result.right = child;
        for(int i =1;i<list.size();i++) {
            child.val = list.get(i);
            TreeNode next = new TreeNode();
            if(!(i==(list.size()-1))){
                child.right=next;
            }
            child=child.right;
        }
        return result;
    }

    private static void preOrderTraversal(TreeNode node, List<Integer> list) {
        if(Objects.isNull(node)) {
         //   list.add(null);
            return;
        }
        //System.out.print(node.val+" ");
        preOrderTraversal(node.left, list);
        list.add(node.val);

        preOrderTraversal(node.right, list);
    }
}
