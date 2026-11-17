import java.util.*;
public class FairDistributionOfCookies {
public static int distributeCookies(int[] cookies, int k) {
        int[] childs = new int[k];
        Arrays.sort(cookies);
        reverse(cookies);

        return solve(0, childs, cookies, k);
         
    }

    // it returns the min unfirness 
    static int solve(int index, int[] childs, int[] cookies, int k){


        //For each distribution: Calculate unfairness using the maximum cookies received by any child.
        if(index == cookies.length){
            int unfairness = 0;
            for(int x: childs){
                unfairness = Math.max(x, unfairness);

            }
            return unfairness;
        }
        /*
        Math.max() evaluates one completed distribution.
        Math.min() compares different completed distributions and selects the best one.
        */

        int min = Integer.MAX_VALUE;
        for(int c = 0; c<childs.length; c++){
            childs[c] += cookies[index];

            int oneDistribution = solve(index+1, childs, cookies, k);

            childs[c] -= cookies[index];


            // Among all distributions: Choose the one with minimum unfairness.
            min = Math.min(min, oneDistribution);
        }
        return min;
    }
    static void reverse(int[] nums){
        int i = 0, j =nums.length-1;
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {

        int[][] testCookies = {
            {8, 15, 10, 20, 8},
            {6, 1, 3, 2, 2, 4, 1, 2},
            {1, 2, 3, 4},
            {1, 1, 1, 1},
            {7, 3, 5, 9},
            {12, 8, 6, 4, 10},
            {1, 2, 3},
            {10, 10, 10, 10},
            {100, 200, 300, 400, 500},
            {1, 2, 3, 4, 5, 6, 7, 8}
        };

        int[] kValues = {
            2,
            3,
            2,
            2,
            2,
            3,
            3,
            4,
            2,
            4
        };

       int[] expected = {
            31,
            7,
            5,
            2,
            12,
            14,
            3,
            10,
            800,
            9
        };

        for (int i = 0; i < testCookies.length; i++) {

            int[] cookies = testCookies[i].clone();
            int k = kValues[i];

            int actual = distributeCookies(cookies, k);

            System.out.println("------------------------------------");
            System.out.println("Cookies  : " + Arrays.toString(cookies));
            System.out.println("Children : " + k);
            System.out.println("Expected : " + expected[i]);
            System.out.println("Actual   : " + actual);
            System.out.println("Result   : " +
                    (actual == expected[i] ? "PASS" : "FAIL"));
        }
    }
}