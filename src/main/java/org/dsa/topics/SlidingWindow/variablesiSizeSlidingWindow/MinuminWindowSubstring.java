package org.dsa.topics.SlidingWindow.variablesiSizeSlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinuminWindowSubstring {

    //https://leetcode.com/problems/minimum-window-substring/

    public static void main(String[] args) {
      //  String s = "ADOBECODEBANC", t = "ABC";
        String s = "bdab", t = "ab";
        String result = minWindow(s,t);
        System.out.println(result);
    }


    public static String minWindow(String s, String t) {
        int i =0;
        int j =0;
        int minLength = Integer.MAX_VALUE;
        String result = "";
        Map<Character,Integer> smallMap = new HashMap<>();
        Map<Character,Integer> currentMap = new HashMap<>();
        for (int k = 0; k < t.length(); k++) {
            int count = smallMap.getOrDefault(t.charAt(k),0);
            smallMap.put(t.charAt(k),count+1);
        }

        while (j<s.length()) {
            char ch = s.charAt(j);
            currentMap.put(ch,currentMap.getOrDefault(ch,0)+1);
            boolean isSameMap = compareMaps(currentMap,smallMap);
            if(isSameMap) {
                // we are runnig this i loop to increment value if i , such that we minimize the substring
                // so we keep on increasing i , if charAti is not siginificant i.e. not present in original map
                // we can delete it and minimize the arr .
                //if i is significant i.e. is present in map , we can check the frequency , if that too matches , we cannot
                // move further as this that is required to keep the maps same and comparemaps return true;

                int oldi =i;
                boolean stop = false;
                while (i<=j && !stop) {
                   // i++;
                    char charati = s.charAt(i);
                    if(smallMap.containsKey(charati)) {
                        int originalfrequence = smallMap.get(charati);
                        int currentFrequency = currentMap.get(charati);
                        if(currentFrequency>originalfrequence) {
                            int currCount = currentMap.get(charati);
                            currentMap.put(charati,currCount-1);
                        }
                        else {
                            stop = true;

                            // e.g.ADOBECODEBANC  , ABC
                            // right now i is at postion where we have the char which is present in
                            // original map too,and we are considering this as possible candidate for solution
                            // we have made stop= true;
                            //
                            // move i to the position where it will be no longer a valid solution , so that
                            // we keep on finding the next , we need to keep on removing items from current window too
                            // as it is already having all the elements matching , so even for next index of j
                            // it will be  same , which is not ideal for our calculations
                            // for e..g . at ADOBEC we have ABC matched up , now when j moves to next index
                            // ie.e substring is ADOBECO and "O" being the new character , for this also
                            // map will be containing all the elements this a match , but it no longer makes sense
                            // as we have to find minimum , so lets make it invalid from behind , as we may find solutions
                            // ahead as j grows
                            //  so we will move i from current position to next position whereby comparemaps starts returning
                            // false ,
                            // now we removed from behind so new substring is suppose DOBECO , and comparemaps will give false
                            // for this , so even if we keep i till here , its fine
                            // but we can improve further if you see ,
                            // the DOBECO , if we remove from behind more elements , i.e .first D then O
                            // it wont matter , as any how we are reducing the size of current window and we need to find maximum
                            // so this is good .
                            // so now at BECO, we can't move i any further , why ? , because "B" is present in original pattern
                            // so we can't remove this , as keeping this B intact we may find "A"   in the array ahead ,
                            // and that will be a potential solution

                            // as this is required,
                            // and i points to previous index of required window
                            // we move it back
                           // i = i-1;
                            if((j-i+1)<minLength) {
                                result = s.substring(i,j+1);
                                minLength = j-i+1;
                            }
                            // starting from next index move i to new position where it is just previous to a significant char
                            //significamt char is something present in smallMap;
                            decrementOrRemove(currentMap,s.charAt(i));
                            i=i+1;
                            while (i<=j && !smallMap.containsKey(s.charAt(i))) {
                                decrementOrRemove(currentMap,s.charAt(i));
                                i++;
                            }
                            i--;
                        }
                    }
                    else {
                        decrementOrRemove(currentMap,charati);
                       /* int currCount = currentMap.get(charati);
                        if(currCount==1) {
                            currentMap.remove(charati);
                        }
                        else {
                            currentMap.put(charati,currCount-1);
                        }*/
                    }
                    i++;
                }
                /*if((j-i)<minLength) {
                    result = s.substring(i+1,j+1);
                    minLength = j-i;
                }*/
            }


            j++;}
        return result;
    }

    static void decrementOrRemove(Map<Character, Integer> hm, char ch) {
        int count = hm.getOrDefault(ch,1);
        if(count==1) hm.remove(ch);
        else hm.put(ch,count-1);
    }


    static boolean compareMaps(Map<Character,Integer> current,Map<Character,Integer> original) {
        for (Character c: original.keySet()) {
            if(!current.containsKey(c) || current.get(c).intValue()<original.get(c).intValue()) return false;
        }
        return true;
    }
}
