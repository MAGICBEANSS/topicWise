package org.dsa.topics;

import org.dsa.topics.trees.BT.TreeNode;
import org.dsa.topics.trees.BT.utils.TreeUtils;

import java.util.*;
import java.util.stream.Collectors;

public class VerticalOrdertraversal {

    static Map<Integer,List<TreeNodePolar>> hm = new HashMap();
    private static int minPolarity = Integer.MAX_VALUE;
    private static int maxPolarity = Integer.MIN_VALUE;
    public static void main(String[] args) {
        TreeNode node = TreeUtils.getNode();
        hm = new HashMap();
        verticalOrder(node);
        System.out.println(hm);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = minPolarity; i <= maxPolarity; i++) {
            if(hm.containsKey(i)) {
                System.out.println("#########################################");
                hm.get(i).sort((a,b)->{
                    System.out.println("--------------------------------");

                    int comparisonOnLevel = Integer.compare(a.level,b.level);
                    if(comparisonOnLevel==0) {
                        return Integer.compare(a.node.val,b.node.val);
                    }
                    System.out.println(a.node.val+" VS "+ b.node.val+" result="+comparisonOnLevel);

                    System.out.println("--------------------------------");
                    return comparisonOnLevel;

                });
                list.add(hm.get(i).stream().map(a->a.node.val).collect(Collectors.toList()));
             //   list.add(hm.get(i));
            }
        }
        System.out.println(list);
    }

    private static void verticalOrder(TreeNode root) {
        int polarityIndex = 0;
        int level = 0;
        Queue<TreeNodePolar> queue = new LinkedList<>();
        queue.offer(new TreeNodePolar(root, polarityIndex,level));
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNodePolar polarNode = queue.poll();
                polarityIndex = polarNode.polarity;
                level = polarNode.level;
                minPolarity = Math.min(minPolarity,polarityIndex);
                maxPolarity = Math.max(maxPolarity,polarityIndex);
                hm.putIfAbsent(polarityIndex, new ArrayList<>());
                List<TreeNodePolar> valList = hm.get(polarityIndex);
                valList.add(polarNode);
                hm.put(polarityIndex, valList);
                if (Objects.nonNull(polarNode.node) && Objects.nonNull(polarNode.node.left)) {
                    queue.offer(new TreeNodePolar(polarNode.node.left, polarityIndex - 1,level+1));
                }
                if (Objects.nonNull(polarNode.node) && Objects.nonNull(polarNode.node.right)) {
                    queue.offer(new TreeNodePolar(polarNode.node.right, polarityIndex + 1,level+1));
                }
            }
        }

    }
}

class TreeNodePolar {
    TreeNode node;
    Integer polarity;
    Integer level;


    TreeNodePolar(TreeNode treeNode,int polarity,int level){
        this.node = treeNode;
        this.polarity  = polarity;
        this.level = level;
    }

  /*  public int compare(Object obj1, Object obj2) {
        TreeNodePolar myObj1 = (TreeNodePolar)obj1;
        TreeNodePolar myObj2 = (TreeNodePolar)obj2;
        int levelResult = myObj1.level.compareTo(myObj2.level);
        if (levelResult == 0) {
          //  return myObj1.node.val==myObj2.node.val ? 0: myObj1.node.val>myObj2.node.val? 1:-1;
            return Integer.compare(myObj1.node.val, myObj2.node.val);
        }
        else {
            return levelResult;
        }
    }*/


}
