package org.dsa.topics.recursion;

public class MaxUsingRecursion {

    //https://www.pepcoding.com/resources/online-java-foundation/recursion-in-arrays/max-of-an-array-official/ojquestion
    public static void main(String[] args) {
        int[] arr = {4,5,6,1,2};
        int z = maxOfArray(arr,0);
        System.out.println(z);
    }

    public static int maxOfArray(int[] arr, int idx){
        if(idx==arr.length-1) return arr[idx];
        return Math.max(arr[idx],maxOfArray(arr,idx+1));
    }
}
