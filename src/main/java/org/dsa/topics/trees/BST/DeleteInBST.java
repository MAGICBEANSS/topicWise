package org.dsa.topics.trees.BST;

import org.dsa.topics.trees.BT.TreeNode;
import org.dsa.topics.trees.BT.utils.TreeUtils;

import java.util.Objects;

public class DeleteInBST {

    public static void main(String[] args) {
        Integer[] arr = {40,20,60,10,30,50,70};
        TreeNode root = TreeUtils.constructTree(arr);
        deleteInBST(root,70);
        System.out.println(root);

    }

    private static void deleteInBST(TreeNode node, int data) {
        if(Objects.isNull(node)) return;
        if(data==node.val) {
            if(Objects.isNull(node.left) && Objects.isNull(node.right)) {
                // this is leaf , just set it to null
                node = null;
                return;
            } else if (Objects.isNull(node.left)) {
                node = node.right;
            }
            else if (Objects.isNull(node.right)) {
                node = node.left;
            }
            else {
                node = node.left;
            }
        }

    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(Objects.isNull(root)) return root;
        deleteInBST(root,key);
        return root;
    }
}
