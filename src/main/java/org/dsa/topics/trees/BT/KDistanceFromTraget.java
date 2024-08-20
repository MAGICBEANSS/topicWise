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

public class KDistanceFromTraget {
    //https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
    //https://www.youtube.com/watch?v=LQh2g3ygCVU
    public static void main(String[] args) {
            Integer[] arr = {3,5,1,6,2,0,8,null,null,7,4,null,null,null,null};
         //   Integer[] arr = {0,2,1,null,null,3,null};
          //  Integer[] arr = {3,2};
            TreeNode node = TreeUtils.constructTree(arr);
        System.out.println(distanceK(node,node.left,2));
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer,TreeNode> nodeMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        if(k==0) {
            list.add(target.val);
            return list;
        }
        if(Objects.isNull(root)|| Objects.isNull(target)) {
            return list;
        }
        nodeMap.put(root.val,null);
        record(root,nodeMap,null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        while (k>0) {
            k--;
            Integer x,y,z = null;
            int len = queue.size();
            while (len>0) {
                TreeNode node = queue.poll();
                len--;
                if (!visited.contains(node.val)) {
                    visited.add(node.val);
                    if (nodeMap.containsKey(node.val) && Objects.nonNull(nodeMap.get(node.val))) {
                        TreeNode parent = nodeMap.get(node.val);
                        queue.offer(parent);
                        if (k == 0 && !visited.contains(parent.val)) {
                            int value = nodeMap.get(node.val).val;
                            if (value != target.val) {
                                list.add(value);
                            }
                        }
                    }
                    if (Objects.nonNull(node.left) ) {
                        x = node.left.val;
                        if (k == 0  && !visited.contains(node.left.val)) {

                            if (x != target.val) {
                                list.add(x);
                            }
                        }
                        queue.offer(node.left);
                    }
                    if (Objects.nonNull(node.right) && !visited.contains(node.right.val)) {
                        y = node.right.val;
                        if (k == 0 && !visited.contains(node.right.val)) {
                            if (y != target.val) {
                                list.add(y);
                            }
                        }
                        queue.offer(node.right);
                    }
            }
           }
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
