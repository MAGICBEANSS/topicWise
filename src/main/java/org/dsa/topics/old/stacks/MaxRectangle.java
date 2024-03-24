package org.dsa.topics.old.stacks;

import java.util.Stack;

public class MaxRectangle {
    //https://www.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
    public static void main(String[] args) {
        //long[] arr = {7,2,8,9,1,3,6,5};
        long[] arr = {6,8};
        solveMaxRect(arr);
    }

    private static void solveMaxRect(long[] arr) {
        int n = arr.length;
        Stack<Long> leftStack = new Stack<>();
        Stack<Long> rightStack = new Stack<>();
        long[] solLeft = new long[n];
        long[] solRight = new long[n];
        leftStack.push(0l);
        rightStack.push(Long.valueOf(n-1));
        solRight[n-1] = -1;
        solLeft[0] = -1;
        for (int i = 1; i < n; i++) {
            long data = arr[i];
            long sol = -1;
            while (!leftStack.empty() && sol==-1){
                long topIndex = leftStack.pop();
                long top = arr[(int) topIndex];
                if(top<data) {
                    sol = topIndex;
                    leftStack.push(topIndex);
                }
            }
            leftStack.push(Long.valueOf(i));
            solLeft[i] = sol;
        }

        for (int i = n-1; i >=0; i--) {
            long data = arr[i];
            long sol = -1;
            while (!rightStack.empty() && sol==-1){
                long topIndex = rightStack.pop();
                long top = arr[(int) topIndex];
                if(top<data) {
                    sol = topIndex;
                    rightStack.push(topIndex);
                }
            }
            rightStack.push(Long.valueOf(i));
            solRight[i] = sol;
        }
        long max = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            //long lefti = solLeft[i]==-1L? 0L:solLeft[i];
            long lefti = solLeft[i];
            long righti = solRight[i]==-1L? n:solRight[i];
            long prod = arr[i]*(righti-lefti-1);
            max = Math.max(prod,max);
        }
        System.out.println(max);
    }
}
