package org.dsa.topics.old.stacks;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {

    //https://leetcode.com/problems/car-fleet/
    public static void main(String[] args) {
      /*  int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        int target = 12;*/
        int[] position = {0,2,4};
        int[] speed = {4,2,1};
        int target = 100;
        findSol(position,speed,target);
    }
    public static void findSol(int[] position,int[] speed,int target) {
        int n = speed.length;
        sortArrays(position, speed);
        int[] totime= new int[n];
        for (int i = 0; i < n; i++) {
            totime[i] = (target-position[i])/speed[i];
        }
        System.out.println("Sorted Position Array: " + Arrays.toString(position));
        System.out.println("Corresponding Speed Array: " + Arrays.toString(speed));
        System.out.println("Corresponding Time Array: " + Arrays.toString(totime));
        Stack<Integer> stack = new Stack<>();
        boolean[] collision = new boolean[n];

        stack.push(n-1);
        int count = 0;
        for (int i = n-2; i >=0 ; i--) {
            int curr = totime[i];
            boolean foundGreater = false;
            while (!stack.empty() && !foundGreater) {
                int topelementIndex =stack.pop();
                if(totime[topelementIndex]>=curr) {
                    foundGreater = true;
                    count++;
                    if(collision[topelementIndex]) {
                        count--;
                    }
                    stack.push(topelementIndex);
                    collision[i] = true;
                }
            }
            stack.push(i);
        }
        System.out.println(n-count);
    }

    public static int carFleet(int target, int[] position, int[] speed,int[] totime) {
        return 0;
    }

    public static void sortArrays(int[] position, int[] speed) {
        int n = position.length;

        // Create an array of pairs to store position-speed pairs
        int[][] pairs = new int[n][2];

        // Populate the pairs array with position-speed pairs
        for (int i = 0; i < n; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        // Sort the pairs array based on position
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        // Update the position and speed arrays based on the sorted pairs
        for (int i = 0; i < n; i++) {
            position[i] = pairs[i][0];
            speed[i] = pairs[i][1];
        }
    }

}
