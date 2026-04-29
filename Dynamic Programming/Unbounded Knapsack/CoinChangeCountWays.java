class CoinChangeCountWays {
    public static int count(int coins[], int sum) {
        // code here.
        return subsetSumUnbounded(coins,sum);
    }
    static int subsetSumUnbounded(int coins[], int sum){
        int n = coins.length +1;
        int m = sum + 1;
        
        int t[][] = new int[n][m];
        
        for(int i=0; i<n; i++){
            t[i][0] = 1;  
        }
        
        for(int j=1; j<m; j++){
            t[0][j] = 0;  
        }
        
        for(int i=1; i<n; i++){
            for(int j =1; j<m; j++){  //j=1 since coins value are >=1;
                if(coins[i-1] <=  j){
                    t[i][j] = t[i][j-coins[i-1]]  + t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[coins.length][sum];
    }

    public static void main(String[] args){
        int[] coins = new int[]{1, 2, 3};
        int sum =4;
        System.out.println(count(coins, sum));
    }
}
/*
518. Coin Change II
Solved
Medium
Topics
premium lock icon
Companies
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.

 

Example 1:

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10]
Output: 1
 

Constraints:

1 <= coins.length <= 300
1 <= coins[i] <= 5000
All the values of coins are unique.
0 <= amount <= 5000
/*