import java.util.*;
class CoinChangeIIMinCoinsMemoization {
    static int[][] t;
    public static int coinChange(int[] coins, int amount) {
        if(amount ==0)return 0;

        t = new int[coins.length + 1 ][amount+1];
        for(int i =0; i<t.length; i++){
            Arrays.fill(t[i], -1);
        }
        int ans = minCoins(coins, coins.length, amount);
        return (ans >= Integer.MAX_VALUE -1)? -1: ans;
    }
    static int minCoins(int coins[], int n, int sum){
        if(sum ==0){
            return t[n][sum] = 0;
        }
        if(n == 0){
            return t[n][sum] = Integer.MAX_VALUE -1 ;
        }
        if(t[n][sum]!= -1)return t[n][sum];

        if(coins[n-1] <= sum){
            return t[n][sum] = Math.min(
                1 + minCoins(coins, n, sum - coins[n-1]) ,  // when sum =0 we return 0 means no coins, so we add 1 for each coin added upto sum ==0.
                minCoins(coins, n-1, sum)
            );
        }else{
            return t[n][sum] = minCoins(coins, n-1, sum);
        }
    }
    public static void main(String[] args){
        int coins[] = new int[]{1, 2, 5};
        int amount = 11;
        int ans = coinChange(coins, amount);
        System.out.println(ans);
    }
}