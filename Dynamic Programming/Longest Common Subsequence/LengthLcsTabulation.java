public class LengthLcsTabulation {
    static int lengthOfLcs(String s1, String s2){
        int n = s1.length() +1;
        int m = s2.length() + 1;
        int[][] t = new int[n][m];

        for(int i =0; i<n; i++){
            t[i][0] = 0;
        }
        for(int j =0; j<m; j++){
            t[0][j] = 0;
        }
        

        for(int i =1; i<n; i++){
            for(int j =1; j<m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[s1.length()][s2.length()];
    }
    public static void main(String[] args){

        String s1 = "abcdgh";
        String s2 = "abedgha";
        System.out.println(lengthOfLcs(s1, s2));
    }
}