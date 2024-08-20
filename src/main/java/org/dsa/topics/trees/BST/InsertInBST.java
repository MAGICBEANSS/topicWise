package org.dsa.topics.trees.BST;

import org.dsa.topics.trees.BT.TreeNode;
import org.dsa.topics.trees.BT.utils.TreeUtils;

import java.util.Objects;

public class InsertInBST {
    public static void main(String[] args) {
        Integer[] arr = {40,20,60,10,30,50,70};
        TreeNode root = TreeUtils.constructTree(arr);
         insertInBST(root,25);
        System.out.println(root);

    }

    private static void insertInBST(TreeNode node, int data) {
            if(Objects.isNull(node)) return ;
            if(data>node.val) {
                if(Objects.isNull(node.right)) {
                   node.right =  new TreeNode(data);
                }
                else {
                    insertInBST(node.right, data);
                }
            } else if (data<node.val) {
                if(Objects.isNull(node.left)) {
                    node.left = new TreeNode(data);
                }
                else {
                    insertInBST(node.left, data);
                }
            }
    }
}
