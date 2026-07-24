import java.util.*;
class Solution {
    public static String removeKdigits(String num, int k) {

        ArrayDeque<Character> s = new ArrayDeque<>();

        for(char c: num.toCharArray()){
            while(!s.isEmpty() && s.peek() > c && k>0){
                s.pop();
                k--;
            }
            s.push(c);

        }
        while(k>0){
            s.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        sb.reverse();
        while(sb.length() > 0 && sb.charAt(0) =='0'){
            sb.deleteCharAt(0);

        }

        return sb.length()==0? "0":sb.toString();

    }
    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219",3));
        System.out.println(removeKdigits("10200",1));
    }
}
/*Algorithm (Plain English)
Goal
We need to remove exactly k digits so that the remaining number is the smallest possible.
Step 1: Create an empty stack.
The stack will always store digits in increasing order as much as possible.

Step 2: Traverse the number from left to right.
For every digit d:
While all of these are true:
the stack is not empty,
k > 0,
the digit on the top of the stack is greater than the current digit,
remove (pop) the top digit.
Reason:
A larger digit before a smaller digit makes the number bigger. Removing the larger digit gives a smaller number.
After removing all such digits, push the current digit into the stack.

Step 3: If k is still greater than 0
It means the digits were already in increasing order.

Example:
123456
No digit was removed during traversal.
So remove the remaining digits from the end of the number by popping from the stack until k = 0.

Step 4: Build the answer
The stack stores digits in reverse order (because of stack operations).
Read the stack from bottom to top to construct the final number.

Step 5: Remove leading zeros
Example:
0200
becomes
200
If all digits are removed (or only zeros remain), return:
"0"

One-Line Rule to Remember
Whenever you see a smaller digit, remove all previous larger digits (while you still have deletions left), then insert the current digit.
*/