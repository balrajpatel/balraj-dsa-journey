import java.util.*;
public class UniqueSubsets{
    static void subsets(String ip, String op, SortedSet<String> ans){
        if(ip.length()==0){
            ans.add(op);
            return;
        }
        String op1 = op ;
        String op2 = op + ip.charAt(0);
        String ip1 = ip.substring(1);
        subsets(ip1,op1,ans);
        subsets(ip1,op2,ans); 
    } // slightly enefficient since we are cal duplicate then removing
    // instead we can sort then not recurse for duplicate skip those.
    public static void main(String[] args){
        String ip = "aabc";
        String op = new String();
        SortedSet<String> ans = new TreeSet<>(
         (a,b)->{
            return a.compareTo(b); 
         }
        ); // comprator not required since by default   natural order
        // Set<Integer> set = new TreeSet<>(Collections.reverseOrder()); // this will also work
        subsets(ip,op, ans);
        for(String s: ans){
            System.out.print(s+" ");
        }
    }
}