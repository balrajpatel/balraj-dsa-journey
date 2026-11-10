import java.util.*;
//find largest no with atmost k swaps

class LargestNoWithKSwaps {
    // Function to find the largest number after k swaps.
    public static String findMaximumNum(String s, int k) {
        // code here.
        ArrayList<String> ans = new ArrayList<>();  
        solve(new StringBuilder(s), k, 0,ans);
        String mx = "0";

        //******* we didn't convert to int so overflow error
        // so we directly compared with string only; */

        for(String x : ans){
            if(x.compareTo(mx) > 0)  
                mx = x;
        }
        return mx;
    }
    static void solve(StringBuilder s, int k, int start, ArrayList<String> ans){
        if(k==0 || start ==s.length()-1){
            ans.add(s.toString());
            return;
        }
        int mx=0;
        boolean flag = true;
        for(int j = start+1;j<s.length();j++){
                mx = Math.max(mx,s.charAt(j)-'0');
                
            }
        for(int i = start + 1;i<s.length();i++){
            
            char c = s.charAt(i);
            char c2 = s.charAt(start);

            if(c-'0'==mx && mx> c2-'0'){
                flag = false;
                s.setCharAt(start,c);
                s.setCharAt(i,c2);
                
                solve(s, k-1,start+1,ans);
                ;
                
                s.setCharAt(start,c2);
                s.setCharAt(i,c);
            }
        }
        if(flag)solve(s,k,start+1,ans);

    }
    
    public static void main(String[] args){
        System.out.println(findMaximumNum("3435335",3));
    }
}