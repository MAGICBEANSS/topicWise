package org.dsa.topics.old.stacks;

import java.util.Arrays;
import java.util.Stack;

public class NSR {
    public static void main(String[] args) {
        int[] data = {1,3,10,5,6,9,1};
        int[] result = findNSR(data);
        Arrays.stream(result).forEach(System.out::println);
    }

    private static int[] findNSR(int[] data) {
        int n = data.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(data[n-1]);
        int[] result = new int[n];
        result[n-1] = -1;
        for (int i = n-2; i >=0; i--) {
            int no = data[i];
            int sol = -1;
            boolean isNotFound = true;
            while (!stack.empty()&& isNotFound) {
             int x = stack.pop();
             if(x<no) {
                 isNotFound = false;
                 stack.push(x);
                 sol = x;
             }
            }
            stack.push(no);
            result[i] = sol;
        }
        return result;
    }
}
