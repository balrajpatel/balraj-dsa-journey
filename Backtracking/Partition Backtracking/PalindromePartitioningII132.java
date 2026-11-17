import java.util.*;
public class PalindromePartitioningII132 {
    static int dp[];
    public static int minCut(String s) {
        dp = new int[s.length()+1];
        Arrays.fill(dp, -1);
        return solve(0,s)-1; // snice partitions not cuts
    }

    // solve gives the min partitons from start to end
    static int solve(int start, String s){
        if(start == s.length()){
            return dp[s.length()]=0;
        }
        if(dp[start]!=-1){
            return dp[start];
        }

        int min =Integer.MAX_VALUE;
        //for min 
        for(int end = start; end < s.length(); end++){
            String piece = s.substring(start, end+1);
            if(isPalindrome(piece)){
                // since we  just want count(min)

                // count gives partitions count for all its(fn) childrens
                //*****think of this as whole function in one go and will know 
                // why min and its comparision with all valid partitions counts */
                int count = 1 + solve(end+1, s);
                min = Math.min(min,count);
            }
        }
        return dp[start] = min;
    }

    static boolean isPalindrome(String s){
        int r = s.length()-1;
        int l =0;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public static void main(String[] args) {

        String[] testCases = {
            "a",
            "aa",
            "ab",
            "aba",
            "abba",
            "abc",
            "aab",
            "aabb",
            "abab",
            "abac",
            "aabbc",
            "banana",
            "leetcode",
            "noonabbad",
            "abababab"
        };

        int[] expected = {
                0,
                0,
                1,
                0,
                0,
                2,
                1,
                1,
                1,
                1,  // abac
                2,
                1,
                6,  // leetcode
                2,
                1
            };

        int passed = 0;

        for (int i = 0; i < testCases.length; i++) {

            int actual = minCut(testCases[i]);

            boolean success = actual == expected[i];

            if (success) passed++;

            System.out.println("Input    : " + testCases[i]);
            System.out.println("Expected : " + expected[i]);
            System.out.println("Actual   : " + actual);
            System.out.println("Result   : " + (success ? "PASS" : "FAIL"));
            System.out.println("------------------------------------");
        }

        System.out.println("Total Test Cases : " + testCases.length);
        System.out.println("Passed           : " + passed);
        System.out.println("Failed           : " + (testCases.length - passed));
    }
}

/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
Example 2:

Input: s = "a"
Output: 0
Example 3:

Input: s = "ab"
Output: 1
 

Constraints:

1 <= s.length <= 2000
s consists of lowercase English letters only.
 
Seen this question in a real interview before?
1/6
*/