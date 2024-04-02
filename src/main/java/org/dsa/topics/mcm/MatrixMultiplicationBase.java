package org.dsa.topics.mcm;

import java.util.Arrays;

public class MatrixMultiplicationBase {
    private static int[][] mat;
    public static void main(String[] args) {
        int[] arr = {10,5,40,20,10,15};
      //  int[] arr = {5,40,20};
        mat = new int[arr.length][arr.length];
        initDPMatrix(mat);
        int cost = solveMCMMemoized(arr,1,arr.length-1,0);

        //int cost = solve(arr,0,arr.length-1,0);
        System.out.println(cost);
    }

    private static void initDPMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            Arrays.fill(mat[i],-1);
        }
    }

    private static int solveMCM(int[] arr, int i, int j,int depth) {
        if(i>=j){
            return 0;
        }
        int cost = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int part1 = solveMCM(arr,i,k,depth+1);
            int part2 = solveMCM(arr,k+1,j,depth+1);

            /**
             * It "totalCost" solves cost of two matrices at consecutive indices i,k,j
             * say we have array {10,5,40,20,10,15} ,i=1, j =arr.length-1=5 then at k =i:j
             * for now say we are at k=1
             * , we may think that{10,5} will be solved then {40,20,10,15}, but here
             * at {10,5} k =1 , and i =1 , it will return 0.
             * So are we not calculating for {10,5} , actually we are but not here
             * we have done  arr[i-1]*arr[k]*arr[j];
             * so at that time it will be solved , how
             * see after calculating both the partitions
             * part1=>{10,5} and part 2=>{40,20,10,15}
             * here for part2 {40,20,10,15} ,
             * VVVIMP to note here is that first matrix here is 40x5
             * where does "5" come from it comes from k-1 , as every matrix at index x is with
             * dimesion arr[x-1]xarr[x]
             * at last we will have matrix of dimensions
             * 10x5 and 5x15 ==> which implies from current scneario
             * arr[i-1]xarr[k] and arr[k]x arr[j]
             * thus the formula             int extracost = arr[i-1]*arr[k]*arr[j];
             */

            int extracost = arr[i-1]*arr[k]*arr[j];

            int totalCost = part1+part2+extracost;
            cost= Math.min(cost,totalCost);
            if(depth==0) {
                System.out.println("For k="+k+" solution is "+totalCost+" part1="+part1+" part2="+part2+" extracost="+extracost);
            }
        }
        return cost;
    }


    private static int solveMCMMemoized(int[] arr, int i, int j,int depth) {
        if(i>=j){
            return 0;
        }
        if(mat[i][j]!=-1) {
            System.out.println("Not solving for i="+i+" and j="+j);
            return mat[i][j];
        }
        int cost = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int part1 = solveMCMMemoized(arr,i,k,depth+1);
            int part2 = solveMCMMemoized(arr,k+1,j,depth+1);
            int extracost = arr[i-1]*arr[k]*arr[j];
            int totalCost = part1+part2+extracost;
            cost= Math.min(cost,totalCost);
            if(depth==0) {
                System.out.println("For k="+k+" solution is "+totalCost+" part1="+part1+" part2="+part2+" extracost="+extracost);
            }
        }
        mat[i][j] = cost;
        return cost;
    }
}
