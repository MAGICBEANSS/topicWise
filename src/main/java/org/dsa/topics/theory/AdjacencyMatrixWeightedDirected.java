package org.dsa.topics.theory;

public class AdjacencyMatrixWeightedDirected {

    public static void main(String[] args) {
        int n =3, m=2;
        int[][] edges = {{2,1,5},{2,0,10}};
        printAdjacency(n,m,edges);
    }


        public static int[][] printAdjacency(int n, int m, int[][] edges) {
            // Write your code here.

            int[] nodes = new int[n];
            for (int i = 0; i < edges.length; i++) {
                for (int j = 0; j < 2; j++) {
                    int no = edges[i][j];
                    nodes[no] = no;
                }
            }
            // here we have third part in edges array {a,b,c}
            //  a-> starting node [0][0]
            //  b-> destination node [0][1]
            //  c-> weight edges[0][2]
            // so we assign wight to the value of each cell in matrix
            //   adjm[startingNode][destinationNode] = wt
            int[][] adjm = new int[nodes.length][nodes.length];
            for (int i = 0; i < edges.length; i++) {
                int startingNode = edges[i][0];
                int destinationNode = edges[i][1];
                adjm[startingNode][destinationNode] = edges[0][2];
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
