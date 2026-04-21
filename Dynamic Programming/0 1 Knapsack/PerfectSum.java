public class PerfectSum{
    // Function to calculate the number of subsets with a given sum
    public static int perfectSum(int[] nums, int target) {
        // code here
        return subsetCounts(nums, target);
    }
    
    // this code works for zero elements also, since it explores very possible subsets and then counts;
    static int subsetCounts(int[] arr, int target){
        int n = arr.length +1;
        int m = target + 1;
        int t[][] = new int[n][m];
        
        for(int i =0; i< n; i++){
            t[i][0] = 1;
        }
        
        for(int j =1; j< m; j++){
            t[0][j] = 0;
        }
        
        for(int i =1; i< n; i++){
            for(int j=0; j<m; j++){    //***** since elements can be ==0 
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j] + t[i-1][j - arr[i-1]];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[arr.length][target];
    }
    /*
    t[i][j] = t[i-1][j] + t[i-1][j - arr[i-1]]
    this formula is 
    t[i][0] = 2 * t[i-1][0]  // no capacity reduced, since 0 element(sum) 
    so same formula just have to change j =1 to j =0;

    and if t[i][0]!=0 means arr[i-1]<=j(0) so 
    t[i][0] = t[i-1][0]  just copy total subets of last sols, // since we wan't subsets sum =0 but here next element including makes sum > 0
    // so , we just copy last sols (ie total subsets from last sol(not including the current element))   
    */
    
    
    /*
    What happens if you skip j = 0?

        Initial state:

        t[0][0] = 1

        Now suppose:

        arr = [0, 0]
        ❌ If you DON’T process j = 0 means sum =0 

        Then:

        t[1][0] = 1   (unchanged)
        t[2][0] = 1   (unchanged)

        👉 Final answer = 1 ❌

        ✅ If you DO process j = 0  means sum =0

        Then:

        t[1][0] = 2 * 1 = 2
        t[2][0] = 2 * 2 = 4

        👉 Final answer = 4 
    */

    public static void main(String[] args) {
        int[] arr = new int[]{2,5,1,4,3};
        int target = 10;
        System.out.println(perfectSum(arr, target));
    }


/*
        Let’s build the full DP table step-by-step for:

        arr = [0, 0, 1]
        target = 1
        🔹 DP Definition
        t[i][j] = number of subsets from first i elements with sum = j

        Dimensions:

        n = 3 → rows = 4 (0 to 3)
        target = 1 → columns = 2 (0 to 1)
        🔹 Step 1: Initialize Table
        Base cases:
        t[i][0] = 1
        t[0][j>0] = 0
        🧱 Initial Table
        i \ j	0	1
        0	1	0
        1	1	0
        2	1	0
        3	1	0
        🔥 Step 2: Process elements one by one
        👉 i = 1 (element = 0)
        j = 0:
        t[1][0] = t[0][0] + t[0][0] = 2
        j = 1:
        t[1][1] = t[0][1] + t[0][1] = 0
        Table after i = 1
        i \ j	0	1
        0	1	0
        1	2	0
        2	1	0
        3	1	0
        👉 i = 2 (element = 0)
        j = 0:
        t[2][0] = t[1][0] + t[1][0] = 4
        j = 1:
        t[2][1] = t[1][1] + t[1][1] = 0
        Table after i = 2
        i \ j	0	1
        0	1	0
        1	2	0
        2	4	0
        3	1	0
        👉 i = 3 (element = 1)
        j = 0:
        1 <= 0 ❌

        t[3][0] = t[2][0] = 4
        j = 1:
        1 <= 1 ✅

        t[3][1] = t[2][1] + t[2][0]
                = 0 + 4
                = 4
        ✅ Final DP Table
        i \ j	0	1
        0	1	0
        1	2	0
        2	4	0
        3	4	4
        🎯 Final Answer
        t[3][1] = 4 ✅
        🔥 What just happened (IMPORTANT)
        At j = 0:
        Step	Value
        start	1
        after first 0	2
        after second 0	4

        👉 Zeros doubled count each time

        Then at j = 1:
        t[3][1] = t[2][0]

        👉 All those 4 subsets contributed!
*/
}