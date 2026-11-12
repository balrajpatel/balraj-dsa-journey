import java.util.*;
public class AnyBaseToDecimal {
    public static int anyBaseToDecimal(int base, String no){
        if("0".equals(no)){
            return 0;
        }
        int value =0;
        for(int i=0; i<no.length(); i++){
            char c = no.toUpperCase().charAt(i);
            if(c>='0' && c<='9'){
               value = value*base + c-'0'  ;
            }else {
                value = value*base + c-'A' +10;
            }
        }
        return value;
    }

    public static void main(String[] args) {

        int[][] testCases = {
            {2, 10},
            {8, 15},
            {10, 123},
            {16, 47},
            {16, 255},
            {16, 10},
            {2, 255},
            {3, 100},
            {5, 69},
            {7, 466},
            {12, 131},
            {20, 19},
            {36, 36},
            {36, 1295},
            {16, 373592855},
            {36, 29234652},
            {8, 2054353},
            {16, 11259375}
        };

        String[] inputs = {
            "1010", "17", "123", "2F", "FF", "A",
            "11111111", "10201", "234", "1234",
            "AB", "J", "10", "ZZ", "DEADBEEF",
            "HELLO", "7654321", "ABCDEF"
        };

        for (int i = 0; i < inputs.length; i++) {
            int actual = anyBaseToDecimal(testCases[i][0], inputs[i]);

            System.out.println(
                "Base: " + testCases[i][0] +
                ", Input: " + inputs[i] +
                ", Output: " + actual +
                ", Expected: " + testCases[i][1] +
                ", Result: " +
                (actual == testCases[i][1] ? "PASS" : "FAIL")
            );
        }
    }

}