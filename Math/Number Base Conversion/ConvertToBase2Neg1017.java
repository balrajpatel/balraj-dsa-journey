import java.util.*;
public class ConvertToBase2Neg1017 {
    public static String baseNeg2(int n) {
        if(n==0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while(n!=0){
          int digit = n%-2;
          n /= -2;
          if(digit<0){ 
            // <0 means -1 only since dividing by zero only
            digit +=2; // since we increased the remainder
            
            n++;
            /*
            n = -2Q -1;
            n = -2Q -2 +1;
            n = -2(Q+1) + 1;
            so here re = 1; q = q+1;
            therefore q++;
            */
          }
          sb.append(digit);

        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(baseNeg2(2));
        System.out.println(baseNeg2(3));
        System.out.println(baseNeg2(4));
      
    }
    /*
    Given an integer n, return a binary string representing its representation in base -2.

Note that the returned string should not have leading zeros unless the string is "0".

 

Example 1:

Input: n = 2
Output: "110"
Explantion: (-2)2 + (-2)1 = 2
Example 2:

Input: n = 3
Output: "111"
Explantion: (-2)2 + (-2)1 + (-2)0 = 3
Example 3:

Input: n = 4
Output: "100"
Explantion: (-2)2 = 4
 

Constraints:

0 <= n <= 109
*/
}