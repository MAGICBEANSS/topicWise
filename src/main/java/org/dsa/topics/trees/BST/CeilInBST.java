package org.dsa.topics.trees.BST;

import org.dsa.topics.trees.BT.TreeNode;
import org.dsa.topics.trees.BT.utils.TreeUtils;

import java.util.Objects;

public class CeilInBST {

    public static  int ceilValue = -1;


    public static void main(String[] args) {
        Integer[] arr = {5,2,7,1,3};
        TreeNode root = TreeUtils.constructTree(arr);
        Integer ceilBST = searchCeilBST(root,9);
        System.out.println(ceilBST);

    }

    public static int searchCeilBST(TreeNode root, int val) {
        if(Objects.isNull(root)) return Integer.MAX_VALUE;
        if(root.val==val) return root.val;
        else if (val>root.val) {
             searchCeilBST(root.right,val);
        }
        else {
            ceilValue = root.val;
             searchCeilBST(root.left,val);
        }
        return ceilValue;

    }
}
