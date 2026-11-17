import java.util.*;
public class RestoreIPAddress93 {
    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        solve(0,0,s,new StringBuilder(), result);
        return result;
    }
    static void solve(int start, int parts, String s, StringBuilder sb, List<String> result){
        if(start == s.length()){
            if(parts ==4){
            result.add(sb.substring(0, sb.length()-1));
            }
            return ;
        }
        if(parts>=4){
            return;
        }

        for(int end = start; end <Math.min(start+3, s.length()); end++){
            StringBuilder snew = new StringBuilder(s.substring(start, end+1));
            if(isValid(snew.toString())){

                //vaild chose
                sb.append(snew+".");
                solve(end+1, parts+1, s, sb, result);

                //unchose it
                sb.setLength(sb.length() - snew.length() - 1); // for undo*****
            }
        //      for(int i =start; i<Math.min( start+3, n); i++){
        //     String piece = s.substring(start, i+1);
        //     if(isValid(piece)){
        //         String newAns =  ans + piece + '.';
        //         solve(s, i+1,n, newAns,  parts+1, result);
        //         // NO backtracking // since always passing new String **********

        //     }
        // }
        }


    }

    static boolean isValid(String s){
        if(s.length()>1 &&s.charAt(0)=='0') return false;
        int n = Integer.parseInt(s);
        return n<=255;
    }

     public static void main(String[] args) {

        // Test 1: Standard example
        test("25525511135", Arrays.asList(
                "255.255.11.135",
                "255.255.111.35"
        ));

        // Test 2: Multiple valid IP addresses
        test("101023", Arrays.asList(
                "1.0.10.23",
                "1.0.102.3",
                "10.1.0.23",
                "10.10.2.3",
                "101.0.2.3"
        ));

        // Test 3: All zeros
        test("0000", Arrays.asList(
                "0.0.0.0"
        ));

        // Test 4: Leading zeros
        test("010010", Arrays.asList(
                "0.10.0.10",
                "0.100.1.0"
        ));

        // Test 5: Minimum valid length
        test("1111", Arrays.asList(
                "1.1.1.1"
        ));

        // Test 6: Maximum valid length
        test("255255255255", Arrays.asList(
                "255.255.255.255"
        ));

        // Test 7: Too short
        test("123", Collections.emptyList());

        // Test 8: Too long
        test("1234567890123", Collections.emptyList());

        // Test 9: Invalid segment values
        test("256256256256", Collections.emptyList());

        // Test 10: Single digit repeated
        test("11111", Arrays.asList(
                "1.1.1.11",
                "1.1.11.1",
                "1.11.1.1",
                "11.1.1.1"
        ));

        // Test 11: Different valid combinations
        test("19216811", Arrays.asList(
        "1.92.168.11",
        "19.2.168.11",
        "19.21.68.11",
        "19.216.8.11",
        "19.216.81.1",
        "192.1.68.11",
        "192.16.8.11",
        "192.16.81.1",
        "192.168.1.1"
        ));
        // Test 12: Empty input
        test("", Collections.emptyList());
    }

    static void test(String input, List<String> expected) {

        List<String> actual = restoreIpAddresses(input);

        Collections.sort(actual);
        Collections.sort(expected);

        boolean passed = actual.equals(expected);

        System.out.println("==========================================");
        System.out.println("Input    : " + input);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("Status   : " + (passed ? "PASS" : "FAIL"));
    }
}

/*
/*
A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.

For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.

 

Example 1:

Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]
Example 2:

Input: s = "0000"
Output: ["0.0.0.0"]
Example 3:

Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 

Constraints:

1 <= s.length <= 20
s consists of digits only.
*/
