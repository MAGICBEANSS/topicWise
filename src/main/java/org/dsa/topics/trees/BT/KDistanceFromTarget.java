package org.dsa.topics.trees.BT;

import org.dsa.topics.trees.BT.utils.TreeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class KDistanceFromTarget {
    //https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
    //https://www.youtube.com/watch?v=LQh2g3ygCVU
    public static void main(String[] args) {
         //   Integer[] arr = {3,5,1,6,2,0,8,null,null,7,4,null,null,null,null};
            Integer[] arr = {0,1,null,null,2,null,3,null,4};
          //  Integer[] arr = {3,2};
            TreeNode node = TreeUtils.constructTree(arr);
        System.out.println(distanceK(node,node.left,0));
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Set<Integer> visited = new HashSet<>();

        Map<Integer,TreeNode> nodeMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        record(root,nodeMap,null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        while (k>0) {
            k--;
            int len = queue.size();
            List<Integer> nos = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();

                if(Objects.nonNull(node)) {

                    if(visited.contains(node.val)) {
                        continue;
                    }
                    visited.add(node.val);
                    TreeNode left = node.left;
                    TreeNode right = node.right;
                    TreeNode parent = nodeMap.get(node.val);
                    if(Objects.nonNull(left) && !visited.contains(left.val)) {
                        nos.add(left.val);
                        queue.offer(left);
                    }
                    if(Objects.nonNull(right)&& !visited.contains(right.val)) {
                        nos.add(right.val);
                        queue.offer(right);
                    }
                    if(Objects.nonNull(parent) && !visited.contains(parent.val)) {
                        nos.add(parent.val);
                        queue.offer(parent);
                    }
                }
            }
            list = nos;
        }
        return list;
    }

    private static void record(TreeNode root, Map<Integer, TreeNode> nodeMap,TreeNode parent) {
        if(Objects.isNull(root)){
            return;
        }
        nodeMap.put(root.val,parent);
        record(root.left,nodeMap,root);
        record(root.right,nodeMap,root);
    }

}
