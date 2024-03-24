package org.dsa.topics.DP;

import java.util.Arrays;

public class MinimumSumPartition {
    private static int minSum = Integer.MAX_VALUE;
    public static void main(String[] args) {
       // 1, 4
        int arr[] = {-36, 36};
     //   int arr[] = {1, 6, 11, 5};
        int z = minDifference(arr,arr.length);
        System.out.println(z);
    }

    private static int minSumPartition(int[] arr, int i,int totalsum,int sumTillNow) {
        int n = arr.length;

      /*  if((totalsum-sumTillNow)<0){
            System.out.println("Lafda h ?");
        }*/
        if(i>=n) {
            int sumLeft = totalsum-sumTillNow;
            if(sumLeft>sumTillNow) {
                return sumLeft-sumTillNow;
            }
            else {
                return sumTillNow-sumLeft;
            }
         //   return Math.abs(sumLeft-sumTillNow);
        }
        else {
            return Math.min(
                    minSumPartition(arr, i + 1, totalsum, sumTillNow),
                    minSumPartition(arr, i + 1, totalsum, sumTillNow + arr[i])
            );
        }
    /*    int firstPartitonSumUsingIt = sumTillNow+arr[i];
        int firstPartitonSumWithoutUsingIt = sumTillNow;
        int secondParitionSumUsingIt = totalsum-(sumTillNow+arr[i]);
        int secondParitionSumWithoutUsingIt = totalsum-(sumTillNow);
        int minOnIt = Math.min(
                Math.abs(firstPartitonSumUsingIt-secondParitionSumUsingIt),
                Math.abs(firstPartitonSumWithoutUsingIt-secondParitionSumWithoutUsingIt)
                );
        System.out.println("sumUsingIt for i="+i+" is "+minOnIt+" minSum="+minSum);
        minSum = Math.min(minSum,minOnIt);*/


        //    System.out.println("sumUsingIt for i="+i+" is "+minSum);
   //     System.out.println("sumUsingIt for i="+i+" is "+sumUsingIt);
     //   System.out.println("sumWithoutUsingIt for i="+i+" is "+sumWithoutUsingIt);


    }

    public static int minDifference(int arr[], int n)
    {
        int totalSum = Arrays.stream(arr).sum();
       minSum=  minSumPartition(arr,0,totalSum,0);
         return minSum;
        // Your code goes here
    }

}
