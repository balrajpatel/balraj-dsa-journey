class Solution {
    public boolean canPartition(int[] nums) {
        int targetSum =0;

        for(int num: nums){
            targetSum+=num;
        }
        if(targetSum%2!=0)return false;  //since if totalsum =odd we can't divides into two

        targetSum /=2;  //since we want only half
        return isSubSetSum(nums, targetSum);
       
    }
    static boolean isSubSetSum(int[] nums, int sum){
        int n = nums.length + 1;;
        int m = sum + 1;
        boolean t[][] = new boolean[n][m];
        for(int i=0; i<n; i++){
            t[i][0] = true;

        }

        for(int j =1; j<m; j++){
            t[0][j] = false;
        }

        for(int i= 1; i < n; i++){
            for(int j =1; j < m; j++){
                if(nums[i-1] <= j){
                    t[i][j] = t[i-1][j-nums[i-1]] || t[i-1][j];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[nums.length][sum];
    }
}