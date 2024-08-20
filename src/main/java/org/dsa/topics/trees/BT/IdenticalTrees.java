package org.dsa.topics.trees.BT;

import org.dsa.topics.trees.BT.utils.TreeUtils;

public class IdenticalTrees {

    public static void main(String[] args) {
        Integer[] arr1 =  {1,2,3,4};
        Integer[] arr2 = {1,2,3,4};
        TreeNode root1 = TreeUtils.constructTree(arr1);
        TreeNode root2 = TreeUtils.constructTree(arr2);
    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p==null && q== null) return true;
            if((p!=null && q==null)||(p==null && q!=null)) {
                return false;
            }
            return p.val==q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
