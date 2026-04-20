class CountPartitionsWithDiff {
    public static int countPartitions(int[] arr, int diff) {
        // code here
        int sum = 0;
        for(int x: arr){
            sum += x;
        }
        
        if( (sum + diff)%2!=0)return 0;
        return countSubSetSum(arr, (sum + diff)/2);
    }
    static int countSubSetSum(int[] arr, int sum){
        int n = arr.length + 1;
        int m = sum +1;
        
        int[][] t =  new int[n][m];
        
        for(int i =0; i<n; i++){
            t[i][0] = 1;    
        }
        
        for(int j =1; j<m; j++){
            t[0][j] = 0;
        }
        
        for(int i=1; i<n; i++){
            for(int j =0; j<m; j++){
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j -arr[i-1]]  + t[i-1][j];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        
        return t[arr.length][sum];
    }
    public static void main(String[] args){
        int[] arr = new int[]{1, 1, 1, 1};
        int diff =0;
        System.out.println(countPartitions(arr, diff));
    }
}
