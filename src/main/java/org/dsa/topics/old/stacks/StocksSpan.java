package org.dsa.topics.old.stacks;

import java.util.Arrays;
import java.util.Stack;

public class StocksSpan {
//https://www.geeksforgeeks.org/the-stock-span-problem/
    public static void main(String[] args) {
        long[] data = {100,80,60,70,60,75,85};
        int[] result = findNGL(data);
        Arrays.stream(result).forEach(System.out::println);
    }

    private static int[] findNGL(long[] data) {
        int n = data.length;
        int[] result = new int[n];
        result[0] = 1;
        int sol  = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < n; i++) {
            sol = -1;
            long no = data[i];
            while (sol==-1 && !stack.empty()){
                int index = stack.pop();
                long high = data[index];
                if(high>no) {
                    sol = i-index;
                    stack.push(index);
                }
            }
            stack.push(i);
            result[i] = sol;
        }
        return result;
    }
}
