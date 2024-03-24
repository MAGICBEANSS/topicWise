package org.dsa.topics.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationalSum {
    //https://takeuforward.org/data-structure/count-subsets-with-sum-k-dp-17/
    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        int target  = 8;
        List<List<Integer>> allCombinations = new ArrayList<>();
        combinationSum(arr,target,0,allCombinations,new ArrayList<>());
        allCombinations.stream().forEach(x->{
            System.out.println(x);
        });
    }

    public static void combinationSum(int[] candidates, int target,int i, List<List<Integer>> allCombinations,List<Integer> currentSolution) {
            if(i==candidates.length ||target<0){
                return ;
            }
            if(target==0) {
                allCombinations.add(new ArrayList<>(currentSolution));
                return;
            }
            int no = candidates[i];
            combinationSum(candidates,target,i+1,allCombinations,currentSolution);
            currentSolution.add(no);
            combinationSum(candidates,target-no,i,allCombinations,currentSolution);
            currentSolution.remove(currentSolution.size()-1);




    }
}
