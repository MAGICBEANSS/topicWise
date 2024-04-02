package org.dsa.topics.mcm;

import java.util.Objects;

public class ScrambledStrings {

    public static void main(String[] args) {
        // great , grtea
        // great , grtae
        // great , greta
        // great , grate
        // great , graet
        String a = "great";
        String b = "grate";
        System.out.println(solveSS(a,b));
    }

    private static boolean solveSS(String a, String b) {
        if((Objects.isNull(a)&& Objects.isNull(b))||(a.length()==0&& b.length()==0)||b.equals(a)) {
            return true;
        }
        if(Objects.isNull(a) || Objects.isNull(b)||a.length()!=b.length()) {
            return false;
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
        return result;


    }

    private static boolean solveNotSwapped(String a, String b, int k) {
        String aleft = a.substring(0,k+1);
        String aright = a.substring(k+1);
        String bleft = b.substring(0,k+1);
        String bright = b.substring(k+1);

        if(solveSS(aleft,bleft) && solveSS(aright,bright)) {
            return true;
        }
        return false;
    }

    private static boolean solveSwap(String a, String b, int k) {
        int partitionForB = b.length()-k;
        String aleft = a.substring(0,k+1);
        String aright = a.substring(k+1);
        String bleft = b.substring(0,partitionForB+1);
        String bright = b.substring(partitionForB+1);

        if(solveSS(aleft,bright) && solveSS(aright,bleft)) {
           return true;
        }
        return false;

    }
}
