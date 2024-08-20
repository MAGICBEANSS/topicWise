package org.dsa.topics.trees.BT;

import org.dsa.topics.trees.BT.TreeNode;
import org.dsa.topics.trees.BT.utils.TreeUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class TimeTakenToBurnATree {
    public static void main(String[] args) {
      //  Integer[] arr = {3,5,1,6,2,0,8,null,null,7,4,null,null,null,null};
        Integer[] arr = {1,5,3,null,4,10,6,9,2};
        //  Integer[] arr = {3,2};
        TreeNode node = TreeUtils.constructTree(arr);
        System.out.println(amountOfTime(node,5));
    }

    public static int amountOfTime(TreeNode root, int start) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer,TreeNode> nodeMap = new HashMap<>();
        record(root,null,nodeMap);
        TreeNode target = findStart(root,start);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        int k=0;
        while (!queue.isEmpty()){
            k++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if(Objects.nonNull(node)) {
                    if (visited.contains(node.val)) {
                        continue;
                    }
                    TreeNode parent = nodeMap.get(node.val);

                    visited.add(node.val);
                    if(Objects.nonNull(node.left) && !visited.contains(node.left.val)){
                        queue.offer(node.left);
                    }
                    if(Objects.nonNull(node.right) && !visited.contains(node.right.val)){
                        queue.offer(node.right);
                    }
                    if(Objects.nonNull(parent) && !visited.contains(parent.val)){
                        queue.offer(parent);
                    }
                }
            }
        }
        return k-1;

    }

    private static TreeNode findStart(TreeNode root, int start) {
        if(Objects.isNull(root)) return null;
        if(root.val==start) return root;
        TreeNode left = findStart(root.left,start);
        if(left.val==start) return left;
        TreeNode right = findStart(root.right,start);
        if(right.val==start) return right;
        return null;

    }

    private static void record(TreeNode root, TreeNode parent, Map<Integer, TreeNode> nodeMap) {
        if(Objects.isNull(root)) {
            return;
        }
        nodeMap.put(root.val,parent);
        record(root.left,root,nodeMap);
        record(root.right,root,nodeMap);

    }
}
