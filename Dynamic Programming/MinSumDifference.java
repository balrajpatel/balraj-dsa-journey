public class MinSumDifference {
    static boolean[][] t;
    public static int minDifference(int arr[]) {
        // code here
        int range =0;
        for(int x: arr){
            range += x;
        }
        
        subSetSum(arr, range);
        
        
        int mn = Integer.MAX_VALUE;
        
                
    
        for(int i=0; i< (range/2)+1; i++){
            if(t[arr.length][i]==true){
                mn = Math.min(mn, range - 2*i);
            }    
        }
        
        return mn;
        
    }
    static void subSetSum(int[] arr, int range){
        int n = arr.length + 1;
        int m = range + 1;
        t = new boolean[n][m];
        
        for(int i =0; i<n ; i++){
            t[i][0] = true;
        }
        
        for(int j = 1; j<m; j++){
            t[0][j] = false;
        }
        
        for(int i =1; i<n; i++){
            for(int j =1; j<m; j++){  // array elemetns are >=1
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j- arr[i-1]] || t[i-1][j];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        
    }
    public static void main(String[] args){
        int []arr = new int[]{1,6, 11, 5};
        System.out.println(minDifference(arr));
    }
}
