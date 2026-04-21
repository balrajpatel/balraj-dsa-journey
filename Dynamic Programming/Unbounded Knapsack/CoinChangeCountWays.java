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