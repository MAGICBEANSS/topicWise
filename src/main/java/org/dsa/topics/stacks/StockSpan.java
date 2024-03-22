package org.dsa.topics.stacks;

import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int N = 7;
        int price[] = {100, 80, 60, 70, 60, 75, 85};
        calculateSpan(price,N,new int[price.length]);
    }

    static void calculateSpan(int price[], int n, int S[]) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int stockToday = price[i];
            while (!stack.empty() && price[stack.peek()]<= stockToday){
                stack.pop();
            }
            if(stack.empty()) {
                S[i] = 1;
            }
            else  {
                S[i]  = i-stack.peek();
            }
            stack.push(i);

        }
        for (int i = 0; i < S.length; i++) {
            System.out.print(S[i]+" ");
        }

    }
}
