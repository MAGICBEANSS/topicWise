package org.dsa.topics.trees.BT;

import org.dsa.topics.trees.BT.utils.TreeUtils;

import java.util.Objects;

public class SymmetricBinarytREE {
    public static void main(String[] args) {
        Integer[] arr = {1,2,2,3,4,4,3};
        TreeNode node = TreeUtils.constructTree(arr);
        System.out.println(isSymmetric(node.left,node.right));
    }

    public static boolean isSymmetric(TreeNode left,TreeNode right) {
     //   if(Objects.isNull(root)) return true;
        if((Objects.isNull(left) && Objects.nonNull(right))||(Objects.isNull(right) && Objects.nonNull(left))){
            return false;
        }
        if(Objects.isNull(right) && Objects.isNull(left)) {
            return true;
        }
        return left.val==right.val && isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }
}
