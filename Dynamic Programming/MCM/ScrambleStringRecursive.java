import java.util.*;
class ScrambleStringRecursive {
    public static boolean isScramble(String s1, String s2) {
        if(s1.length()==0)return true;
        return solve(s1,s2);
    }
    static boolean solve(String s1, String s2){
        if(s1.equals(s2))return true;
        if(s1.length()==0)return false;
        
        boolean flag = false;
        int n = s1.length();
        for(int k = 1; k < n; k++){  // at k <n 
        // for k = n = 4 sustring(4,5) = t not empty string;

            if(
                solve(s1.substring(0,k),s2.substring(n-k,n)) &&
                solve(s1.substring(k,n),s2.substring(0,n-k)) ||

                solve(s1.substring(0,k),s2.substring(0,k)) &&
                solve(s1.substring(k,n),s2.substring(k,n))
            ){
                flag =  true;
                break;
            }
        }
        return flag;

    }

    public static void main(String[] args){
        System.out.println(isScramble("great", "rgeat"));
        System.out.println(isScramble("abcde", "caebd"));
        System.out.println(isScramble("a","a"));
    }
}