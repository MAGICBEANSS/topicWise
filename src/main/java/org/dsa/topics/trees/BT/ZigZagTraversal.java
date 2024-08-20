package org.dsa.topics.trees.BT;

import org.dsa.topics.trees.BT.TreeNode;
import org.dsa.topics.trees.BT.utils.TreeUtils;

import java.util.*;

public class ZigZagTraversal {


    //https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

    public static void main(String[] args) {
        TreeNode root = TreeUtils.getNode();
        List<List<Integer>> list =  printZigZag(root);
        for (int i = 0; i < list.size(); i++) {
            List<Integer> levelList = list.get(i);
            System.out.println();
            for (int j = 0; j < levelList.size(); j++) {
                System.out.print(levelList.get(j)+" ");
            }
        }
    }

    private static List<List<Integer>> printZigZag(TreeNode root) {
        if(root==null) return null;
        List<List<Integer>> allList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean LTR = true;
        queue.add(root);
        while (!queue.isEmpty()){
            int levelCount = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < levelCount; i++) {
                TreeNode  node = queue.poll();
                list.add(node.val);
                if(Objects.nonNull(node.left)) {
                    queue.offer(node.left);
                }
                if(Objects.nonNull(node.right)) {
                    queue.offer(node.right);
                }
            }
            if(!LTR) {
             Collections.reverse(list);

            }
            LTR = !LTR;
            allList.add(list);
        }
        return allList;
    }


}
