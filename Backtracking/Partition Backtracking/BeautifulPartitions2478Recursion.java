import java.util.*;
public class BeautifulPartitions2478Recursion{
    static int ans ;
    static int MOD = 1000000007;
    public static int beautifulPartitions(String s, int k, int minLength) {
        ans = 0;
        solve(0, s, 0, k, minLength);
        return ans%MOD;
    }
    static void solve(int start, String s,int pCount, int k, int minLength){
        if(start == s.length()){
            if(pCount == k){
                ans++;
            }
            return;
        }
        if(pCount>= k){
            return;
        }

        //     //since end is (start+ minLength-1) greater then ===> automatically substrings are atlest minLength
        // for(int end = start + minLength -1; end<s.length(); end++){
        //     // 1st letter prime, last letter not prime

        //     if(isPrime(s.charAt(start)) && !isPrime(s.charAt(end))){
        //         solve(end+1, s, pCount+1, k, minLength);
        //     }

        // }

        for(int end = start; end< s.length(); end++){
            String piece = s.substring(start, end+1);
            if(isPrime(piece.charAt(0))  && !isPrime(piece.charAt(piece.length()-1)) && piece.length()>= minLength){
                solve(end+1, s, pCount+1, k, minLength);
            }

        }

    }

    static boolean isPrime(char c){
        return c == '2' || c == '3' || c == '5' || c== '7';
    }
    public static void main(String[] args) {
        String s = "23542185131";
        int k = 3;
        int minLength = 2;
        System.out.println(beautifulPartitions(s,k,minLength));
//     Output: 3
// Explanation: There exists three ways to create a beautiful partition:
// "2354 | 218 | 5131"
// "2354 | 21851 | 31"
// "2354218 | 51 | 31"

    }
}