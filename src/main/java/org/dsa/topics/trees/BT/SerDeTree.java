package org.dsa.topics.trees.BT;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class SerDeTree {

    public static void main(String[] args) {
        TreeNode root = getTree();
        serDe(root);
    }

    private static void serDe(TreeNode root) {
        String treeStringPreOrder = serialize(root);
        System.out.println(treeStringPreOrder);
        TreeNode back = deSerialize(treeStringPreOrder);
        System.out.println(back);
    }

    private static TreeNode deSerialize(String treeStringPreOrder) {
        if(Objects.isNull(treeStringPreOrder) || treeStringPreOrder.length()<=0 || String.valueOf(treeStringPreOrder.charAt(0)).equalsIgnoreCase("X")){
            return null;
        }
        String[] items = treeStringPreOrder.split(",");
        Queue<String> nodesQueue = new LinkedList<>();
        nodesQueue.addAll(Arrays.asList(items));
        return helper(nodesQueue);

    }

    private static TreeNode helper(Queue<String> nodesQueue) {
        String data = nodesQueue.poll();
        if(data.equalsIgnoreCase("x")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(data));
        node.left = helper(nodesQueue);
        node.right = helper(nodesQueue);
        return node;
    }


    private static String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            rserialize(root,sb);
            return sb.toString();
    }

    private static void rserialize(TreeNode node,StringBuilder sb) {
        if(Objects.isNull(node)){
            sb.append("X,");
            return ;
        }
        sb.append(node.val).append(",");
        rserialize(node.left,sb);
        rserialize(node.right,sb);
    }

    public static TreeNode getTree() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(16);
        TreeNode node5 = new TreeNode(11);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(25);
        TreeNode node8 = new TreeNode(23);
        TreeNode node9 = new TreeNode(12);
        node1.left = node2;
        node1.right = node3;
        node2.left=node4;
        node4.left=node7;
        node4.right=node8;
        node3.left = node5;
        node3.right = node6;
        node5.right = node9;
        return node1;
    }
}
