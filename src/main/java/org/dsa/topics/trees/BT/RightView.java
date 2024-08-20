package org.dsa.topics.trees.BT;

import org.dsa.topics.trees.BT.utils.TreeUtils;

import java.util.*;
import java.util.stream.Collectors;

public class RightView {
    static Map<Integer, Map<Integer,Integer>> hmap = new HashMap();
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Integer[] arr = {0,1,2,null,3,4,null,null,5,9,null,null,6,10,null};
        TreeNode root = TreeUtils.constructTree(arr);
        System.out.println(rightSideView(root));
    }

    public static List<Integer> rightSideView(TreeNode root) {
            list = new ArrayList<>();
            hmap = new HashMap<>();
            rightView(root);
         //   System.out.println(hmap);
            hmap.values().stream().forEach(a->{
                list.addAll(a.values());
            });
            return list;
    }

    private static void rightView(TreeNode node) {
        Queue<TreeNodePolar> queue = new LinkedList<>();
        int polarity=0,level = 0;
        queue.offer(new TreeNodePolar(node,polarity,level));
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNodePolar tnp = queue.poll();
                polarity = tnp.polarity;
                level = tnp.level;
                if(hmap.containsKey(level)) {
                    Map<Integer,Integer> cmap = hmap.get(level);
                    List<Integer> sortedPolarity = cmap.keySet().stream().sorted().collect(Collectors.toList());
                    int maxPolarity = sortedPolarity.get(sortedPolarity.size()-1);
                    if(polarity>=maxPolarity) {
                        cmap.remove(maxPolarity);
                        cmap.put(polarity,tnp.node.val);
                    }
                    hmap.put(level,cmap);
                }
                else {
                    Map<Integer,Integer> cmap = new HashMap<>();
                    cmap.put(polarity,tnp.node.val);
                    hmap.put(level,cmap);
                }
                if(Objects.nonNull(tnp.node) && Objects.nonNull(tnp.node.left)) {
                    queue.offer(new TreeNodePolar(tnp.node.left,polarity-1,level+1));
                }
                if(Objects.nonNull(tnp.node) && Objects.nonNull(tnp.node.right)) {
                    queue.offer(new TreeNodePolar(tnp.node.right,polarity+1,level+1));
                }
            }
        }
    }



    static class TreeNodePolar  {
        TreeNode node;
        int polarity;
        int level;

        TreeNodePolar(TreeNode treeNode,int polarity,int level){
            this.node = treeNode;
            this.polarity  = polarity;
            this.level = level;
        }


    }
}


