import java.util.*;

public class PallindromePartitioning {
    //**** piece == cut  chose the current cut and find the next cut****
    static Boolean dp[][];
    static void solve(String ip, int n, int start,
                      List<List<String>> result,
                      List<String> ans) {

        // Entire string has been consumed
        if (start == n) {
            result.add(new ArrayList<>(ans));
            return;
        }

        // Choose where the current piece ends
        for (int i = start; i < n; i++) {

            // took the piece
            String piece = ip.substring(start, i + 1);
            if(isPallindrome(piece)){
            // Take  // add the piece to the current list
            ans.add(piece);

            // Move to the next unprocessed character
            solve(ip, n, i + 1, result, ans);

            // Undo
            ans.remove(ans.size() - 1);
            }
        }
    }

    static boolean isPallindrome(String s){
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

        String ip = "aabc";

        List<List<String>> result = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        solve(ip, ip.length(), 0, result, ans);

        for (var v : result) {
            System.out.println(v);
        }
    }
}

/*
aabc
a  a  bc (here bc at c == n-1 index it it will not at n index solve){
since not a pallindrome bc hence base condn will not hit
so it will back track and remove 2nd a 
then again it will remove 1st a
by ans.remove(size()-1)
since i=n nahi hua}
*/