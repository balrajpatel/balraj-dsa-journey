public class  Knapsack01TopDown{
    // i represents the no of elements, j represents the currenty capacity (WT);
    static int knapsack(int wt[], int val[], int w, int n){
        int t[][] = new int[n+1][w+1];

        for(int i=0; i<n+1; i++){
            for(int j=0; j< w+1; j++){
                if(i==0 || j==0){
                    t[i][j] = 0;
                }
            }
        }

        for(int i= 1; i <n+1; i++){
            for(int j =1; j < w+1; j++){
                if(wt[i-1] <= j){     ///****** remember we use wt[i-1]  since wt is 0 indexed based******* */     
                    
                    
                     // here we include the current wt/val  + subproblem(j-1) where we subtract current wt from knapsack,  
                // 2nd don't include the current wt , then subproblem ( j-1)
                // not including current  ---- then max of both 

                    t[i][j] = Math.max(val[i-1] + t[i-1][j - wt[i-1]], t[i-1][j]);

                    //t[i-1][j - wt[i-1]]
                    //Use remaining items (1 to i-1) with reduced capacity ( remove wt of current item wt[i-1])
                }
                else{
                        // just didn't include the current wt then get value from subproblem(j-1) since current wt > w (capacity)
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][w];
    }

    public static void main(String[] args){
        int W = 5;
        int[] val = new int[]{10, 40, 30, 50}, wt = new int[]{5, 4, 2, 3};

        System.out.println(knapsack(wt, val, W, wt.length));
    }
}