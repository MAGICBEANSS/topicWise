package org.dsa.topics.trees.BT;

import org.dsa.topics.trees.BT.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RootToNodePath {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.getNode();
        System.out.println(binaryTreePaths(root,15));
    }

        public static List<String> binaryTreePaths(TreeNode root,int value) {
            List<String> nodes = new ArrayList<>();
            if(Objects.isNull(root)) return nodes;
            binaryTreePaths(root,nodes,value);
            return nodes;
        }

    private static boolean binaryTreePaths(TreeNode root, List<String> nodes,int target) {
        if(Objects.isNull(root)) return false;
        if(root.val==target) {
            nodes.add(root.val+"");
            return true;
        }
        nodes.add(root.val+"=>");
        boolean found = binaryTreePaths(root.left,nodes,target);
        if(found) return found;
        found = binaryTreePaths(root.right,nodes,target);
        if(found) return found;
        nodes.remove(nodes.size()-1);
        return false;
    }

}
