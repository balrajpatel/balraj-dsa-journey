import java.util.*;
class LongestComSubstrMemoization {
    static int maxlen =0;
    static int[][] t;
    public static int longCommSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        t = new int[n+1][m+1];
        for(int i =0; i<n+1; i++){
            Arrays.fill(t[i], -1);
        }
        longestCommonSubString(s1, s2, s1.length(), s2.length());
        return maxlen;
    }
    static int longestCommonSubString(String s1, String s2, int n, int m ) {
        if(n ==0 || m ==0 ){
            return t[n][m] = 0;
        }
        if(t[n][m] !=-1) return t[n][m];
        
        int count =0;
        if(s1.charAt(n-1) == s2.charAt(m-1)){
            count = 1 + longestCommonSubString(s1, s2, n-1, m-1);
            maxlen = Math.max(count, maxlen);
        }else{
           count = 0;
        }
        longestCommonSubString(s1, s2, n-1, m);
        longestCommonSubString(s1, s2, n, m-1);
        return t[n][m] = count;
    }
    public static void main(String[] args){
        String s1 = "ABCDGH";
        String s2 = "ACDGHR";
        System.out.println(longCommSubstr(s1, s2));
    }
}
/*
t[n][m] stores → length of the longest common suffix
of the substrings:
s1 = "abcde"
s2 = "abfde"

At (n=5, m=5) → comparing 'e' and 'e'

Matching chain: "de"
So:
t[5][5] = 2

Because "de" is the longest common suffix ending at those positions
 Key Insight (VERY IMPORTANT)

t[n][m] is NOT:

overall answer
longest substring anywhere

It is:

longest common substring ending exactly at (n-1, m-1) 
Relation

If characters match:

t[n][m] = 1 + t[n-1][m-1]

Else:

t[n][m] = 0  reset (this is what makes it substring)
 Final Answer comes from:
maxLen = max of all t[i][j]
*/