public class LengthLCS {
    //Treat s2, s1 like array we don't paass new Strings with reduced length
    //instead we reduce n ,m just like array; (and access String chars with n,m);
    // so that we don't need to pass new SubString with reduced lenth everytime;
    static int lengthOfLcs(String s1, String s2, int n, int m){
        if(n ==0 || m == 0){
            return 0;
        }

        if( s1.charAt(n-1) == s2.charAt(m -1 )){
            return 1 + lengthOfLcs( s1, s2, n-1, m-1);
        }else{
            return Math.max(
                lengthOfLcs(s1, s2, n-1, m),
                lengthOfLcs(s1, s2, n, m-1)
            );
        }

    }

    static int lengthOfLcs1(String s1, String s2, int n, int m){
        if(n == 0 || m == 0){
            return 0;
        }

        String s11 = s1.substring(0, s1.length() - 1);
        String s22 = s2.substring(0, s2.length() - 1);

        int n2 = s11.length();
        int m2 = s22.length();

        if(s1.charAt(s1.length() - 1) == s2.charAt(s2.length() - 1)){
            return 1 + lengthOfLcs(s11, s22, n2, m2);
        } else {
            return Math.max(
                lengthOfLcs(s11, s2, n2, m),
                lengthOfLcs(s1, s22, n, m2)
            );
        }
    }

    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "abedgha";
        System.out.println(lengthOfLcs(s1, s2, s1.length(), s2.length()));
        System.out.println(lengthOfLcs1(s1, s2, s1.length(), s2.length()));
    }
}