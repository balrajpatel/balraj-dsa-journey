import java.util.*;
class IsSubsequence {
    static int[][] dp;
    public static boolean isSubsequence(String s, String t) {
        dp = new int[s.length() +1][t.length() + 1];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return s.length() == lcs(s, t, s.length(), t.length())? true: false;

    }
    static int lcs(String s1, String s2, int n, int m){
        if(n ==0 || m ==0){
            return dp[n][m] =0;
        }
        if(dp[n][m] != -1)return dp[n][m];
        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return dp[n][m] = 1 + lcs(s1, s2, n-1, m-1);
        }else{
            return dp[n][m] = Math.max(
                lcs(s1, s2, n-1, m),
                lcs(s1, s2, n, m-1)
            );
        }
    }
    public static boolean isSubsequence1(String s, String t) {
        int j=0;
        for(int i=0 ;i<t.length() && j< s.length(); i++){
            if(s.charAt(j) == t.charAt(i)){
                j++;
            }
        }
        return j==s.length();

    }

    public static void main(String[] args){
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
        System.out.println(isSubsequence1(s, t));
    }
}