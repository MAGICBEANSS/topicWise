package org.dsa.topics.trees.BST;

import org.dsa.topics.trees.BT.TreeNode;
import org.dsa.topics.trees.BT.utils.TreeUtils;

import java.util.Objects;

public class SearchInBST {

    public static void main(String[] args) {
        Integer[] arr = {4,2,7,1,3};
        TreeNode root = TreeUtils.constructTree(arr);
        TreeNode node = searchBST(root,1);
        System.out.println(root);

    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if(Objects.isNull(root)) return null;
        if(root.val==val) return root;
        else if (val>root.val) {
            return searchBST(root.right,val);
        }
        else {
            return searchBST(root.left,val);
        }
    }
}
