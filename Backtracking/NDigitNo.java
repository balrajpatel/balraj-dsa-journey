import java.util.*;
class NDigitNo {
    public static ArrayList<Integer> increasingNumbers(int n) {
    ArrayList<Integer> ans = new ArrayList<>();
        
    if(n==1){
        for(int i=0;i<10; i++){
            ans.add(i);
        }
        return ans;
    }
    
    if(n>9){
        return new ArrayList<Integer>();
    }
    
    ArrayList<Integer> op = new ArrayList<>();
    op.add(0);
    
    solve(op, n,ans);
    return ans;
}
static void solve(ArrayList<Integer> op, int n, ArrayList<Integer> ans){
  if(n==0){
        int no = 0;
        for(int i = 0; i < op.size(); i++){
            no = no * 10 + op.get(i);
        }
        ans.add(no);
        return;
        } 
     
 
    for(int i=1; i<10;i++){
         
        if(i>op.get(op.size()-1)){
            
        op.add(i);
        solve(op,n-1,ans);
        op.remove(op.size()-1);
        
        }
    }
}
public static void main(String[] args) {
    for(int x: increasingNumbers(6)){
        System.out.print(x+" ");
    }
}
 
}

/*
Given an integer n, return all the n digit numbers in increasing order, such that their digits are in strictly increasing order(from left to right).

Examples :

Input: n = 1
Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
Explanation: Single digit numbers are considered to be strictly increasing order.
Input: n = 2
Output: [12, 13, 14, 15, 16, 17, 18, 19, 23....79, 89]
Explanation: For n = 2, the correct sequence is 12 13 14 15 16 17 18 19 23 and so on up to 89.
Input: n = 15
Output: []
Explanation: No such number exist. 
Constraints:
1 ≤ n ≤ 105
*/