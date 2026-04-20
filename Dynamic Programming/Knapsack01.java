import java.util.*;
// t[][] in it 1 based index is used for memoization; 
// Here:
//  n represents number of items
// W represents capacity


/*
WE  CHOOSES VARAIABLE FOR MEMOIZATION TABLE WHICH ARE CHANGING
AND ALSO FOR  MEMOIZATION WE GENERALLY FOR 0TH ROW AND 0TH COL WE INITIALIZE (BASE CONDN) SO
TO FILL UP WE USED 1 BASED INDEXING (REST OF )    // FOR TOP DOWN  ==== USING ITERATIVE (REPLACING RECURSION )

//SO GIVEN VALUES ARE MAPPED WITH 1 INDEXING OF TABLE
*/
public class Knapsack01{
    static int t[][] = new int[1001][1001];

    static int knapsack(int wt[], int val[], int n, int W){
        if(W==0 || n == 0){
            return 0;

        }

        if(t[W][n]!=-1) return t[W][n];
        if(wt[n-1] <= W){
            return t[W][n] = Math.max(
                val[n-1] + knapsack(wt, val, n-1, W - wt[n-1]),
                knapsack(wt, val, n-1, W)
            );
        }else{
            return t[W][n] = knapsack(wt, val, n-1, W);
        }
    }

    public static void main(String[] args){
        int W = 5;
        int[] val = new int[]{10, 40, 30, 50}, wt = new int[]{5, 4, 2, 3};

        for(int i =0; i<t.length; i++){
            Arrays.fill(t[i], -1);
        }
        
        System.out.println(knapsack(wt, val, wt.length, W));
    }
}