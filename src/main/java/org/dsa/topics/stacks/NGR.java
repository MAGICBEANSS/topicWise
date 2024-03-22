package org.dsa.topics.stacks;

import java.util.Stack;

public class NGR {
    public static void main(String[] args) {
        int[] arr = {1,12,9,10,11,5,15,9,8,10};
        findNGR(arr,arr.length);
    }

    private static void findNGR(int[] arr, int length) {
        Stack<Integer> stack = new Stack<>();
        int[] sol = new int[length];
        for (int i = length-1; i >= 0; i--) {
            int no = arr[i];
                while (!stack.empty() && stack.peek()<=no) {
                    stack.pop();
                }
                if(stack.empty()) {
                    sol[i]=-1;
                }
                else {
                    sol[i] = stack.peek();
                }
            stack.push(no);
        }
        for (int i = 0; i < sol.length; i++) {
            System.out.print(sol[i]+" ,");
        }
    }
}
