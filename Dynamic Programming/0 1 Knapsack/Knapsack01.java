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
            return t[n][W] = 0;

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

/*
0 - 1 Knapsack Problem

Given two arrays, val[] and wt[], where each element represents the value and weight of an item respectively, 
and an integer W representing the maximum capacity of the knapsack (the total weight it can hold).

The task is to put the items into the knapsack such that the total value obtained is maximum without exceeding the capacity W.

Note: You can either include an item completely or exclude it entirely — fractional selection of items is not allowed. Each item is available only once.

Examples :

Input: W = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1]
Output: 3
Explanation: Choose the last item, which weighs 1 unit and has a value of 3.
Input: W = 3, val[] = [1, 2, 3], wt[] = [4, 5, 6] 
Output: 0
Explanation: Every item has a weight exceeding the knapsack's capacity (3).
Input: W = 5, val[] = [10, 40, 30, 50], wt[] = [5, 4, 2, 3] 
Output: 80
Explanation: Choose the third item (value 30, weight 2) and the last item (value 50, weight 3) for a total value of 80.
Constraints:
1 ≤ val.size() = wt.size() ≤ 103
1 ≤ W ≤ 103
1 ≤ val[i] ≤ 103
1 ≤ wt[i] ≤ 103

*/