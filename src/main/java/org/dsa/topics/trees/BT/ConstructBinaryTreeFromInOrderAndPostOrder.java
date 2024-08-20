package org.dsa.topics.trees.BT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstructBinaryTreeFromInOrderAndPostOrder {
    private static Map<Integer,Integer> inOrderMap = new HashMap<>();
    public static void main(String[] args) {
        int[] inorder= {4, 8, 2, 5, 1, 6, 3, 7};
    //    int[] inorder= {-1};
    //    int[] postorder= {-1};
        int[] postorder= {8, 4, 5, 2, 6, 7, 3, 1};
        System.out.println(buildTree(inorder,postorder));
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        inOrderMap = new HashMap<>();
        Integer[] data1 = Arrays.stream(postorder).boxed().toArray(Integer[]::new);
        List<Integer> postorderList = Arrays.asList(data1);
        data1 = Arrays.stream(inorder).boxed().toArray(Integer[]::new);
        List<Integer> inorderList = Arrays.asList(data1);
        inOrderMap = getMap(inorderList);
        TreeNode node =  buildTree(inorderList,postorderList,0,postorderList.size()-1,0,inorderList.size()-1);
        return node;
    }

    private static TreeNode buildTree(List<Integer> inorderList, List<Integer> postorderList,int startPost,int endPost,int startIn,int endIn) {
        if((startPost>endPost) || (startIn>endIn) || startPost<0||startIn<0) {
            return null;
        }
        if(inorderList.isEmpty() || postorderList.isEmpty()) return null;
        Integer nodeData = postorderList.get(endPost);
        //inOrderMap = getMap(inorderList);
        TreeNode node = new TreeNode(nodeData);
        Integer indexRoot = inOrderMap.get(nodeData);
       // List<Integer> leftInOrderList = inorderList.subList(0,indexRoot);
     //   List<Integer> rightInOrderList = new ArrayList<>();
        if(indexRoot>0) {
            startIn = startIn;
            endIn = indexRoot - 1;
            int length = endIn - startIn;
            int lengthOfLeftSubtree = length + 1;
        //    if (length > 0) { // call for left only if there are elements in the window endIn-StartIn;
                startPost = startPost;
                endPost = startPost + length;
                node.left = buildTree(inorderList, postorderList, startPost, endPost, startIn, endIn);
        //    }
        }
        if(indexRoot<endIn)
         // for right subtree
        startIn = indexRoot+1;
        endIn = endIn;
        int length = endIn-startIn;
      //  if(length>0) { // call for left only if there are elements in the window endIn-StartIn;
            startPost=  endPost-length;
          //  startPost = endPost+1;
            endPost = endPost;
            node.right = buildTree(inorderList,postorderList,startPost,endPost,startIn,endIn);
    //    }
        return node;

    }

    private static Map<Integer,Integer> getMap(List<Integer> data){
        Map<Integer,Integer> hm = new HashMap<>();
        for (int i = 0; i < data.size(); i++) {
            hm.put(data.get(i),i);
        }
        return hm;
    }
}
