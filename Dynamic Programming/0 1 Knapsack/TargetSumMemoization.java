import java.util.*;
class TargetSumMemoization {
    static int[][] t ;
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int x: nums){
            sum += x;
        }
        target = Math.abs(target);
        // since if target = -ve we can get the ans with abs(target) since just have to reverse all signs of +ve target answers
        /*
        since s1 - s2 = target
        so  s2- s1 = -target
        so just role reversal now we find s1, doesn't matter,
        */
        

        if(sum < target) return 0;     // if target > sum(arr)  then no partition possible
        if( (sum + target)%2!= 0)return 0;  // if it odd, no partition possible;
        return perfectSum(nums, (sum + target)/2);

    }

    public static int perfectSum(int[] nums, int target){
        t = new int[nums.length+1][target+1];
        for(int i =0; i<t.length; i++){
            Arrays.fill(t[i],-1);
        }
        return targetSumSubsets(nums, nums.length, target);
    }
    static int targetSumSubsets(int[] arr, int n, int target){
        if(n==0){
            return t[n][target] = target==0?1:0;
        }
        if(t[n][target]!=-1)return t[n][target];
        if(arr[n-1]<= target){
            t[n][target] = targetSumSubsets(arr, n-1, target - arr[n-1]) + targetSumSubsets(arr, n-1, target);
        }else{
            t[n][target] = targetSumSubsets(arr, n-1, target);
        }
        return t[n][target]!=-1? t[n][target]:0;
    }
    public static void main(String[] args){
        int arr[] = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(findTargetSumWays(arr, target));
    }
}


/*
494. Target Sum
Solved
Medium
Topics
premium lock icon
Companies
You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

 

Example 1:

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
Example 2:

Input: nums = [1], target = 1
Output: 1
 

Constraints:

1 <= nums.length <= 20
0 <= nums[i] <= 1000
0 <= sum(nums[i]) <= 1000
-1000 <= target <= 1000
*/