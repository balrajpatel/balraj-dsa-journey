import  java.util.*;
class PrintShortestCommonSupersequence {
    static int[][] t;
    public static String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length() + 1;
        int m = str2.length() + 1;
        t = new int[n][m];
        for(int i=0; i<t.length; i++){
            Arrays.fill(t[i], -1);
        }
        lcs(str1, str2, str1.length(), str2.length());
        return printLcs(str1, str2);
    }

    static int lcs(String s1, String s2, int n, int m){
        if(n ==0 || m == 0){
            return t[n][m]= 0;
        }
        if(t[n][m] !=-1){
            return t[n][m];
        }
        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return t[n][m] = 1 + lcs(s1, s2, n-1, m-1);
        }
        else{
            return t[n][m] = Math.max(
                lcs(s1, s2, n-1, m),
                lcs(s1, s2, n, m-1)
            );
        }
    }

    static String printLcs(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        StringBuffer sb = new StringBuffer();
        while(n >0 && m>0){
            if(s1.charAt(n-1)== s2.charAt(m-1)){
                sb.append(s1.charAt(n-1));
                n--;
                m--;
            }
            else{
                if(t[n-1][m] >= t[n][m-1]){ 
                    sb.append(s1.charAt(n-1));  // rem t is 1 based index, s1 is zero based index
                    // so if n-1 > m-1 (lcs) then append the s1(n-1) (current index and move one less in s1)
                    // and for current s2 (m-1) all these will be appended at the last 2 while loops times,
                    n--;
                }else{
                    sb.append(s2.charAt(m-1));
                    m--;
                }
            }
        }

        while(n>0){
            sb.append(s1.charAt(n-1));
            n--;
        }
        while(m>0){
            sb.append(s2.charAt(m-1));
            m--;
        }
        return new String(sb.reverse());
        
    }
    public static void main(String[] args){
        String s1 = "abac";
        String s2 = "cab";
        System.out.println(shortestCommonSupersequence(s1,s2));
    }
    /*
    Core Goal of SCS

        We want:

        maximum sharing
        minimum duplication

        LCS represents:

        maximum possible sharing

        So while constructing SCS:

        We try NOT to destroy future common subsequences
        Hence we move toward larger LCS value
        Visual Intuition

        Suppose:

        str1 = "abcdef"
        str2 = "abqdef"

        LCS is:

        abdef

        Length = 5

        Huge overlap.

        So SCS becomes:

        abcqdef

        Only 1 extra character added.

        Now imagine choosing wrong path repeatedly and destroying overlap.

        You may get:

        abqcdeef

        Longer answer.

        Mathematical Insight

        We know:

        SCS=n+m−LCS

        To minimize SCS:

        LCS must be maximized

        That is EXACTLY why we follow larger DP value.

        Because larger DP value means:

        more future common characters survive

        and therefore:

        less duplication needed later
*/
}