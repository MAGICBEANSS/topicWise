package org.dsa.topics.theory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyListDirectedWeighted {

    public static void main(String[] args) {
        int n =3, m=2;
        int[][] edges = {{2,1,2},{2,0,5}};
        printAdjacencyListUndirected(n,m,edges);
    }

    private static void printAdjacencyListUndirected(int n, int m, int[][] edges) {
        Map<String, List<Pair>> adjl = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            int weight = edges[i][2];
            String startNode = String.valueOf(start);
            Pair pair1 = new Pair(start,end,weight);
            if(adjl.containsKey(startNode)) {
                List<Pair> currentPathsForNode= adjl.get(startNode);
                currentPathsForNode.add(pair1);
            }
            else {
                List<Pair> currentPathsForNode= new ArrayList<>();
                currentPathsForNode.add(pair1);
                adjl.put(startNode,currentPathsForNode);
            }
        }

        System.out.println(adjl);
    }
}
