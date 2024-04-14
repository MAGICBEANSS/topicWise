package org.dsa.topics.theory;

public class AdjacencyMatrixDirected {

    public static void main(String[] args) {
        int n =3, m=2;
        int[][] edges = {{2,1},{2,0}};
        printAdjacency(n,m,edges);
    }


        public static int[][] printAdjacency(int n, int m, int[][] edges) {
            // Write your code here.

            int[] nodes = new int[n];
            for (int i = 0; i < edges.length; i++) {
                for (int j = 0; j < edges[0].length; j++) {
                    int no = edges[i][j];
                    nodes[no] = no;
                }
            }
            // we filtered out the nodes , assuming if there are n nodes ,
            // they are unique and in range 0 <-> n-1 i.e. 0-3 here.
            // we have to record this information in adjacency matrix
            // we assume rows to be source and columns to be distination node
            // its just as convention , you can do whatever way you like.
            int[][] adjm = new int[nodes.length][nodes.length];
            for (int i = 0; i < edges.length; i++) {
                int startingNode = edges[i][0];
                int destinationNode = edges[i][1];
                adjm[startingNode][destinationNode] = 1;
            }

            for (int i = 0; i < adjm.length; i++) {
                //  int destinationNode = edges[i][0];
                for (int j = 0; j < adjm[0].length; j++) {
                    System.out.print(adjm[i][j]+"  ");
                }
                System.out.println();
            }
            return adjm;
        }

}
