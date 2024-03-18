package org.dsa.topics.SlidingWindow.variablesiSizeSlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestKUniqueCharSubstring {
//https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
    public static void main(String[] args) {
        String S = "aabacbebebe";
        int k = 3;
        int z = longestkSubstr(S,k);
        System.out.println(z);

    }

    public static int longestkSubstr(String s, int k) {
        // code here
        int i=0,j=0;
        int n = s.length();
        int maxLength = -1;
        int originalKeys = k;


        Map<Character,Integer> lastIndexMap = new HashMap<>();
        while(j<n) {
            char ch = s.charAt(j);
            if(lastIndexMap.containsKey(ch)) {
                lastIndexMap.put(ch,j);
              //  maxLength = Math.max(maxLength,j-i+1);
            }
            else {
                int currentKeysCount = lastIndexMap.keySet().size();
                if((originalKeys-currentKeysCount)==1) {
                    lastIndexMap.put(ch,j);
                    k--;
                    maxLength = Math.max(maxLength,j-i+1);
                }
                if(currentKeysCount<originalKeys) {
                    lastIndexMap.put(ch,j);
                    k--;
                   // maxLength = Math.max(maxLength,j-i+1);
                }
                else {
                    boolean removedExistingCharacter  = false;
                    while (!removedExistingCharacter  && i<j) {
                        char charAtI = s.charAt(i);
                        int lastIndexOfElement = lastIndexMap.get(charAtI);
                        if(lastIndexOfElement==i) {
                            removedExistingCharacter = true;
                            lastIndexMap.remove(charAtI);
                            k++;
                        }
                        i++;
                    }
                    lastIndexMap.put(ch,j);
                    k--;
                    maxLength = Math.max(maxLength,j-i+1);
                }
            }
        j++;
        }
        return maxLength;
    }
}
