import java.util.*;
public class HouseRobber198 {
    static int[] dp ;
    public static int rob(int[] nums) {
        dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        return solve(0,nums);
    }

    //gives the max profit obtained from current ownwards
    static int solve(int current, int[] nums ){
        if(current >=nums.length){
        return dp[nums.length] = 0;
        // if current == last+1, ==> no profit
        }

        if(dp[current]!=-1){
            return dp[current];
        }else {
            int take = 0, skip = 0;
            if(current+2< nums.length && dp[current+2]!=-1){
                take = nums[current] + dp[current+2];
            }else {
                take = nums[current] + solve(current+2, nums);
            }
            if(current + 1 <nums.length && dp[current+1]!=-1){
                skip = dp[current+1];

            }else {
                skip = solve(current+1, nums);
            }
        return dp[current] = Math.max(take, skip);
        }
    }

    public static void main(String[] args) {

        int[][] testCases = {
            {2, 7, 9, 3, 1},
            {1, 2, 3, 1},
            {2, 1, 1, 2},
            {1},
            {2, 7},
            {5, 3, 4, 11, 2},
            {0, 0, 0, 0},
            {10, 1, 1, 10}
        };

        int[] expected = {
            12,
            4,
            4,
            1,
            7,
            16,
            0,
            20
        };


        for (int i = 0; i < testCases.length; i++) {

            System.out.println("Test Case " + (i + 1));

            System.out.println("Input: " +
                    Arrays.toString(testCases[i]));

            System.out.println("Expected: " + expected[i]);

            int actual = rob(testCases[i]);

            System.out.println("Actual:   " + actual);

            System.out.println(
                    actual == expected[i] ? "PASS" : "FAIL"
            );

            System.out.println("--------------------------------");
        }
    }

}
/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400
 
Seen this question in a real interview before?
1/6
Yes
No
Accepted
3,956,171/7.4M
Acceptance Rate
53.7%
*/