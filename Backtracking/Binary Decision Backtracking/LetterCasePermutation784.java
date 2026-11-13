import java.util.*;
public class LetterCasePermutation784 {
    public static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        solve(0, s, result, new StringBuilder());
        return result;
    }
    static void solve(int current, String s, List<String> result, StringBuilder ans){
        if(current == s.length()){
            result.add(new String(ans.toString()));
            return;
        }
        if(Character.isLetter(s.charAt(current))){
            // uppercase choice
            ans.append(Character.toUpperCase(s.charAt(current)));
            solve(current+1, s, result, ans);

            //undo uppercase choice
            ans.deleteCharAt(ans.length()-1);

            //lowercase Choice
            ans.append(Character.toLowerCase(s.charAt(current)));
            solve(current+1, s, result, ans);

            //undo lowercase choice
            ans.deleteCharAt(ans.length()-1);

        } else{
            //make chocie
            ans.append(s.charAt(current));
            solve(current +1, s, result, ans);

            //undo choice
            ans.deleteCharAt(ans.length()-1);
        }
    }
     public static void main(String[] args) {

        // Test 1: All lowercase letters
        test("a1b2", Arrays.asList(
                "A1B2", "A1b2", "a1B2", "a1b2"
        ));

        // Test 2: Single letter
        test("a", Arrays.asList(
                "A", "a"
        ));

        // Test 3: All digits
        test("12345", Arrays.asList(
                "12345"
        ));

        // Test 4: All uppercase letters
        test("ABC", Arrays.asList(
                "ABC", "ABc", "AbC", "Abc",
                "aBC", "aBc", "abC", "abc"
        ));

        // Test 5: Mixed uppercase and lowercase
        test("aB", Arrays.asList(
                "AB", "Ab", "aB", "ab"
        ));

        // Test 6: Empty string
        test("", Arrays.asList(
                ""
        ));

        // Test 7: Single digit
        test("5", Arrays.asList(
                "5"
        ));

        // Test 8: Letters and special characters
        test("a-b", Arrays.asList(
                "A-B", "A-b", "a-B", "a-b"
        ));

        // Test 9: Multiple letters and digits
        test("a1b2c3", Arrays.asList(
                "A1B2C3", "A1B2c3",
                "A1b2C3", "A1b2c3",
                "a1B2C3", "a1B2c3",
                "a1b2C3", "a1b2c3"
        ));

        // Test 10: Repeated letters
        test("aa", Arrays.asList(
                "AA", "Aa", "aA", "aa"
        ));
    }

    static void test(String s, List<String> expected) {

        List<String> actual = letterCasePermutation(s);

        // Sort both lists to ignore ordering differences
        Collections.sort(actual);
        Collections.sort(expected);

        boolean passed = actual.equals(expected);

        System.out.println("======================================");
        System.out.println("Input    : \"" + s + "\"");
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("Status   : " + (passed ? "PASS" : "FAIL"));
    }
}