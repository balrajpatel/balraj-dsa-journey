// User function Template for Java
import java.util.*;
class LongestRepeatingSubsequence {
    static int[][] t;
    public static int longestRepeatingSubsequence(String s) {
        // code here
        int n = s.length() + 1;
        int m = s.length() + 1;
        t = new int[n][m];
        for(int i=0; i<t.length; i++){
            Arrays.fill(t[i], -1);
        }
        return lps(s, s, s.length(), s.length());
    }
    
    static int lps(String s1, String s2, int n, int m){
        if(n ==0 || m == 0){
            return t[n][m]= 0;
        }
        if(t[n][m] !=-1){
            return t[n][m];
        }
        if(s1.charAt(n-1) == s2.charAt(m-1) && n != m){ // for lps we want the longest subsequence should be such that i !=j
        // i from s1 and j from s2;  // since s1 and s2 are same; //so if i!=j (codn for lps given that indices should be different)
        //  and both chars are equal
        // means they (chars) occured more then once (since s1 s2 are same);
        
            return t[n][m] = 1 + lps(s1, s2, n-1, m-1);
        }
        else{
            return t[n][m] = Math.max(
                lps(s1, s2, n-1, m),
                lps(s1, s2, n, m-1)
            );
        }
    }

    public static void main(String[] args){
        String s = "axxxy";
        System.out.println(longestRepeatingSubsequence(s));

    }
    
}