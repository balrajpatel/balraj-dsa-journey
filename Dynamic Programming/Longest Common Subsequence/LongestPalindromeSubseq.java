import java.util.*;
class LongestPalindromeSubseq {
    static int[][] t ;
    public static int longestPalindromeSubseq(String s) {
        String s1 = new StringBuffer(s).reverse().toString();
        t = new int[s.length() + 1][s1.length() +1];
        for(int i =0; i<t.length; i++){
            Arrays.fill(t[i], -1);
        }

        return lps(s, s1, s.length(), s1.length());

    }
    static int lps(String s1, String s2, int n , int m){
        if(n ==0 || m ==0){
            return t[n][m] = 0;
        }
        if(t[n][m] != -1){
            return t[n][m];
        }

        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return t[n][m] = 1 + lps(s1, s2, n-1, m-1);
        }else{
            return  t[n][m] = Math.max(
                lps(s1, s2, n-1, m),
                lps(s1, s2, n, m-1)
            );
        }
    }
    public static void main(String[] args){
        String s1 = "bbbab";
        System.out.println(longestPalindromeSubseq(s1));
    }

}