package org.dsa.topics.old.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AsteroidCollision {
    //https://www.geeksforgeeks.org/problems/asteroid-collision/1
    public static void main(String[] args) {
        int[] asteroids = {-10,10};
        int n = asteroids.length;
        game(asteroids,n);
    }
   /* private static void gameplay(int[] arr, int n) {
        findMax()

    }*/
    private static int[] game(int[] arr, int n) {
        if (n==0||n==1) return new int[n];
        Stack<Integer> pstack = new Stack<>();
        Stack<Integer> nstack = new Stack<>();
        Stack<Integer> solstack = new Stack<>();
        List<Integer> sol = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int no = arr[i];
            boolean bhasmit = true;
            if(no<0) {
                while (!solstack.empty() && bhasmit) {
                    int top = solstack.pop();
                    if(top>Math.abs(no)) {
                       bhasmit = false;
                       solstack.push(top);
                    } else if (top==Math.abs(no)) {
                        bhasmit = false;
                    }
                }
                if(solstack.empty()) {
                    sol.add(no);
                }
            }
            else {
                solstack.push(arr[i]);
            }


        }
        Stack<Integer> rem = new Stack<>();
        while (!solstack.empty()){
            rem.push(solstack.pop());
        }
        while (!rem.empty()) {
            sol.add(rem.pop());
        }
        for (int j = 0; j < sol.size(); j++) {
            System.out.print(sol.get(j)+",");
        }
        return  sol.stream().mapToInt(i -> i).toArray();



/*        for (int i = 0; i < n; i++) {
            if(arr[i]>0) pstack.push(i);
        }
        for (int i = 0; i < n; i++) {
            if(arr[i]<0) nstack.push(i);
        }

        int[] leftG = findNextGreaterPositiveLeft(arr);*/
    }

    private static int[] findNextGreaterPositiveLeft(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> pstack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int no = arr[i];
            if(no>0) {
                pstack.push(i);
                result[i] = 0;
            }
            else {
                int sol = -1;
                while (!pstack.empty() && sol==-1){
                    int pi = pstack.pop();
                    int top = arr[pi];
                    if(top>no) {

                    }
                }
              //  result[]
            }
        }
        return null;
    }
}
