import java.util.*;
class CountPartitionsWithDiffMemoization {
    static int[][] t;
    public static int countPartitions(int[] arr, int diff) {
        // code here
        int sum = 0;
        for(int x: arr){
            sum += x;
        }
        
        if( (sum + diff)%2!=0)return 0;
        
        
        
        int m = ((sum + diff)/2) + 1;
        
        t = new int[arr.length+1][m];
        
        for(int i =0; i<arr.length +1; i++){
            Arrays.fill(t[i], -1);
        }
        
        return countSubSetSum(arr, arr.length, (sum + diff)/2);
    }
    static int countSubSetSum(int[] arr, int n,  int sum){
        if(n == 0){
            if(sum == 0)
            {  return t[n][sum] = 1;}
            else{
                return t[n][sum] = 0;
            }
        }
        if(t[n][sum]!=-1)return t[n][sum];
        
        if(arr[n-1] <= sum){
            return t[n][sum] = 
                countSubSetSum(arr, n-1, sum- arr[n-1]) + countSubSetSum(arr, n-1, sum);
        }else{
            return t[n][sum] = countSubSetSum(arr, n-1, sum);
        }
        
    
    }

    public static void main(String[] args){
        int[] arr = new int[]{5,2, 6, 4};
        int diff = 3;
        System.out.println(countPartitions(arr, diff));
    }
}
