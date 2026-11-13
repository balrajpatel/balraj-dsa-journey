import java.util.*;
public class TargetSum494 {
    public static int findTargetSumWays(int[] nums, int target) {
        return solve(0,nums, target, 0);

    }
    public static int solve(int current, int[] nums, int target, int sum){
        if(current == nums.length){
            if(target==sum){
                return 1;
            }
            return 0;
        }

        int pos = solve(current +1 , nums, target, sum + nums[current]);
        int neg = solve(current +1 , nums, target, sum - nums[current]);
        return pos + neg;
    }


    public static void main(String[] args) {

        int[][] testCases = {
            {1, 1, 1, 1, 1},
            {1},
            {1, 2, 3},
            {2, 3, 5},
            {0, 0, 0, 0, 0},
            {1, 2, 1}
        };

        int[] targets = {
            3,
            1,
            0,
            0,
            0,
            2
        };

        int[] expected = {
            5,
            1,
            2,
            2,
            32,
            2
        };

        for (int i = 0; i < testCases.length; i++) {

            System.out.println("Test Case " + (i + 1));

            System.out.println("Input: " +
                    Arrays.toString(testCases[i]));

            System.out.println("Target: " + targets[i]);

            int actual = findTargetSumWays(
                    testCases[i], targets[i]);

            System.out.println("Expected: " + expected[i]);
            System.out.println("Actual:   " + actual);

            System.out.println(
                    actual == expected[i] ? "PASS" : "FAIL"
            );

            System.out.println("--------------------------------");
        }
    }

}

/*  DYNAMIC PROGRAMMING SOLUTION...
public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int x: nums){
            sum += x;
        }
        target = Math.abs(target);
        // since if target = -ve we can get the ans with abs(target) since just have to reverse all signs of +ve target answers
        

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
        */