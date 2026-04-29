import java.util.*;
class PerfectSumMemoization {
    // Function to calculate the number of subsets with a given sum
          static int[][] t;
    
    public static int perfectSum(int[] nums, int target){
        t = new int[nums.length + 1][target + 1];
        
        for(int i = 0; i < t.length; i++){
            Arrays.fill(t[i], -1);
        }
        
        return targetSumSubsets(nums, nums.length, target);
    }
    
    static int targetSumSubsets(int[] arr, int n, int target){
        
       if(n == 0){
         return t[n][target] = (target == 0) ? 1 : 0;   //always store base cases
}

        
        if(t[n][target] != -1){
            return t[n][target];
        }
        
        if(arr[n-1] <= target){
            return t[n][target] = 
                targetSumSubsets(arr, n-1, target - arr[n-1]) +
                targetSumSubsets(arr, n-1, target);
        } else {
            return t[n][target] = 
                targetSumSubsets(arr, n-1, target);
        }
    }
    public static void main(String[] args){
        int[] arr = new int[]{5, 2, 3, 10, 6, 8};
        int target = 10;
        System.out.println(perfectSum(arr, target));
    }
   
}