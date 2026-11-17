import java.util.*;
public class WordBreak139 {
    static Boolean[] dp;
    public static  boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()+1];
        Arrays.fill(dp, null);
        return solve(0,s,wordDict);
    }
    // Can I divide the remaining substring s[start...n-1] into valid dictionary words?
    // if i reach the start == s.length() means i reach the end there is nothing to searh for in dict
    // so return true;

    static boolean solve(int start, String s, List<String> wordDict){
        if(start==s.length()){
            return dp[s.length()] = true;
        }
        if(dp[start]!=null){
            return dp[start];
        }
        for(int end = start ; end<s.length(); end++){
            String piece = s.substring(start, end+1);
            if(isPresent(piece, wordDict)){
                if(solve(end+1, s, wordDict))return dp[start] = true;
            }
        }
        return dp[start] = false;
    }
    static boolean isPresent(String piece, List<String> wordDict){
        for(var s:wordDict){
            if(s.equals(piece)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        String[] inputs = {
            "leetcode",
            "applepenapple",
            "catsandog",
            "cars",
            "aaaaaaa",
            "aaaaab",
            "catsanddog",
            "pineapplepenapple",
            "abcd",
            "abcd",
            "a",
            "a",
            "abc",
            "ab",
            "abcd",
            "bb",
            "abcd",
            "aaaa",
            "aaaaaaaa",
            "goalspecial",
            "leetcodeleet",
            "programming",
            "ilikemango",
            "abcdef",
            "aaaaaaa"
        };

        List<List<String>> dictionaries = Arrays.asList(

            Arrays.asList("leet", "code"),

            Arrays.asList("apple", "pen"),

            Arrays.asList("cats", "dog", "sand", "and", "cat"),

            Arrays.asList("car", "ca", "rs"),

            Arrays.asList("a", "aa", "aaa"),

            Arrays.asList("a", "aa", "aaa", "aaaa"),

            Arrays.asList("cat", "cats", "and", "sand", "dog"),

            Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"),

            Arrays.asList("a", "abc", "b", "cd"),

            Arrays.asList("ab", "bc"),

            Arrays.asList("a"),

            Arrays.asList(),

            Arrays.asList("a", "b", "c"),

            Arrays.asList("a"),

            Arrays.asList("abc", "d"),

            Arrays.asList("a", "b", "bb"),

            Arrays.asList("ab", "cd", "abc"),

            Arrays.asList("a", "aa"),

            Arrays.asList("a", "aa", "aaa", "aaaa"),

            Arrays.asList("go", "goal", "goals", "special"),

            Arrays.asList("leet", "code", "leet"),

            Arrays.asList("pro", "gram", "ming"),

            Arrays.asList("i", "like", "man", "mango"),

            Arrays.asList("ab", "abc", "de", "f"),

            Arrays.asList("aaaa", "aaa")
        );

        boolean[] expected = {
            true,
            true,
            false,
            true,
            true,
            false,
            true,
            true,
            true,
            false,
            true,
            false,
            true,
            false,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true
        };

        for (int i = 0; i < inputs.length; i++) {

            boolean actual = wordBreak(inputs[i], dictionaries.get(i));

            System.out.println("------------------------------------");
            System.out.println("Test Case : " + (i + 1));
            System.out.println("Input     : " + inputs[i]);
            System.out.println("Dict      : " + dictionaries.get(i));
            System.out.println("Expected  : " + expected[i]);
            System.out.println("Actual    : " + actual);
            System.out.println("Result    : " +
                    (actual == expected[i] ? "PASS" : "FAIL"));
        }
    }

}

/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 

Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
*/