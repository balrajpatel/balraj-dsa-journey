import java.util.*;
public class MaxUniqueSplitsInString1593{
    static int MAX;
    public static int maxUniqueSplit(String s) {
        MAX =0;
        Map<String, Integer> map = new HashMap<>();
        // solve(0, s,0, map);
        // return MAX;
        return solve1(0, s, map);
    }
    static void solve(int start, String s, int count, Map<String, Integer> map){
        if(start==s.length()){
            MAX = Math.max(count, MAX);
            return ;
        }

        for(int end = start; end<s.length(); end++){
            String piece = s.substring(start, end+1);
            if(!map.containsKey(piece)){
                // add  unique choice
                map.put(piece, 1);
                solve(end+1, s, count +1, map);
                //remove choice
                map.remove(piece);
            } 
        }
        //MAX = Math.max(MAX, count);
    }

    //  **** COMMON TEMPLATE TO FOUND MAX, MIN *****
    static int solve1(int start, String s, Map<String, Integer> map){
        if(start == s.length()){
            return 0;
        }
        
        //function returns max unqiue splits  starting from start to end;

        int best = 0;
        // this to track the max

        for(int end  = start; end< s.length(); end++){
            String piece = s.substring(start, end+1);
            if(!map.containsKey(piece)){

                map.put(piece, 1);

                // it is giving the count of spilts in one of the child 
                int count = 1 + solve1(end+1, s, map);

                map.remove(piece);

                best = Math.max(best, count);
            }
        }
        return best;
    }

    public static void main(String[] args) {

        String[] testCases = {
            "ababccc",
            "aba",
            "aa",
            "aaa",
            "aaaa",
            "abcdef",
            "aabb",
            "abab",
            "wwwzfvedwfvhsww",
            "leetcode",
            "abababab",
            "abcabc",
            "abcdefg",
            "a",
            "ab"
        };

        int[] expected = {
            5,   // ababccc
            2,   // aba
            1,   // aa
            2,   // aaa
            2,   // aaaa
            6,   // abcdef
            3,   // aabb
            3,   // abab
            11,  // wwwzfvedwfvhsww
            7,   // leetcode
            4,   // abababab
            4,   // abcabc
            7,   // abcdefg
            1,   // a
            2    // ab
        };

        System.out.println("========== MAX UNIQUE SPLIT TEST CASES ==========");

        for (int i = 0; i < testCases.length; i++) {

            String input = testCases[i];

            int actual = maxUniqueSplit(input);

            String result = (actual == expected[i]) ? "PASS" : "FAIL";

            System.out.println("------------------------------------");
            System.out.println("Input    : " + input);
            System.out.println("Expected : " + expected[i]);
            System.out.println("Actual   : " + actual);
            System.out.println("Result   : " + result);
        }
    }
}