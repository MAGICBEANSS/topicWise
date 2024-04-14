package org.dsa.topics.theory;

import java.util.*;

public class BFSTraversalUsingAL {
    private static boolean[] visited;

    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{3,4},{2,5},{5,6},{5,7},{8,9},{10,10}};
        int len_of_vertices = 10; //1-10
        visited = new boolean[len_of_vertices+1];
        int[] vertices = getNodes(len_of_vertices);
        Map<Integer, List<Pair>> adjl = getList(edges,vertices);

        List<List<Integer>> list = getBFSResults(adjl,vertices, 1);
        System.out.println(list);

    }

    private static List<List<Integer>> getBFSResults(Map<Integer, List<Pair>> adjl, int[] vertices, int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        List<List<Integer>> masterList = new ArrayList<>();
        while(!queue.isEmpty()) {
            List<Integer> nodes = new ArrayList<>();
            int currentNode = queue.poll();
            if(!visited[currentNode]) {
                nodes.add(currentNode);
                visited[currentNode] = true;
                List<Pair> associatedNodes = adjl.getOrDefault(currentNode, new ArrayList<>());
                for (Pair pair : associatedNodes) {
                    queue.offer(pair.getEnd());
                }
            }
            if(!nodes.isEmpty() && nodes.size()>=1) {
                masterList.add(nodes);
            }
        }
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i] ) {
                if(adjl.containsKey(i)) {
                    Integer currentNode = i;
                    queue.offer(currentNode);
                    while(!queue.isEmpty()) {
                        List<Integer> nodes = new ArrayList<>();
                        currentNode = queue.poll();
                        if(!visited[currentNode]) {
                            nodes.add(currentNode);
                            visited[currentNode] = true;
                            List<Pair> associatedNodes = adjl.getOrDefault(currentNode, new ArrayList<>());
                            for (Pair pair : associatedNodes) {
                                queue.offer(pair.getEnd());
                            }
                        }
                        if(!nodes.isEmpty() && nodes.size()>=1) {
                            masterList.add(nodes);
                        }
                    }
                }
            }
        }
        return masterList;
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
