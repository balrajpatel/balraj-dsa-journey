import java.util.*;
class MartixChainMultiplication{
    static int t[][];
    static int matrixMultiplication(int arr[]){
        int j = arr.length;
        int i =1;
        t = new int[j][j];
        for(int k =0; k<t.length; k++){
            Arrays.fill(t[k], -1);
        }
        return solve(arr, i, j-1);
    }
    static int solve(int arr[], int i, int j){
        if(i >=j){
            return t[i][j] = 0;
        }
        if(t[i][j]!=-1){
            return t[i][j];
        }
        int mn = Integer.MAX_VALUE;
        for(int k=i; k<j;k++){
            int temp = solve(arr, i,k)
                        + solve(arr, k+1, j)
                        + arr[i-1]*arr[k]*arr[j];
            mn = Math.min(temp, mn);
            
        } 
        return t[i][j] = mn;
    }
    public static void main(String args[]){
        int arr[]  = new int[]{1,2,3,4,3};
        System.out.println(matrixMultiplication(arr));
    }
}


/*
General interpretation

For any Matrix Chain Multiplication problem:

t[i][j]

means

Minimum cost to multiply matrices from Ai through Aj.


In Matrix Chain Multiplication (MCM), only the upper triangular part of the DP table is used.

Why?

Remember what t[i][j] means:

Minimum cost to multiply matrices from Ai to Aj.

For this to make sense, i must be less than or equal to j.

i == j → Single matrix → Cost = 0
i < j → Multiple matrices → Compute minimum cost
i > j → Impossible (there is no chain from a higher index to a lower index)

Therefore, cells where i > j (the lower triangular part) are never used.

Example for 4 matrices
      j
      1    2    3    4
i
1     0    6   18   30
2     X    0   24   48
3     X    X    0   36
4     X    X    X    0
0 → Base case (i == j)
Numbers → Computed DP values
X → Never accessed


*/
