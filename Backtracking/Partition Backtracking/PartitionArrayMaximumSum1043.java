import java.util.*;
public class PartitionArrayMaximumSum1043 {
    static int[] dp;
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        return solve( 0, arr, k);
    }
    static int solve(int start, int[] arr, int k){
        if(start == arr.length){
            return dp[arr.length] = 0;
        }
        if(dp[start]!= -1){
            return dp[start];
        }
        int delmax =0;
        int max =0;                     //**** remember start + k */

        for(int end = start; end<Math.min(start + k,arr.length); end++){
            delmax = Math.max(delmax, arr[end]);
            int count = end- start+1;
            int sum = count*delmax + solve(end+1, arr, k);
            max = Math.max(sum,max);
        }

        return dp[start] = max;
    }
    public static void main(String[] args) {

        int[][] testCases = {
                {1, 15, 7, 9, 2, 5, 10},
                {1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3},
                {1},
                {1, 2},
                {2, 2, 2, 2},
                {1, 1, 1, 1, 1},
                {5, 5, 5, 5, 5},
                {1, 2, 3, 4, 5},
                {5, 4, 3, 2, 1},
                {10, 1, 10, 1, 10},
                {1, 15, 7, 9, 2, 5, 10, 6, 3},
                {9, 8, 7, 6, 5, 4, 3, 2, 1},
                {100, 1, 1, 1, 100},
                {1, 100, 1, 100, 1},
                {2, 1, 4, 5, 3, 6, 7, 8}
        };

        int[] kValues = {
                3, 4, 1, 1, 2,
                3, 5, 2, 3, 2,
                4, 3, 2, 2, 4
        };

        int[] expected = {
            84,
            83,
            1,
            3,
            8,
            5,
            25,
            17,
            19,
            50,
            103,
            54,
            401,
            401,
            52
        };

        for (int i = 0; i < testCases.length; i++) {

            int actual = maxSumAfterPartitioning(testCases[i], kValues[i]);

            System.out.println("------------------------------------");
            System.out.println("Input    : " + Arrays.toString(testCases[i]));
            System.out.println("K        : " + kValues[i]);
            System.out.println("Expected : " + expected[i]);
            System.out.println("Actual   : " + actual);
            System.out.println("Result   : " +
                    (expected[i] == actual ? "PASS" : "FAIL"));
        }
    }
}