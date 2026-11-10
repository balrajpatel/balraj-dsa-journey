import java.util.*;
class PermutationStringBT {
    static void solve(StringBuilder s, int start, ArrayList<String> ans){
        if(start == s.length()-1){
            ans.add(s.toString());
            return;
        }
        Set<Character> set = new HashSet<>();
        for(int i = start; i<s.length();i++){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                //swap
                char a = s.charAt(start);
                char b = s.charAt(i);
                s.setCharAt(i,a);
                s.setCharAt(start,b);

                solve(s,start +1,ans);

                //swap for backtrack
                s.setCharAt(i,b);
                s.setCharAt(start,a);
            }

        }
    }
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abc");
        ArrayList<String> a = new ArrayList<>();
        solve(sb,0,a);
        for(var x:a){
            System.out.print(x+" ");
        }
    }
}