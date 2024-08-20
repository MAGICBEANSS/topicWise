package org.dsa.topics.trees.BT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConstructBinaryTreeFromInOrderAndPreOrder {
    public static void main(String[] args) {
        int[] inorder= {9,3,15,20,7};
    //    int[] inorder= {-1};
    //    int[] preorder= {-1};
        int[] preorder= {3,9,20,15,7};
        System.out.println(buildTree(inorder,preorder));
    }

    public static TreeNode buildTree(int[] inorder, int[] preorder) {
        Integer[] data1 = Arrays.stream(preorder).boxed().toArray(Integer[]::new);
        List<Integer> preorderList = Arrays.asList(data1);
        data1 = Arrays.stream(inorder).boxed().toArray(Integer[]::new);
        List<Integer> inorderList = Arrays.asList(data1);
        TreeNode node =  buildTree(inorderList,preorderList);
        return node;
    }

    private static TreeNode buildTree(List<Integer> inorderList, List<Integer> preorderList) {
        if(inorderList.isEmpty() || preorderList.isEmpty()) return null;
        Integer nodeData = preorderList.get(0);
        Map<Integer,Integer> inOrderMap = getMap(inorderList);
        //Map<Integer,Integer> preOrderMap = getMap(preorderList);
        TreeNode node = new TreeNode(nodeData);
        Integer indexRoot = inOrderMap.get(nodeData);
        List<Integer> leftInOrderList = inorderList.subList(0,indexRoot);
        List<Integer> rightInOrderList = new ArrayList<>();
        if(indexRoot<inorderList.size()-1) {
            rightInOrderList = inorderList.subList(indexRoot + 1, inorderList.size());
        }
        int lengthOfLeftInOrder = leftInOrderList.size();
        int lengthOfRightInOrder = rightInOrderList.size();
        List<Integer> leftPreOrderList = preorderList.subList(1,1+lengthOfLeftInOrder);
        List<Integer> rightPreOrderList = preorderList.subList(1+lengthOfLeftInOrder,preorderList.size());
        TreeNode left = buildTree(leftInOrderList,leftPreOrderList);
        TreeNode right = buildTree(rightInOrderList,rightPreOrderList);
        node.left = left;
        node.right = right;
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
