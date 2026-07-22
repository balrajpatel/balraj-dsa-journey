import java.util.*;

class PalindromePartitioningII {
    static int t[][];
    static boolean pal[][];  // to precumpute pallindrome
    static int minCut(String s) {
        int i =0;
        int j = s.length()-1;

        pal = new boolean[j+1][j+1];
        for (int len = 1; len <= s.length(); len++) {
            for (int start = 0; start + len - 1 < s.length(); start++) {

                int end = start + len - 1;

                if (len == 1)
                    pal[start][end] = true;
                else if (len == 2)
                    pal[start][end] = (s.charAt(start) == s.charAt(end));
                else
                    pal[start][end] =
                        (s.charAt(start) == s.charAt(end))
                        && pal[start + 1][end - 1];
            }
        }


        t = new int[j+1][j+1];
        for(int k = 0; k<t.length; k++){
            Arrays.fill(t[k], -1);
        }

        return palindromePartitioning(s, i, j);        
    }

static int palindromePartitioning(String s, int i, int j){
        if(i>=j)return t[i][j] = 0;
        if (pal[i][j])return t[i][j] = 0;
        if(t[i][j]!= -1){
            return t[i][j];
        }

        int mn = Integer.MAX_VALUE;
        for(int k = i; k<j;k++){
            //THIS OPTIMIZATION CAN BE APPLIED TO ALL MCM PROBLEMS
            int left, right;
            if(t[i][k] !=-1) left = t[i][k];
            else {
                left = palindromePartitioning(s,i,k);
            }
            if(t[k+1][j]!= -1)right = t[k+1][j];
            else {
                right = palindromePartitioning(s,k+1,j);
            }
            int temp = 1 + left + right;
            mn = Math.min(mn, temp);
        }
        return t[i][j] = mn; 

    }
    static boolean isPallindrome(String s, int i, int j){
        while (i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "ab";
        System.out.println(minCut(s));
        String s1 = "aab";
        System.out.println(minCut(s1));
        String s2 = "a";
        System.out.println(minCut(s2));
    }
}