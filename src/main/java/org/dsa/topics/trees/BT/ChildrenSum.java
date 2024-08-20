package org.dsa.topics.trees.BT;

import org.dsa.topics.trees.BT.utils.TreeUtils;

import java.util.Objects;

public class ChildrenSum {
    public static void main(String[] args) {
     //   Integer[] arr = {50,7,2,3,5,1,30};
        Integer[] arr = {40,10,20,2,5,30,40};
     //   TreeNode node = TreeUtils.getNode();
         TreeNode node = TreeUtils.constructTree(arr);
        followChildrenSum(node);
        System.out.println(node.val);
    }

    private static void followChildrenSum(TreeNode node) {
        if(isLeafNode(node)) {
            return ;
            //return node.val;
        }
        int valRight = Objects.nonNull(node.right) ? node.right.val:0;
        int valLeft = Objects.nonNull(node.left) ? node.left.val:0;
        int sumOld = valLeft+valRight;
        if(node.val>sumOld) {
            node.right.val = node.val;
            node.left.val = node.val;

        }
        else {
            node.val = sumOld;
        }
         followChildrenSum(node.left);
        followChildrenSum(node.right);
        node.val = node.left.val+node.right.val;
      //  return node.val;
        return ;


    }

    private static boolean isLeafNode(TreeNode node) {
        return Objects.isNull(node.left) && Objects.isNull(node.right);
    }
}
