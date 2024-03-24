package org.dsa.topics.recursion;

public class KthSymbolGrammer {

    //https://leetcode.com/problems/k-th-symbol-in-grammar/
    public static void main(String[] args) {
        System.out.println(kthGrammar(2,2,1,"0"));
    }

    public static int kthGrammar(int n, int k,int i , String str) {
        if(i==n) {
            return Integer.valueOf(new StringBuilder().append(str.charAt(k-1)).toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c: str.toCharArray()) {
            if(c=='0') {
                stringBuilder.append("01");
            }
            else if(c=='1') {
                stringBuilder.append("10");
            }
        }
        str = stringBuilder.toString();
        return kthGrammar(n,k,i+1,str);
    }
}
