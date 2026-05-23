// User function Template for Java
import java.util.*;
class MinInsDel {
    static int t[][];
    public static int minOperations(String s1, String s2) {
        // Your code goes here
        t = new int[s1.length() +1][s2.length() + 1];
        for(int i =0; i<t.length; i++){
            Arrays.fill(t[i], -1);
        }
        
        int len = lcs(s1, s2, s1.length(), s2.length());
        int deletions = s1.length() - len;
        int insertions = s2.length() - len;
        return insertions + deletions;
    }
    
    static int lcs(String s1, String s2, int n , int m){
        if(n ==0 || m == 0){
            return t[n][m] = 0;
        }
        if(t[n][m] != -1)return t[n][m];
        
        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return t[n][m] = 1 + lcs(s1, s2, n-1, m-1);
        }else{
            return t[n][m] = Math.max(
                lcs(s1, s2, n-1,m),
                lcs(s1, s2, n, m-1)
                );
        }
    }
    public static void main(String[] args){
        String s2 = "heap";
        String s1 = "pea";
        System.out.println(minOperations(s2, s1));
    }
}