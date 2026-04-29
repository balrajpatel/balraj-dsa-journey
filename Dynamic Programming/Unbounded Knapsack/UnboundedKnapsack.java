class UnboundedKnapsack {
    public static int knapSack(int val[], int wt[], int capacity) {
        // code here
        return unboundedKnapsack(val, wt, capacity);
        
    }
    static int unboundedKnapsack(int val[], int wt[], int capacity){
        int n = wt.length +1;
        int m = capacity +1;
        
        int[][] t = new int[n][m];
        
        for(int i=0; i<n; i++){
            t[i][0] = 0;
        }
        
        for(int j=1; j<m; j++){
            t[0][j] = 0;
        }
        
        
        for(int i = 1; i<n; i++){
            for(int j = 1; j<m; j++){
                if(wt[i-1] <= j){               
                    t[i][j] = Math.max(val[i-1] + t[i][j- wt[i-1]] , t[i-1][j]);
                    // Take: reuse same item (unbounded), so stay at i and reduce capacity
                    // Not take: move to previous item
                    
                    
                    //t[i][j - wt[i-1]]
                    //"I already know the answer for smaller capacity → reuse it"
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        
        
        /*For every current problem,
        we build its solution using solutions of smaller (already solved) subproblems, 
        and choose the best among them.*/
        
        return t[wt.length][capacity];
    }

    public static void main(String[] args){
        int val[] = new int[]{10, 40, 50, 70};
        int wt[] = new int[]{1, 3, 4, 5};
        int capacity = 8;
        System.out.println(knapSack(val, wt, capacity));
    }
}

/*
Knapsack with Duplicate Items
Difficulty: MediumAccuracy: 52.13%Submissions: 228K+Points: 4
Given a set of items, each with a weight and a value, represented by the array wt[] and val[] respectively. Also, a knapsack with a weight limit capacity.
Your task is to fill the knapsack in such a way that we can get the maximum profit. Return the maximum profit.

Note: Each item can be taken any number of times.

Examples:

Input: val[] = [1, 1], wt[] = [2, 1], capacity = 3
Output: 3
Explanation: The optimal choice is to pick the 2nd element 3 times.
Input: val[] = [10, 40, 50, 70], wt[] = [1, 3, 4, 5], capacity = 8
Output: 110
Explanation: The optimal choice is to pick the 2nd element and the 4th element.
Input: val[] = [6, 8, 7, 100], wt[] = [2, 3, 4, 5], capacity = 1
Output: 0
Explanation: We can't pick any element. Hence, total profit is 0.
Constraints:
1 ≤ val.size() = wt.size() ≤ 1000
1 ≤ capacity ≤ 1000
1 ≤ val[i], wt[i] ≤ 100
*/