import java.util.*;
class UnboundedKnapsackMemoization {
    static int t[][];
    public static int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = wt.length +1;
        int m = capacity + 1;
        t = new int[n][m];
        for(int i =0; i<t.length; i++){
            Arrays.fill(t[i], -1);
        }
        return unboundedKnapsack(val, wt, wt.length, capacity);
        
    }
    static int unboundedKnapsack(int val[], int wt[], int n,  int capacity){
        
        if(capacity ==0 || n == 0){
            return t[n][capacity] = 0;
        }
        
        if(t[n][capacity] !=-1)return t[n][capacity];
        if(wt[n-1]<= capacity){
            return t[n][capacity] = Math.max(
                val[n-1] + unboundedKnapsack(val, wt, n, capacity - wt[n-1]),
                unboundedKnapsack(val, wt, n-1, capacity));
        }else{
            return t[n][capacity] = unboundedKnapsack(val, wt, n-1, capacity);
        }
    }
        public static void main(String[] args){
    int val[] = new int[]{10, 40, 50, 70};
        int wt[] = new int[]{1, 3, 4, 5};
        int capacity = 8;
        System.out.println(knapSack(val, wt, capacity));
    }
}