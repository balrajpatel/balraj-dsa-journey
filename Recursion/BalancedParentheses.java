import java.util.*;

// remember here open and close no of open and close braces remaining;
public class BalancedParentheses{
    static List<String> fun(int n){
        int close = n;
        int open = n;
        List<String> ans = new ArrayList<>();
        String op = "";
        balancedParentheses(open, close, op, ans);
        return ans;
  
    }
    // with backtracking 
    static void balancedParentheses(int open, int close, String op, List<String> ans){
        if(open==0 && close == 0){
            ans.add(op);
            return;
        }
        if(open!=0){
                String op1 = op + "(";
                open--;
                balancedParentheses(open, close, op1, ans);
                open++;
        }
        
        if(close> open) { // no need of if(close!=0)  since open ==0 and close==0 already base condn and open!=0 already checked and close >open
            String op1 = op+ ")";
            
            close--;
            balancedParentheses(open, close, op1, ans);
            close++;
        }

    }


    // without backtracking
    static List<String> fun1(int n){
        int close = n;
        int open = n;
        List<String> ans = new ArrayList<>();
        String op = "";
        balancedParentheses(open, close, op, ans);
        return ans;
  
    }
    //without backtracking
    static void balancedParentheses1(int open, int close, String op, List<String> ans) {

        if (open == 0 && close == 0) {
            ans.add(op);
            return;
        }

        // Add "("
        if (open > 0) {
            String op1 = op + "(";
            balancedParentheses(open - 1, close, op1 , ans);
        }

        // Add ")"
        if (close > open) {
            String op2 = op + ")";
            balancedParentheses(open, close - 1, op2, ans);
        }
    }

    public static void main(String[] args){
        int n = 3;
        List<String> ans = fun(3);
        for(var s: ans){
            System.out.println(s);
        }
        System.out.println("\n");

        List<String> ans1 = fun1(n);
        for(var s: ans1){
            System.out.println(s);
        }
    }
}
