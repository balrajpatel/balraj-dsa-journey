import java.util.*;
public class SourceToTargetBase {
    
public static void main(String[] args) {

    String[][] testCases = {
        // {input, sourceBase, targetBase, expectedOutput}

        {"101010", "2", "16", "2A"},
        {"11111111", "2", "10", "255"},
        {"110101", "2", "8", "65"},
        {"255", "10", "2", "11111111"},
        {"255", "10", "16", "FF"},
        {"42", "10", "8", "52"},
        {"2F", "16", "10", "47"},
        {"FF", "16", "2", "11111111"},
        {"FF", "16", "8", "377"},
        {"377", "8", "16", "FF"},
        {"17", "8", "10", "15"},
        {"123", "10", "10", "123"},
        {"AB", "12", "16", "83"},
        {"ZZ", "36", "10", "1295"},
        {"10", "36", "16", "24"},
        {"HELLO", "36", "10", "29234652"},
        {"ABCDEF", "16", "36", "6PBSF"},
        {"1010", "2", "2", "1010"},
        {"0", "10", "16", "0"},
        {"A", "16", "36", "A"}
    };

    for (String[] test : testCases) {

        String input = test[0];
        int sourceBase = Integer.parseInt(test[1]);
        int targetBase = Integer.parseInt(test[2]);
        String expected = test[3];

        int decimal = AnyBaseToDecimal.anyBaseToDecimal(
            sourceBase, input
        );

        String actual = DecimalToAnyBase.decimalToAnyBase(
            decimal, targetBase
        );

        boolean passed = actual.equalsIgnoreCase(expected);

        System.out.println(
            "Input: " + input +
            " | " + sourceBase + " -> " + targetBase +
            " | Output: " + actual +
            " | Expected: " + expected +
            " | " + (passed ? "PASS" : "FAIL")
        );
    }
}

}