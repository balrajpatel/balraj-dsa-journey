import java.util.*;
class CoinChangeCountWaysMemoization {
    static int[][] t;
    public static int count(int amount, int[] coins) {
        t = new int[coins.length+1][amount+1];
        for(int i=0; i<t.length; i++){
            Arrays.fill(t[i], -1);
        }
      return subsetSumUnbounded(coins, coins.length, amount);  
    }
    static int subsetSumUnbounded(int coins[], int n,  int sum){
        if(sum ==0) return t[n][sum] = 1;
        if(n ==0) return t[n][sum] = 0;

        if(t[n][sum]!=-1){
            return t[n][sum];
        }
        if(coins[n-1] <= sum){
            return  t[n][sum]=  subsetSumUnbounded(coins, n, sum - coins[n-1]) + subsetSumUnbounded(coins, n-1, sum);  
            
        }
        else{
            return t[n][sum] = subsetSumUnbounded(coins, n-1, sum);
        }
    }
    public static void main(String[] args){
        int[] coins = new int[]{1, 2, 5};
        int sum =5;
        System.out.println(count(sum, coins));
    }
}