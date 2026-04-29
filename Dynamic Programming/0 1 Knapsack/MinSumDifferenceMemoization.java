class MinSumDifferenceMemoization {
    static Boolean[][] t;
    public static int minDifference(int arr[]) {
        // code here
        int range =0;
        for(int x: arr){
            range += x;
        }
        
        t = new Boolean[arr.length+1][range+1];
        for(int i =0; i<arr.length+1; i++){
            Arrays.fill(t[i], null);
        }
        
        
        int mn = Integer.MAX_VALUE;
        
                
    
        for(int i=0; i< (range/2)+1; i++){
            subSetSum(arr, arr.length, i);
            if(t[arr.length][i]!=null && t[arr.length][i]==true){
                mn = Math.min(mn, range - 2*i);
            }    
        }
        
        return mn;
        
    }
        
    static Boolean subSetSum(int[] arr,int n,  int range){
    

        if(range == 0){
            return t[n][range] = true;  //always store base cases in memoization
        }
        if(n == 0 ){
            return t[n][range] = false;  //always store base cases in memoization
        }
        
    
        if(t[n][range]!=null){
            return t[n][range];
        }  
        
        if(arr[n-1]<= range){
            return t[n][range] = subSetSum(arr, n-1, range-arr[n-1]) || subSetSum(arr, n-1, range);
        }else{
            return t[n][range] = subSetSum(arr, n-1, range);
        }
        
    }
    public static void main(String[] args){
        int arr[] = new int[]{1, 6, 11, 5};
        System.out.println(minDifference(arr));

    }
}
