package org.dsa.topics.old.stacks;

import java.util.Stack;

public class TrappingRainwater {
   // https://leetcode.com/problems/trapping-rain-water/
    public static void main(String[] args) {
        int[] data ={4,2,3};
    //    int[] right = findNGR(data);
    //    int[] left = findNGL(data);
    //    int result = findSol(left,right,data);
        int result = sol(data);
        System.out.println(result);

    }


    private static int findSol(int[] ngl,int[] ngr,int[] data) {
        int n = data.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if(ngl[i]!=-1 && ngr[i]!=-1) {
                int minHeight = Math.min(data[ngl[i]], data[ngr[i]]);
                sum += Math.max(0, minHeight - data[i]);
            }
        }
        return sum;
    }

    private static int[] findNGL(int[] data) {
        int n = data.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int[] result = new int[n];
        result[0] = -1;
        for (int i = 1; i <n; i++) {
            int no = data[i];
            int sol = -1;
            while (!stack.empty() && sol == -1) {
                int top = stack.pop();
                if (data[top] > no) {
                    sol = top;
                    stack.push(top);
                }
            }
            stack.push(i);
            result[i] = sol;
        }
        return result;
    }

    private static int[] findNGR(int[] data) {
        int n = data.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(n - 1);
        int[] result = new int[n];
        result[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            int no = data[i];
            int sol = -1;
            while (!stack.empty() && sol == -1) {
                int top = stack.pop();
                if (data[top] > no) {
                    sol = top;
                    stack.push(top);
                }
            }
            stack.push(i);
            result[i] = sol;
        }
        return result;
    }

    private static int sol(int[] data) {
        int n = data.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(n - 1);
        int[] result = new int[n];
        result[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            int no = data[i];
            int sol = -1;
            while (!stack.empty() && sol == -1) {
                int top = stack.pop();
                if (data[top] >= no) {
                    sol = top;
                    stack.push(top);
                }
            }
            stack.push(i);
            result[i] = sol;
        }
        int findFirstNonZeroIndex = -1;
        for (int i = 0; i < n; i++) {
            if (data[i] > 0) {
                findFirstNonZeroIndex = i;
                break;
            }
        }
        int sum = 0;
        for (int i = findFirstNonZeroIndex; i < n; i++) {
            int cval = data[i];
            int toindex = result[i];
            if (toindex == -1 ) continue;
            else {
            //    fillCurrentOne(toindex,cval);
               // sum+= Math.max(0,data[toindex]-cval);
                int toFill  = Math.min(cval,data[toindex]);
                for (int j = i + 1; j < toindex; j++) {
                    sum += toFill - data[j];
                }
            }
            //
            i = toindex-1;
        }
        return sum;
    }

}
