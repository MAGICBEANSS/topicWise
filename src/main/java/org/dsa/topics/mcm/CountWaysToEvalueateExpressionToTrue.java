package org.dsa.topics.mcm;

import java.util.HashMap;
import java.util.Map;

public class CountWaysToEvalueateExpressionToTrue {
        private static Map<String,Integer> hm = new HashMap();
    public static void main(String[] args) {
        String str = "T^T^T^F|F&F^F|T^F^T";
        System.out.println(solveit(str));
    }

    private static int solveit(String str) {
        hm = new HashMap();
       return solveWaysUsingMemoization(str,0,str.length()-1,true);
    }

    private static int solveWaysUsingMemoization(String str, int i, int j, boolean isTrue) {
        if(i>j) {
            return 0;
        }
        if(i==j) {
            if(isTrue) return str.charAt(i)=='T' ? 1:0;
            if(!isTrue) return str.charAt(i)=='F' ? 1:0;
        }
        String key = i+","+j+","+isTrue;
        if (hm.containsKey(key)) {
            return hm.get(key);
        }
        int count = 0;
        for (int k = i+1; k < j; k+=2) {

            int lt = solveWaysUsingMemoization(str,i,k-1,true);
            int lf = solveWaysUsingMemoization(str,i,k-1,false);
            int rt = solveWaysUsingMemoization(str,k+1,j,true);
            int rf = solveWaysUsingMemoization(str,k+1,j,false);
            if(str.charAt(k)=='|') {
                if(isTrue) {
                    // ways to make it true
                    count = count+(lf*rt)+(lt*rt)+(lt*rf);
                }
                else {
                    count = count+(lf*rf);
                    // ways to make it false
                }
            }
            if(str.charAt(k)=='^') {
                if(isTrue) {
                    // ways to make it true
                    count = count+(lf*rt)+(lt*rf);
                }
                else {
                    count = count+(lf*rf)+(lt*rt);
                    // ways to make it false
                }
            }
            if(str.charAt(k)=='&') {
                if(isTrue) {
                    // ways to make it true
                    count = count+(lt*rt);
                }
                else {
                    count = count+(lf*rt)+(lf*rf)+(lt*rf);
                    // ways to make it false
                }
            }
        }
        hm.put(key,count);
        return count;
    }


}
