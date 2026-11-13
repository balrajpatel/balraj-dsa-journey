import java.util.*;
public class Permutation46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        boolean visited[] = new boolean[nums.length];
        solve(0,nums, visited, result, ans);
        return result;
    }
    // len (len of permutation) also means at the position what we fill;
    
    static void solve(int len, int[] nums, boolean[] visited, List<List<Integer>> result, List<Integer> ans){
        if(len == nums.length){
            result.add(new ArrayList<>(ans));
            return;
        }
        for(int i=0; i<nums.length;i++){
            if(visited[i])continue;

            //choose
            visited[i] = true;
            ans.add(nums[i]);

            solve(len+1,nums, visited, result,ans);

            //unchoose
            visited[i] = false;
            ans.remove(ans.size()-1);

        }
    }
    
    public static void main(String[] args) {

        int testCases = 0;
        int passed = 0;

        // Test Case 1
        testCases++;
        int[] nums1 = {1, 2, 3};

        List<List<Integer>> expected1 = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 3, 2),
                Arrays.asList(2, 1, 3),
                Arrays.asList(2, 3, 1),
                Arrays.asList(3, 1, 2),
                Arrays.asList(3, 2, 1)
        );

        List<List<Integer>> actual1 = permute(nums1);

        boolean pass1 = new HashSet<>(actual1)
                .equals(new HashSet<>(expected1));

        if (pass1) passed++;

        System.out.println("Test Case 1");
        System.out.println("Input    : " + Arrays.toString(nums1));
        System.out.println("Expected : " + expected1);
        System.out.println("Actual   : " + actual1);
        System.out.println("Status   : " + (pass1 ? "PASS" : "FAIL"));
        System.out.println("--------------------------------");

        // Test Case 2
        testCases++;
        int[] nums2 = {0, 1};

        List<List<Integer>> expected2 = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(1, 0)
        );

        List<List<Integer>> actual2 = permute(nums2);

        boolean pass2 = new HashSet<>(actual2)
                .equals(new HashSet<>(expected2));

        if (pass2) passed++;

        System.out.println("Test Case 2");
        System.out.println("Input    : " + Arrays.toString(nums2));
        System.out.println("Expected : " + expected2);
        System.out.println("Actual   : " + actual2);
        System.out.println("Status   : " + (pass2 ? "PASS" : "FAIL"));
        System.out.println("--------------------------------");

        // Test Case 3
        testCases++;
        int[] nums3 = {1};

        List<List<Integer>> expected3 = Arrays.asList(
                Arrays.asList(1)
        );

        List<List<Integer>> actual3 = permute(nums3);

        boolean pass3 = new HashSet<>(actual3)
                .equals(new HashSet<>(expected3));

        if (pass3) passed++;

        System.out.println("Test Case 3");
        System.out.println("Input    : " + Arrays.toString(nums3));
        System.out.println("Expected : " + expected3);
        System.out.println("Actual   : " + actual3);
        System.out.println("Status   : " + (pass3 ? "PASS" : "FAIL"));
        System.out.println("--------------------------------");

        // Test Case 4
        testCases++;
        int[] nums4 = {};

        List<List<Integer>> expected4 = Arrays.asList(
                Collections.emptyList()
        );

        List<List<Integer>> actual4 = permute(nums4);

        boolean pass4 = new HashSet<>(actual4)
                .equals(new HashSet<>(expected4));

        if (pass4) passed++;

        System.out.println("Test Case 4");
        System.out.println("Input    : " + Arrays.toString(nums4));
        System.out.println("Expected : " + expected4);
        System.out.println("Actual   : " + actual4);
        System.out.println("Status   : " + (pass4 ? "PASS" : "FAIL"));
        System.out.println("--------------------------------");

        // Final Summary
        System.out.println("Total Test Cases : " + testCases);
        System.out.println("Passed           : " + passed);
        System.out.println("Failed           : " + (testCases - passed));
    }
}

/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
*/