package org.dsa.topics.trees.BT;

import org.dsa.topics.trees.BT.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Boundarytraversal {

    private static List<Integer> data;
    public static void main(String[] args) {
        TreeNode root = TreeUtils.getNode();
        data = new ArrayList<>();
        data.add(root.val);
        boundaryTraversal(root.left,1);
        boundaryTraversal(root.right,-1);
        boundaryTraversalBottom(root);
        System.out.println(data);
    }

    private static void boundaryTraversalBottom(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        if(Objects.isNull(root.left)&& Objects.isNull(root.right)) {
            data.add(root.val);
        }
        else {
            boundaryTraversalBottom(root.left);
            boundaryTraversalBottom(root.right);
        }
    }

    private static void boundaryTraversal(TreeNode root,int order) {
        if (Objects.isNull(root)) {
            return;
        }
        data.add(root.val);
        /*if(
                (Objects.nonNull(root.left) && Objects.isNull(root.left.left) && Objects.isNull(root.left.right)) &&
                (Objects.nonNull(root.right) && Objects.isNull(root.right.left) && Objects.isNull(root.right.right))

        ){
                data.add(root.left.val);
                data.add(root.right.val);
        }*/

            if(order==1) {
                if(Objects.nonNull(root.left)) {
                    boundaryTraversal(root.left,order);
                }
                else {
                    boundaryTraversal(root.right,order);

                }
            }
            else if(order==-1) {
                if(Objects.nonNull(root.right)) {
                    boundaryTraversal(root.right,order);
                }
                else {
                    boundaryTraversal(root.left,order);

                }
            }
        //}

    }
}
