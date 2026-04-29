import java.util.*;
public class LengthLcsMemoization {
    static int[][] t;
        // remember n, m represents no String chars
        // thats why t[n][m] // it represents ans of problem having n, m elements
    static int lengthOfLcs(String s1, String s2, int n, int m){
        if(n==0 || m ==0){
            return 0;
        }
        if(t[n][m] !=-1)return t[n][m];
        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return t[n][m] = 1 + lengthOfLcs(s1, s2, n-1, m-1);
        }else{
            return t[n][m] = Math.max( lengthOfLcs(s1, s2, n-1, m), lengthOfLcs(s1, s2, n, m-1)) ;
        }
    }

    public static void main(String[] args){
        String s1 = "abcdgh";
        String s2 = "abedgha";
        t = new int[s1.length() +1][s2.length()+1];
        for(int i =0; i<t.length; i++){
            Arrays.fill(t[i], -1);
        }
        System.out.println(lengthOfLcs(s1, s2, s1.length(), s2.length()));
    }
}