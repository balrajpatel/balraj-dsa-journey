import java.util.*;
public class BeautifulPartitions2478DP{
    static int dp[][];
    static int MOD = 1000000007;
    public int beautifulPartitions(String s, int k, int minLength) {
         if (!isPrime(s.charAt(0)) ||
             isPrime(s.charAt(s.length()-1))) {
            return 0;
        } // we want this also



        dp = new int[s.length()+1][k+1];
        for(int i =0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(0, s, 0, k, minLength)%MOD;
    }
    static int solve(int start, String s,int pCount, int k, int minLength){
        if(start == s.length()){
            if(pCount == k){
                return 1;
            }
            return 0;
        }
        if(pCount>= k){
            return 0;
        }

        if(dp[start][pCount]!= -1){
            return dp[start][pCount];
        }

        int ans = 0;

            //since end is (start+ minLength-1) greater then ===> automatically substrings are atlest minLength
        for(int end = start + minLength -1; end<s.length(); end++){
            // 1st letter prime, last letter not prime

            if(isPrime(s.charAt(start)) && !isPrime(s.charAt(end))){
               // ans += solve(end+1, s, pCount+1, k, minLength);
                // can overflow

                ans = (ans + solve(end+1, s, pCount+1, k, minLength)) % MOD;
            }


        }

        // for(int end = start; end< s.length(); end++){
        //     String piece = s.substring(start, end+1);
        //     if(isPrime(piece.charAt(0))  && !isPrime(piece.charAt(piece.length()-1)) && piece.length()>= minLength){
        //         solve(end+1, s, pCount+1, k, minLength);
        //     }

        // }


        return dp[start][pCount] = ans;

    }

    static boolean isPrime(char c){
        return c == '2' || c == '3' || c == '5' || c== '7';
    }


    public static void main(String[] args) {

        String[] inputs = {
            "23542185131",
            "23542185131",
            "3312958",
            "23542185130",
            "23542185130",
            "23542185130",
            "23542185130",
            "23542185130",
            "23542185130",
            "23542185130",
            "23542185130",
            "23542185130",
            "3312958",
            "3312958",
            "23511",
            "23511",
            "235421",
            "23542185131",
            "123456",
            "2357"
        };

        int[] kValues = {
            3, 3, 3, 2, 3,
            4, 1, 5, 2, 3,
            4, 1, 2, 4, 1,
            1, 2, 2, 1, 1
        };

        int[] minLengths = {
            2, 3, 1, 2, 2,
            1, 1, 1, 3, 3,
            2, 5, 1, 1, 1,
            3, 2, 1, 1, 1
        };

        int[] expected = {
            3, 1, 1, 3, 3,
            1, 1, 0, 2, 1,
            1, 1, 2, 0, 1,
            1, 1, 3, 0, 0
        };

        BeautifulPartitions2478DP obj =
                new BeautifulPartitions2478DP();

        for (int i = 0; i < inputs.length; i++) {

            int actual = obj.beautifulPartitions(
                    inputs[i],
                    kValues[i],
                    minLengths[i]
            );

            System.out.println("------------------------------------");
            System.out.println("Test Case : " + (i + 1));
            System.out.println("String    : " + inputs[i]);
            System.out.println("K         : " + kValues[i]);
            System.out.println("MinLength : " + minLengths[i]);
            System.out.println("Expected  : " + expected[i]);
            System.out.println("Actual    : " + actual);
            System.out.println("Result    : " +
                    (actual == expected[i] ? "PASS" : "FAIL"));
        }
    }

}