import java.util.*;
public class CombinationSumII40 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(candidates);
        solve(0,candidates, result,ans,target);
        return result;
        
    }
    static void solve(int current, int[] candidates, List<List<Integer>> result, List<Integer> ans, int target){
        if(current==candidates.length){
            if(target==0){
                result.add(new ArrayList<>(ans));
                return ;
            }
            return;
        }

        if(target - candidates[current] >=0){
            ans.add(candidates[current]);
            solve(current +1, candidates, result, ans,target-candidates[current]);
            ans.remove(ans.size()-1);
        }

        // if skip , skip with all duplicates;
        int next = current +1;
        while(next<candidates.length && candidates[next] == candidates[next-1]){
            next++;
        }
        solve(next, candidates, result, ans, target);


    }

    public static void main(String[] args) {

        int[][] candidates = {
            {10, 1, 2, 7, 6, 1, 5},
            {2, 5, 2, 1, 2},
            {1, 1, 1, 1, 1},
            {1},
            {1, 2, 3, 4},
            {1, 1, 2, 2, 3, 3},
            {3, 5, 2, 1, 4},
            {1, 1, 1}
        };

        int[] targets = {8, 5, 3, 1, 10, 4, 6, 2};

        List<List<Integer>>[] expected = new List[] {
            Arrays.asList(
                Arrays.asList(1, 1, 6),
                Arrays.asList(1, 2, 5),
                Arrays.asList(1, 7),
                Arrays.asList(2, 6)
            ),

            Arrays.asList(
                Arrays.asList(1, 2, 2),
                Arrays.asList(5)
            ),

            Arrays.asList(
                Arrays.asList(1, 1, 1)
            ),

            Arrays.asList(
                Arrays.asList(1)
            ),

            Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(1, 2, 3, 4)
            ),

            Arrays.asList(
                Arrays.asList(1, 1, 2),
                Arrays.asList(1, 3),
                Arrays.asList(2, 2)
            ),

            Arrays.asList(
                Arrays.asList(1, 5),
                Arrays.asList(2, 4),
                Arrays.asList(2, 4),
                Arrays.asList(1, 2, 3)
            ),

            Arrays.asList(
                Arrays.asList(1, 1)
            )
        };

        System.out.println("========== COMBINATION SUM II ==========");

        for (int i = 0; i < candidates.length; i++) {

            List<List<Integer>> actual =
                combinationSum2(candidates[i], targets[i]);

            System.out.println("\nTest Case " + (i + 1));
            System.out.println("Candidates : " +
                Arrays.toString(candidates[i]));

            System.out.println("Target     : " + targets[i]);
            System.out.println("Expected   : " + expected[i]);
            System.out.println("Actual     : " + actual);

            // Order-independent comparison
            Set<List<Integer>> expectedSet =
                new HashSet<>(expected[i]);

            Set<List<Integer>> actualSet =
                new HashSet<>(actual);

            System.out.println("Status     : " +
                (expectedSet.equals(actualSet) ? "PASS" : "FAIL"));
        }
    }

}
/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
 
Seen this question in a real interview before?
1/6
Yes
No
Accepted
1,900,521/3.1M
Acceptance Rate
60.4%
*/