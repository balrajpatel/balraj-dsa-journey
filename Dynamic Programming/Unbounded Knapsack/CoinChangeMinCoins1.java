import java.util.*;

class CoinChangeMinCoins1 {
    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n + 1][amount + 1];

        // Initialization
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int j = 1; j <= amount; j++) {
            dp[0][j] = Integer.MAX_VALUE - 1;
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {

                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(
                        1 + dp[i][j - coins[i - 1]], // include coin
                        dp[i - 1][j]                // exclude coin
                    );
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int ans = dp[n][amount];
        return (ans >= Integer.MAX_VALUE - 1) ? -1 : ans;
    }

     public static void main(String[] args){
        int coins[] = new int[]{1, 2, 5};
        int amount = 11;
        int ans = coinChange(coins, amount);
        System.out.println(ans);
    }
}