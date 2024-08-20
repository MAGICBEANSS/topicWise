package org.dsa.topics.trees.BT;

import org.dsa.topics.trees.BT.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RootToLeafPath {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.getNode();
        System.out.println(binaryTreePaths(root));
    }

        public static List<String> binaryTreePaths(TreeNode root) {
            List<String> nodes = new ArrayList<>();
            if(Objects.isNull(root)) return nodes;
            return binaryTreePaths(root,nodes);
        }

    private static List<String> binaryTreePaths(TreeNode root, List<String> nodes) {
    //    if(Objects.isNull(root))
     //   if(Objects.nonNull(root))
        return null;
    }

}
