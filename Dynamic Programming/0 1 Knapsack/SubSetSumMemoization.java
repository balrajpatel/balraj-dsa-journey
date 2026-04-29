import java.util.*;
class SubSetSumMemoization {
    static Boolean[][] t; //since it allows NULL
    static Boolean isSubSetSum(int arr[], int sum) {
        // code here

        // more cleaner approach
        t = new Boolean[arr.length +1][sum + 1];
        for(int i=0; i<t.length; i++){
            Arrays.fill(t[i], null);
        }
        return solve(arr, arr.length, sum);
    }


    static int[][] dp;
    static Boolean isSubSetSum1(int arr[], int sum){
    // int approach is faster, since it avoids object overhead
        dp = new int[arr.length+1][sum+1];

        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve1(arr, arr.length, sum);

    }
    static Boolean solve(int arr[],int n, int sum){
        if(sum == 0 ){
            return t[n][sum] = true;
        }
        if(n == 0){
            return t[n][sum] = false;
        }
        
        if(t[n][sum]!=null){
            return t[n][sum];
        }
        
        if(arr[n-1] <= sum){
            return t[n][sum] = solve(arr, n-1, sum - arr[n-1]) || solve(arr, n-1, sum);
        }else{
            return t[n][sum] = solve(arr, n-1, sum);
        }
        
        
    }
    static boolean solve1(int[] arr, int n, int sum){
        if(sum == 0 ){
            return t[n][sum] = true;
        }
        if(n == 0){
            return t[n][sum] = false;
        }
        if(dp[n][sum] != -1){
            return dp[n][sum] == 1;
        }

        boolean result;

        if(arr[n-1] <= sum){
            result = solve1(arr, n-1, sum-arr[n-1]) 
                || solve1(arr, n-1, sum);
        } else {
            result = solve1(arr, n-1, sum);
        }

        dp[n][sum] = result ? 1 : 0;
        return result;
    }
    public static void main(String[] args){
        int[] arr = new int[]{2,34, 4, 12, 5, 2};
        int sum= 9;
        System.out.println(isSubSetSum(arr, sum));
        System.out.println(isSubSetSum1(arr, sum));
    }
}