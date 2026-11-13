import java.util.*;
public class SubsetI78 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        solve(0,nums,subsets,ans);
        return subsets;

    }
    // nums contais unqiue elements
    static void solve(int current,int[] nums, List<List<Integer>> subsets, List<Integer> ans){
        if(current == nums.length){
            subsets.add(new ArrayList<Integer>(ans));
            return ;
        }

        ans.add(nums[current]);
        solve(current+1, nums,subsets, ans);
        ans.remove(ans.size()-1);

        solve(current + 1, nums, subsets, ans);

    }


    // works only when nums contains unique
    static int countSubsets(int current,int[] nums){
        if(current == nums.length){
            return 1;
        }
        int take = countSubsets(current+1, nums);
        int skip = countSubsets(current+1, nums);
        return take + skip;



    }

    public static void main(String[] args) {

    int[][] testCases = {
        {1, 2, 3},
        {1, 2},
        {0},
        {1, 2, 3, 4},
        {}
    };

    for (int i = 0; i < testCases.length; i++) {

        System.out.println("Test Case " + (i + 1));

        System.out.println("Input: " +
                Arrays.toString(testCases[i]));

        List<List<Integer>> result = subsets(testCases[i]);

        System.out.println("Subsets: " + result);

        int count = countSubsets(0, testCases[i]);

        System.out.println("Total subsets: " + count);

        System.out.println("--------------------------------");
    }
}
}
