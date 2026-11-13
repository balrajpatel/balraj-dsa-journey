import java.util.*;
public class PermutationII47 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        solve(0,nums, used, result, ans);
        return result;
    }
    static void solve(int len, int[] nums, boolean[] used, List<List<Integer>> result, List<Integer> ans){
        if(len == nums.length){
            result.add(new ArrayList<>(ans));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(used[i])continue;

            if(i>0 && nums[i] == nums[i-1] && used[i-1]== false){
                continue;
            }

            //choose
            used[i] = true;
            ans.add(nums[i]);
            solve(len+1,nums,used, result, ans);

            //unchoose
            ans.remove(ans.size()-1);
            used[i] = false;
        }
    }
     public static void main(String[] args) {

        // Test 1: All distinct elements
        test(
                new int[]{1, 2, 3},
                Arrays.asList(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(1, 3, 2),
                        Arrays.asList(2, 1, 3),
                        Arrays.asList(2, 3, 1),
                        Arrays.asList(3, 1, 2),
                        Arrays.asList(3, 2, 1)
                )
        );

        // Test 2: One duplicate
        test(
                new int[]{1, 1, 2},
                Arrays.asList(
                        Arrays.asList(1, 1, 2),
                        Arrays.asList(1, 2, 1),
                        Arrays.asList(2, 1, 1)
                )
        );

        // Test 3: Multiple duplicates
        test(
                new int[]{1, 1, 2, 2},
                Arrays.asList(
                        Arrays.asList(1, 1, 2, 2),
                        Arrays.asList(1, 2, 1, 2),
                        Arrays.asList(1, 2, 2, 1),
                        Arrays.asList(2, 1, 1, 2),
                        Arrays.asList(2, 1, 2, 1),
                        Arrays.asList(2, 2, 1, 1)
                )
        );

        // Test 4: All elements identical
        test(
                new int[]{5, 5, 5},
                Arrays.asList(
                        Arrays.asList(5, 5, 5)
                )
        );

        // Test 5: Negative numbers
        test(
                new int[]{-1, -1, 2},
                Arrays.asList(
                        Arrays.asList(-1, -1, 2),
                        Arrays.asList(-1, 2, -1),
                        Arrays.asList(2, -1, -1)
                )
        );

        // Test 6: Empty array
        test(
                new int[]{},
                Arrays.asList(
                        Arrays.asList()
                )
        );

        // Test 7: Single element
        test(
                new int[]{7},
                Arrays.asList(
                        Arrays.asList(7)
                )
        );

        // Test 8: Two identical elements
        test(
                new int[]{2, 2},
                Arrays.asList(
                        Arrays.asList(2, 2)
                )
        );

        // Test 9: Three distinct elements with one repeated twice
        test(
                new int[]{1, 2, 2, 3},
                Arrays.asList(
                        Arrays.asList(1, 2, 2, 3),
                        Arrays.asList(1, 2, 3, 2),
                        Arrays.asList(1, 3, 2, 2),
                        Arrays.asList(2, 1, 2, 3),
                        Arrays.asList(2, 1, 3, 2),
                        Arrays.asList(2, 2, 1, 3),
                        Arrays.asList(2, 2, 3, 1),
                        Arrays.asList(2, 3, 1, 2),
                        Arrays.asList(2, 3, 2, 1),
                        Arrays.asList(3, 1, 2, 2),
                        Arrays.asList(3, 2, 1, 2),
                        Arrays.asList(3, 2, 2, 1)
                )
        );
    }

    static void test(int[] nums, List<List<Integer>> expected) {

        List<List<Integer>> actual = permuteUnique(nums);

        // Sort both lists to ignore ordering differences.
        actual.sort(Comparator.comparing(Object::toString));
        expected.sort(Comparator.comparing(Object::toString));

        boolean passed = actual.equals(expected);

        System.out.println("==================================");
        System.out.println("Input    : " + Arrays.toString(nums));
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("Status   : " + (passed ? "PASS" : "FAIL"));
    }

}

// //Duplicate Removing Logic;
// [1,1,2]  == two ways to generate it
// 1st 1 chosen, 2nd 1 chosen ===== we include this

// now  if chose 2nd 1 , then don't chose 1st one (means if it is false) skip
// since it is false means can be chosen and we want to skip that



/*
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10
 
Seen this question in a real interview before?
1/6
*/