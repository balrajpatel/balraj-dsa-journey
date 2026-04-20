public class SubSetSum{
    static boolean isSubSetSum(int arr[], int sum){
        int n = arr.length +1;
        int m = sum +1;
        boolean t[][] = new boolean[n][m];

        // Initialization
        for(int i=0; i<n; i++){
            t[i][0] = true; // sum =0 True since empty set  
        }
        for(int j=1; j<sum; j++){
            t[0][j] = false; // no of elements =0 so we con't get ==sum so always False;
        }
        for(int i =1; i<n; i++){
            for(int j=1; j<m; j++){
                if(arr[i-1]<= j){
                    t[i][j] = t[i-1][j - arr[i-1]] || t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[arr.length][sum];

    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,34, 4, 12, 5, 2};
        int sum= 9;
        System.out.println(isSubSetSum(arr, sum));
    }
}