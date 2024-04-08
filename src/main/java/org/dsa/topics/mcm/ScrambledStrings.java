package org.dsa.topics.mcm;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ScrambledStrings {

   static Map<String,Boolean> hm = new HashMap<>();
    public static void main(String[] args) {
        // great , grtea
        // great , grtae
        // great , greta
        // great , grate
        // great , graet
        String a = "abcde";
        String b = "caebd";
        hm = new HashMap<>();
        System.out.println(solveSS(a,b));
    }

    private static boolean solveSS(String a, String b) {
        if((Objects.isNull(a)&& Objects.isNull(b))||(a.length()==0&& b.length()==0)||b.equals(a)) {
            return true;
        }
        if(Objects.isNull(a) || Objects.isNull(b)||a.length()!=b.length()) {
            return false;
        }
        String key = new StringBuilder(a).append(b).toString();
        if(hm.containsKey(key)) {
            System.out.println("Saving call");
            return hm.get(key);
        }
        boolean result = false;
        for (int k = 1; k < a.length(); k++) {
            result = solveSwap(a,b,k);
            if(result) {
                break;
            }
            result = result | solveNotSwapped(a,b,k);
            if(result) {
                break;
            }
        }
        hm.put(key,result);
        return result;


    }

    private static boolean solveNotSwapped(String a, String b, int k) {
        String aleft = a.substring(0,k);
        String aright = a.substring(k);
        String bleft = b.substring(0,k);
        String bright = b.substring(k);

        if(solveSS(aleft,bleft) && solveSS(aright,bright)) {
            return true;
        }
        return false;
    }

    private static boolean solveSwap(String a, String b, int k) {
        int partitionForB = b.length()-k;
        String aleft = a.substring(0,k);
        String aright = a.substring(k);
        String bleft = b.substring(0,partitionForB);
        String bright = b.substring(partitionForB);

        if(solveSS(aleft,bright) && solveSS(aright,bleft)) {
           return true;
        }
        return false;

    }
}
