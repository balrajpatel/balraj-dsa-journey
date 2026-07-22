import java.util.*;
class BooleanParenthesization {
    static int MOD = 1003;
    // static Map<String, Integer> map;
    
    static int[][][] t;
    
    static int countWays(String s) {
        // code here
        int j = s.length();
        int i =0;
        //map = new HashMap<>();
        t = new int[j][j][2];
        for(int k =0; k<t.length; k++){
            for(int l = 0; l<t[0].length; l++){
                Arrays.fill(t[k][l],-1);
            }
        }
        return solve(s,i,j-1, 'T');
        
    }
    
    /*
    How many ways can the expression from index i to j be parenthesized so that it evaluates to isTrue?
    */
    
    static int solve(String s, int i, int j, char isTrue){
        // Base Cases
        if(i>j) return 0;
        if(i == j){
            if(isTrue== 'T')return s.charAt(i)=='T'? 1:0;
            else
                return s.charAt(i) =='F'?1:0;
        }
        
        int flag = isTrue=='T'?1:0;
        if(t[i][j][flag]!=-1) return t[i][j][flag];
        
        /*String key = i + "_" + j + "_" + isTrue;        
        
        if (map.containsKey(key)) return map.get(key);
        */
        // it tells no of ways exp for isTrue (T/F);
        int ans =0;
        
        for(int k = i+1; k<j; k = k+2){
            //they represent no of ways it can have T/F
            int  lt = solve(s,i, k-1, 'T');
            int  lf = solve(s, i, k-1, 'F');
            int  rt = solve(s, k+1, j, 'T');
            int  rf = solve(s, k+1, j, 'F');
            
            char op = s.charAt(k);
            if(op == '&'){
                
                // we evaluse exp to T
                if(isTrue=='T'){
                    ans = (int)(ans+ 1L*lt*rt);
                }else{
                    // evalue exp to F
                    ans = (int)(ans + 1L*lt*rf + 1L*lf*rt + 1L*lf*rf);
                }
                
            }else if(op == '|'){
                if(isTrue =='T'){
                    ans = (int)(ans + 1L*lt*rt + 1L*lt*rf + 1L*lf*rt);
                }else {
                    ans = (int)(ans + 1L*lf*rf );
                }
            }else if(op =='^'){
                if(isTrue == 'T'){
                    ans = (int)(ans + 1L*lt*rf + 1L*lf*rt);
                }else{
                    ans = (int)(ans + 1L*lt*rt + 1L*lf*rf);
                }
                
            }
        }
        // map.put(key, ans);
        return t[i][j][flag]= ans;
    }
    public static void main(String[] args) {
        String s = "T|T&F^T";
        String s1 = "T^F|F";
        System.out.println(countWays(s));
        System.out.println(countWays(s1));
    }
}



/*
You are given a boolean expression s containing
    'T' ---> true
    'F' ---> false 
and following operators between symbols
   &   ---> boolean AND
    |   ---> boolean OR
   ^   ---> boolean XOR
Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.

Note: The answer is guaranteed to fit within a 32-bit integer.

Examples:

Input: s = "T|T&F^T"
Output: 4
Explaination: The expression evaluates to true in 4 ways: ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) and (T|((T&F)^T)).
Input: s = "T^F|F"
Output: 2
Explaination: The expression evaluates to true in 2 ways: ((T^F)|F) and (T^(F|F)).
Constraints:
1 ≤ |s| ≤ 100 
*/