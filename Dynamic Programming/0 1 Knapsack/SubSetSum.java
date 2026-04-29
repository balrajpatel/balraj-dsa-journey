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
/*
Given an array of positive integers arr[] and a value sum, determine if there is a subset of arr[] with sum equal to given sum. 

Examples:

Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9
Output: true 
Explanation: Here there exists a subset with target sum = 9, 4+3+2 = 9.
Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 30
Output: false
Explanation: There is no subset with target sum 30.
Input: arr[] = [1, 2, 3], sum = 6
Output: true
Explanation: The entire array can be taken as a subset, giving 1 + 2 + 3 = 6.
Constraints:
1 <= arr.size() <= 200
1<= arr[i] <= 200
1<= sum <= 104
*/

