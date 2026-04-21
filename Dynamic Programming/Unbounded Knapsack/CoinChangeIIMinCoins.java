class CoinChangeIIMinCoins {
    public static int coinChange(int[] coins, int amount) {
        return minCoins(coins, amount);
    }
    static int minCoins(int coins[], int sum){
        int n = coins.length +1;
        int m = sum + 1;
        
        int t[][] = new int[n][m];
        
        t[0][0] = 0;
        for(int i=1; i<n; i++){
            t[i][0] = 0;  
        }

        
        for(int j=1; j<m; j++){
            t[0][j] = Integer.MAX_VALUE - 1;  // since if we took Integer.MAX_VALUE then if we add 1 to it = Integer.MAX_VALUE+1 // > storage size
            // means it will be stored in negative no, that's why
        }
        if(coins.length>1){

            for(int j = 1; j<m; j++){
                if(coins[1] % j == 0){
                    t[1][j] = coins[1]/j;
                }
            }
        }
        
        for(int i=1; i<n; i++){
            for(int j =1; j<m; j++){  //j=1 since coins value are >=1;
                if(coins[i-1] <=  j){
                                        // choose the coin---  1 ( since 1 coin added)  //don't choose , so no coin added
                    t[i][j] =  Math.min( 1 +  t[i][j- coins[i-1]], t[i-1][j]);
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        int ans = t[coins.length][sum];
        if(ans == Integer.MAX_VALUE || ans == Integer.MAX_VALUE -1){
            return -1;
        }
        return ans;
    }
    public static void main(String[] args){
        int coins[] = new int[]{1, 2, 5};
        int amount = 11;
        int ans = coinChange(coins, amount);
        System.out.println(ans);
    }
}