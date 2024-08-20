package org.dsa.topics.trees.BT;

import org.dsa.topics.trees.BT.utils.TreeUtils;

import java.util.List;
import java.util.Objects;

public class MorrisTraversal {

    private static List<Integer> list;
    public static void main(String[] args) {
        TreeNode root = TreeUtils.getNode();

    }

    public static void  morrisTraversalInorder(TreeNode node) {

        if(Objects.nonNull(node)) {
            return;
        }
        while (Objects.nonNull(node)) {

            if (Objects.isNull(node.left)) {
                list.add(node.val);
                node = node.right;
            } else {
                TreeNode left = node.left;
                while (Objects.nonNull(left.right) && left.right.val!= node.val) {
                    left = left.right;
                }
                if(Objects.isNull(left.right)) {
                    left.right = node;
                    node = node.left;
                }
                else {
                    // todo`
                }
            }
        }
    }


}
