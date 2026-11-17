import java.util.*;
public class WordBreakII140 {
        public List<String> wordBreak(String s, List<String> wordDict) {
        String ans = new String();
        List<String> result = new ArrayList<>();
        solve(0, s, wordDict, ans, result);
        return result;
    }
    static void solve(int start, String s, List<String> wordDict, String ans, List<String> result){
        if(start == s.length()){
            result.add(new String(ans.substring(0,ans.length()-1)));
        }
        for(int end = start; end<s.length(); end++){
            String piece = s.substring(start, end+1);
            if(isPresent(piece, wordDict)){
                piece = ans + piece + " ";
                // here new string ans created === no undo step req

                solve(end+1, s, wordDict, piece, result);


            }
        }
    }
    static boolean isPresent(String piece, List<String> wordDict){
        for(var s:wordDict){
            if(s.equals(piece)){
                return true;
            }
        }
        return false;
    }

}