import java.util.*;
class LongestCommSubstrTabulation {
    static int maxlen =0;
    static int[][] t;
    public static int longCommSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        t = new int[n+1][m+1];

        return  longestCommonSubString(s1, s2, s1.length() + 1 , s2.length() + 1);

    }
    static int longestCommonSubString(String s1, String s2, int n, int m ) {
        for(int i=0; i<n; i++){
            t[i][0] = 0;
        }
        for(int j =0; j<m; j++){
            t[0][j] = 0;
        }
        for(int i =1; i<n; i++){
            for(int j =1; j<m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                    maxlen = Math.max(maxlen, t[i][j]);
                }
                else { 
                    t[i][j] = 0;
                }
            }
            
        }
        return maxlen;
    }
        public static void main(String[] args){
        String s1 = "ABCDGH";
        String s2 = "ACDGHR";
        System.out.println(longCommSubstr(s1, s2));
    }
}