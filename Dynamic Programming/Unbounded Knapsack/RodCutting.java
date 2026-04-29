class RodCutting {
    public static int cutRod(int[] price) {
        // code here
        int length = price.length;
        int len[] = new int[length];
        for(int i =0; i<length; i++){
            len[i] = i+1;
        }
        
        return maxPrice(price, len, length);
        
    }
    static int maxPrice(int[] price, int[] len, int length){
        int n = price.length+1;
        int m = length+1;
        int[][] t = new int[n][m];
        
        for(int i=0; i<n; i++){
            t[i][0] = 0;    
        }
        
        for(int j=1; j<m; j++){
            t[0][j] = 0;
        }
        
        for(int i =1; i<n; i++){
            for(int j =1; j<m; j++){
                
                if(len[i-1] <=j){
                    t[i][j] = Math.max(price[i-1]+ t[i][j-len[i-1]] , t[i-1][j]);
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[price.length][length];
    }
    public static void main(String[] args){
        int price[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(price));
    }
}