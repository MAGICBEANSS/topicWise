package org.dsa.topics.mcm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BurstBalloons {

    public static void main(String[] args) {
       int[] nums = {1,2,3,4,5};
        System.out.println(maxCoins(nums));
    }

    public static int maxCoins(int[] nums) {
            List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
      return   burstBaloonsEarn(list,0,list.size()-1,0);

    }

    private static int burstBaloonsEarn(List<Integer> list, int i, int j, int coins) {
//    private static int burstBaloonsEarn(int[] arr, int i, int j, int coins) {
            if(list.size()==0 || i> j) {
                return 0;
            }
            if(i==j) {
                int prev=1;
                if(i!=0) {
                    prev=list.get(i-1);
                }
                int next=1;
                if(i<list.size()-1) {
                    prev=list.get(i+1);
                }

                int cost =  prev*list.get(i)*next;
                return cost;
            }
            int maxCoins = Integer.MIN_VALUE;
        for (int k = i+1; k <= j; k++) {
            int left = burstBaloonsEarn(list,i,k-1,coins);
            int right = burstBaloonsEarn(list,k+1,j,coins);
            int prev = list.get(k - 1) * list.get(k) * list.get(k + 1);
            int cost = left*right*list.get(k);
            maxCoins = Math.max(cost,maxCoins);
        }
        return maxCoins;
    }
}
