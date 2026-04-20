class TargetSum494 {
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
        return countPartionsSubsetSum(nums, (sum + target)/2);

    }
    static int countPartionsSubsetSum(int[] arr, int sum){
        int n = arr.length +1;
        int m = sum +1;
        int t[][] = new int[n][m];
        for(int i=0; i<n; i++){
            t[i][0] = 1;
        }
        for(int j=1; j<m; j++){
            t[0][j] = 0;
        }

        for(int i=1; i<n; i++){
            for(int j = 0; j<m; j++){
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j - arr[i-1]] + t[i-1][j];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[arr.length][sum];
    }
    public static void main(String[] args){
        int arr[] = new int[]{0, 0, 0, 0};
        int target = -0;
        int arr1[] = new int[]{1,1,1,1,1};
        int target1 = -3;
        System.out.println(findTargetSumWays(arr, target));
        System.out.println(findTargetSumWays(arr1, target1));
    }
}