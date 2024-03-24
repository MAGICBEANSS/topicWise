package org.dsa.topics.old.stacks;

import java.util.Stack;

public class MaxiMumIndex {
    //https://www.geeksforgeeks.org/problems/maximum-index-1587115620/1
    public static void main(String[] args) {
        int[] a = {34,8,10,3,2,80,30,33,1};
      //  int[] a = {12,11,10,9};
       // int[] a = {12};
      //  int[] a = {1,10};
     //   int[] a = {1,10,11,12};
      //  int[] a = {29, 29, 8, 1, 26, 10, 1, 22, 14, 26};
     //   int[] a = {28, 19, 21 ,14 ,24 ,22 ,16, 15, 22, 16 ,22, 19, 27, 8 ,27};

        int n =a.length;
        int sol = solveit(a,n);
        System.out.println("sol="+sol);
    }

    private static int solveit(int[] a, int n) {
        Stack<Integer> stack = new Stack<>();
        int previ = 0;
        int sol = Integer.MIN_VALUE;

        //  int fi
        stack.push(n-1);
        for (int i = n-1; i >=0; i--) {
            if(a[stack.peek()]<a[i]){
                stack.push(i);
            }
        }
        int previousFind = -1;
        for (int i = 0; i < n && !stack.empty(); i++) {
            previousFind = i;
            boolean isNoMoreGreaterFound = false;
            while (!stack.empty() && !isNoMoreGreaterFound) {
                int currTopIndex = stack.peek();
                if(currTopIndex>i) {
                    if (a[currTopIndex] >= a[i]) {
                        previousFind = currTopIndex;
                        stack.pop();
                    } else {
                        isNoMoreGreaterFound = true;
                      //  sol = Math.max(sol, previousFind - i);
                    }
                }
                else {
                    stack.pop();
                    isNoMoreGreaterFound = true;
                }

            }
            sol = Math.max(sol, previousFind - i);

        }

        if(previousFind==-1) previousFind=0;
        return sol;

    }
}
