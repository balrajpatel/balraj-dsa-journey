class LongestCommSubstrRecuvsive{
    static int maxlen =0;
    public static int longCommSubstr(String s1, String s2) {
        
        longestCommonSubString(s1, s2, s1.length(), s2.length());
        return maxlen;
    }
    static int longestCommonSubString(String s1, String s2, int n, int m ) {
        if(n ==0 || m ==0 ){
            return 0;
        }
        int count =0;
        if(s1.charAt(n-1) == s2.charAt(m-1)){
            count = 1 + longestCommonSubString(s1, s2, n-1, m-1);
            maxlen = Math.max(count, maxlen);
        }else{
           count = 0;
        }
        longestCommonSubString(s1, s2, n-1, m);
        longestCommonSubString(s1, s2, n, m-1);
        return count;
    }
    public static void main(String[] args){
        String s1 = "ABCDGH";
        String s2 = "ACDGHR";
        System.out.println(longCommSubstr(s1, s2));
    }
}