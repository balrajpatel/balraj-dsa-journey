import java.util.*;
class PermutationStringRecursion{
    static void solve(String ip, String op, ArrayList<String> ans){
        if(ip.length()==0){
            ans.add(op);
            return;
        }

        Set<Character> s = new HashSet<>();
        for(int i=0; i<ip.length(); i++){
            if(!s.contains(ip.charAt(i))){
                s.add(ip.charAt(i));
                solve(ip.substring(0,i)+ip.substring(i+1,ip.length()), op+ip.charAt(i), ans);
            }
        };
        return;
    }
    public static void main(String[] args) {
        String s = "abc";
        String s1 = "aab";
        String op1 = "";
        String op2 = "";
        ArrayList<String>  ans1 = new ArrayList<>();
        ArrayList<String>  ans2= new ArrayList<>();
        solve(s,op1,ans1);
        solve(s1,op1,ans2);
        for(var sa:ans1){
            System.out.print(sa+" ");
        }
        System.out.println();
        for(var sb:ans2){
            System.out.print(sb+" ");
        }
    }



}