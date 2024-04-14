package org.dsa.topics.theory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoOfProvinces {
    private static boolean[] visited;

    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{3,4},{2,5},{5,6},{5,7},{8,9},{10,10}};
        int len_of_vertices = 10; //1-10
        visited = new boolean[len_of_vertices+1];
        int[] vertices = getNodes(len_of_vertices);
        Map<Integer, List<Pair>> adjl = getList(edges,vertices);

        int count =  getDFSResults(adjl,vertices, 1);
        System.out.println();
        System.out.println(count);

    }

    private static void getDFSRecursion(Map<Integer, List<Pair>> adjl, int[] vertices, int currentNode,List<Integer> nodesTraversed) {
        visited[currentNode] = true;

        for (Pair p: adjl.get(currentNode)) {
            if(!visited[p.getEnd()]) {
                 getDFSRecursion(adjl,vertices,p.getEnd(),nodesTraversed);
            }
        }
        nodesTraversed.add(currentNode);
    }

    private static int  getDFSResults(Map<Integer, List<Pair>> adjl, int[] vertices, int startNode) {
        List<Integer> allNodes = new ArrayList<>();
        int count = 0;
        for (int i = 1; i < vertices.length; i++) {
            if(!visited[i]) {
                count++;
                getDFSRecursion(adjl, vertices, i, allNodes);
            }
        }
        return count;


    }


    private static Map<Integer, List<Pair>> getList(int[][] edges, int[] vertices) {
        Map<Integer, List<Pair>> adjl = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            Pair pair1 = new Pair(start,end);
            Pair pair2 = new Pair(end,start);
            if (adjl.containsKey(start)) {
                List<Pair> pairs =  adjl.get(start);
                pairs.add(pair1);
            }
            else {
                List<Pair> pairs = new ArrayList<>();
                pairs.add(pair1);
                adjl.put(start,pairs);
            }
            if (adjl.containsKey(end)) {
                List<Pair> pairs =  adjl.get(start);
                pairs.add(pair2);
            }
            else {
                List<Pair> pairs = new ArrayList<>();
                pairs.add(pair2);
                adjl.put(end,pairs);
            }
        }

        return adjl;
    }

    private static int[] getNodes(int lenOfVertices) {
        int[] vertices = new int[lenOfVertices+1];
        for (int i = 0; i <= lenOfVertices; i++) {
            vertices[i] = i;
        }
        return vertices;
    }



}
