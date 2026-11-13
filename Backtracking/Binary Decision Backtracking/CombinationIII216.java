import java.util.*;
public class CombinationIII216 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        solve(0, nums, 0, 0, k, n, result, ans);
        return result;

    }
    static void solve(int current, int[] nums, int size, int sum, int k, int n,  List<List<Integer>> result, List<Integer> ans){
        if(size == k){
            if(sum ==n){
                result.add(new ArrayList<>(ans));
                
            }
            return;
        }
        if(current==nums.length){
            if(size ==k && sum==n){
                result.add(new ArrayList<>(ans));
            }
            return;
        }
        if(sum>n || size > k){
            return;
        }

        //take
        ans.add(nums[current]);

        solve(current+1, nums, size+1, sum+nums[current], k,n,result, ans);

        ans.remove(ans.size()-1);


        //skip
        solve(current+1, nums, size, sum, k, n, result, ans);
    }

    public static void main(String[] args) {

        test(3, 7,
                Arrays.asList(
                        Arrays.asList(1, 2, 4)
                ));

        test(3, 9,
                Arrays.asList(
                        Arrays.asList(1, 2, 6),
                        Arrays.asList(1, 3, 5),
                        Arrays.asList(2, 3, 4)
                ));

        test(4, 1,
                Collections.emptyList());

        test(3, 2,
                Collections.emptyList());

        test(2, 18,
                Collections.emptyList());

        test(1, 9,
                Arrays.asList(
                        Arrays.asList(9)
                ));

        test(1, 1,
                Arrays.asList(
                        Arrays.asList(1)
                ));

        test(9, 45,
                Arrays.asList(
                        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)
                ));

        test(2, 10,
                Arrays.asList(
                        Arrays.asList(1, 9),
                        Arrays.asList(2, 8),
                        Arrays.asList(3, 7),
                        Arrays.asList(4, 6)
                ));

        test(3, 24,
                Arrays.asList(
                        Arrays.asList(7, 8, 9)
                ));
    }

    static void test(int k, int n, List<List<Integer>> expected) {

        List<List<Integer>> actual = combinationSum3(k, n);

        // Sort both results to avoid ordering-related comparison issues.
        actual.sort(Comparator.comparing(Object::toString));
        expected.sort(Comparator.comparing(Object::toString));

        boolean passed = actual.equals(expected);

        System.out.println("--------------------------------");
        System.out.println("k = " + k + ", n = " + n);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("Result   : " + (passed ? "PASS" : "FAIL"));
    }
}
/*
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

 

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
Example 3:

Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
 

Constraints:

2 <= k <= 9
1 <= n <= 60
 
Seen this question in a real interview before?
1/6
Yes
No
Accepted
886,958/1.2M
Acceptance Rate
73.9%
*/