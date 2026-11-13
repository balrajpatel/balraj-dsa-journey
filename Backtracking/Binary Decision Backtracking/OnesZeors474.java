import java.util.*;
class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class OnesZeors474 {
    static int[][][] dp;
    public static int findMaxForm(String[] strs, int m, int n) {
        dp = new int[strs.length+1][m+1][n+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return largest(0,strs,m,n,0,0);
        
    }
    static int largest(int current, String[] strs, int m , int n,int delm, int deln){
        if(current >= strs.length){
            return dp[current][delm][deln] = 0;
        }

        if(dp[current][delm][deln]!=-1)return dp[current][delm][deln];


        int take = 0;
        int skip =0;

        Pair p = count(strs[current]);
        if( (delm + p.x <=m) && (deln + p.y <= n)){

            if(dp[current+1][delm + p.x][deln + p.y]!=-1 && current+1<strs.length){
                take = 1 + dp[current+1][delm+ p.x][deln + p.y];
                
            }else {
                take = 1 + largest(current + 1, strs, m,n, delm + p.x ,deln + p.y);
            }
        }
        if(current + 1< strs.length && dp[current+1][delm][deln]!=-1){
            skip = 0 + dp[current+1][delm][deln];

        }else{
        skip = 0 + largest(current +1, strs, m,n, delm, deln);
        }

        return dp[current][delm][deln] = Math.max(take, skip);
        
    }

    public static Pair count(String str){
        int x=0;
        int y =0;
        for(char ch: str.toCharArray()){
            if(ch=='0'){
                x++;
            }else {
                y++;
            }
        }
        return new Pair(x,y);
    }
    public static void main(String[] args) {

        String[][] testStrs = {
            {"10", "0001", "111001", "1", "0"},
            {"10", "0", "1"},
            {"10", "0001", "111001", "1", "0"},
            {"0", "0", "1"},
            {"1", "1", "1", "1"},
            {"0", "0", "0", "0"},
            {"10", "01", "001", "110"},
            {"0", "1", "01", "10", "001"}
        };

        int[] mValues = {5, 1, 3, 2, 5, 4, 3, 3};
        int[] nValues = {3, 1, 4, 1, 2, 0, 3, 3};

        int[] expected = {4, 2, 3, 3, 2, 4, 2, 4};

        System.out.println("========== TEST RESULTS ==========");

        for (int i = 0; i < testStrs.length; i++) {

            int actual = findMaxForm(
                testStrs[i],
                mValues[i],
                nValues[i]
            );

            System.out.println("\nTest Case " + (i + 1));
            System.out.println("Strings  : " + Arrays.toString(testStrs[i]));
            System.out.println("m        : " + mValues[i]);
            System.out.println("n        : " + nValues[i]);
            System.out.println("Expected : " + expected[i]);
            System.out.println("Actual   : " + actual);
            System.out.println("Status   : " +
                (actual == expected[i] ? "PASS" : "FAIL"));
        }
    }
}
/*
You are given an array of binary strings strs and two integers m and n.

Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.

A set x is a subset of a set y if all elements of x are also elements of y.

 

Example 1:

Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
Output: 4
Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
{"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.
Example 2:

Input: strs = ["10","0","1"], m = 1, n = 1
Output: 2
Explanation: The largest subset is {"0", "1"}, so the answer is 2.
 

Constraints:

1 <= strs.length <= 600
1 <= strs[i].length <= 100
strs[i] consists only of digits '0' and '1'.
1 <= m, n <= 100
*/
