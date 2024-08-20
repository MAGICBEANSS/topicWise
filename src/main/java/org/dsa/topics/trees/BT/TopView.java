package org.dsa.topics.trees.BT;

import org.dsa.topics.trees.BT.utils.TreeUtils;

import java.util.*;
import java.util.stream.Collectors;

public class TopView {

   static Map<Integer,Map<Integer,Integer>> hmap = new HashMap();
   static Map<String,Integer> hms = new HashMap();
   static Map<Integer,Integer> hml = new HashMap();
   static Map<Integer,Integer> hmr = new HashMap();
   static List<Integer> answer ;
    public static void main(String[] args) {

        TreeNode root = TreeUtils.getNode();
        hmap = new HashMap();
        //     hml = new HashMap();
   //     hmr = new HashMap();
        answer = new ArrayList<>();
        topView(root);
        System.out.println(hmap);
    }

    private static void topView(TreeNode node) {
        Queue<TreeNodePolar> queue = new LinkedList<>();
        int polarity=0;
        int level = 0;
        queue.offer(new TreeNodePolar(node,polarity,level));
        while (!queue.isEmpty()){
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNodePolar tnp = queue.poll();
                level = tnp.level;
                polarity = tnp.polarity;

                if(!hmap.containsKey(level)) {
                    HashMap polarLevelMap = new HashMap();
                    polarLevelMap.put(polarity,tnp.node.val);
                    hmap.put(level,polarLevelMap);
                }
                else {
                    Map<Integer,Integer> polarLevelMap = hmap.get(level);
                    List<Integer> polarityNos = polarLevelMap.keySet().stream().sorted().collect(Collectors.toList());
                    int minPolarity = polarityNos.get(0);
                    int maxPolarity = polarityNos.get(polarityNos.size()-1);
                    for (Integer cPolarity: polarityNos) {
                        if(cPolarity!=minPolarity && cPolarity!=maxPolarity) {
                            polarLevelMap.remove(cPolarity);
                        }
                    }

                    if(polarity<minPolarity) {
                        if(minPolarity!=maxPolarity) {
                            polarLevelMap.remove(minPolarity);
                        }
                        polarLevelMap.put(polarity,tnp.node.val);
                    }
                    if(polarity>maxPolarity) {
                        if(minPolarity!=maxPolarity) {
                            polarLevelMap.remove(maxPolarity);
                        }
                        polarLevelMap.put(polarity,tnp.node.val);
                    }
                  //  polarLevelMap.put(polarity,tnp.node.val);
                    hmap.put(level,polarLevelMap);
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
}

 class TreeNodePolar  {
    TreeNode node;
    int polarity;
    int level;

    TreeNodePolar(TreeNode treeNode,int polarity,int level){
        this.node = treeNode;
        this.polarity  = polarity;
        this.level = level;
    }


}
