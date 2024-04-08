package org.dsa.topics.mcm.tuf;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakProblem {
    //https://leetcode.com/problems/word-break/description/
   static Map<String,Boolean> hm = new HashMap<>();

    public static void main(String[] args) {
        String s = "ab";
        List<String> dict =Arrays.asList("a","b");
        System.out.println(wordBreak(s,dict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        hm = new HashMap<>();
        return solveWordBreak(s,wordDict,0,s.length()-1);
    }

    private static boolean solveWordBreak(String s, List<String> wordDict, int i, int j) {
        if(i>j) {
            return false;
        }
        if(wordDict.contains(s.substring(i,j+1))){
            return true;
        }
        String key = s+","+i+","+j;
        if(hm.containsKey(key)) {
            return hm.get(key);
        }
        boolean found = false;
        for (int k = i+1; k <= j && !found; k++) {
            String partA = s.substring(0,k);
            String partB = s.substring(k);
            boolean isPartAPresent = solveWordBreak(partA,wordDict,0,partA.length()-1);
            boolean isPartBPresent = solveWordBreak(partB,wordDict,0,partB.length()-1);
            found = found | (isPartAPresent & isPartBPresent);
        }
        hm.put(key,found);
        return found;
    }
}
