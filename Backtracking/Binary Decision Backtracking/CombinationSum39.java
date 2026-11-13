import java.util.*;
public class CombinationSum39 {
     public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        solve(0, candidates, target, combinations, ans);
        return combinations;
    }
    static void solve(int current,int[] candidates, int target, List<List<Integer>> combinations, List<Integer> ans){
        if(current == candidates.length){
            if(target ==0){
                combinations.add(new ArrayList<>(ans));
            }
            return;
        }
        
        if(target - candidates[current] >=0){
            ans.add(candidates[current]);
            solve(current, candidates, target - candidates[current],combinations, ans );
            ans.remove(ans.size()-1);

            solve(current +1, candidates, target, combinations, ans);
        } else{
            
            solve(current +1, candidates, target, combinations, ans);
        }

    }


    public static void main(String[] args) {

        int[][] candidatesTestCases = {
            {2, 3, 6, 7},
            {2, 3, 5},
            {2},
            {1},
            {2, 4, 6},
            {3, 5, 7}
        };

        int[] targets = {
            7,
            8,
            1,
            3,
            8,
            10
        };

        for (int i = 0; i < targets.length; i++) {

            System.out.println("Test Case " + (i + 1));

            System.out.println("Candidates: " +
                    Arrays.toString(candidatesTestCases[i]));

            System.out.println("Target: " + targets[i]);

            List<List<Integer>> result =
                    combinationSum(candidatesTestCases[i], targets[i]);

            System.out.println("Combinations: " + result);

            System.out.println("Total Combinations: " + result.size());

            System.out.println("--------------------------------");
        }
    }

}
/*
39. Combination Sum
Solved
Medium
Topics
premium lock icon
Companies
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
 

Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40
*/