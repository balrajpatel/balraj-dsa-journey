import java.util.*;
public class PartitionKEqualSubsets698 {
    public static boolean canPartitionKSubsets(int[] nums, int k) {

        int sum = 0;

        for(int x : nums){
            sum += x;
        }

        if(sum % k != 0){
            return false;
        }

        int target = sum / k;

        Arrays.sort(nums);
        reverse(nums);
        // just an optimisation;

        // means even the single element is > target == putting into any bucket not possible;
        if(nums[0]>target){
            return false;
        }

        int[] buckets = new int[k];
        // buckets represents current sum of eack bucket ( subsets);
        Arrays.fill(buckets, 0);
        return solve(0,buckets, nums, target);
    }

    // function definition
    // can i assign elment from index to end into the buckets acc to given conditions
    static boolean solve(int index, int[] buckets, int[] nums, int target){
        if(index == nums.length){
            // here all the element are assigned to buckets;

            // verifying weather all buckets sum == target;
            for(int x : buckets){
                if(x!=target){
                    return false;
                }
            }           
            return true;
        }

        for(int b = 0; b<buckets.length; b++){
            if(isValidPlacement(nums[index], buckets, b, target)){
                // put into bucket
                buckets[b] += nums[index];
                if(solve(index+1, buckets, nums, target)){
                    return true;
                }

                // remove from bucket
                buckets[b] -= nums[index];

                // removing from bucket mean we try another bucket whether putting other remaining bucket
                // can solveor not


                // Skip equivalent empty buckets  ****didnt understand that 
                if(buckets[b] == 0){
                    break;
                }

            }
        }

        return false;
    }
    static boolean isValidPlacement(int x, int[] buckets, int b, int target){
        return x + buckets[b] <= target;
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
        int[] nums1 = new int[]{4,3,2,3,5,2,1};
        int k1 = 4;
        int[] nums2 = new int[]{1,2,3,4};
        int k2 = 3;
        System.out.println(canPartitionKSubsets(nums1, k1));
        System.out.println(canPartitionKSubsets(nums2, k2));
    }

}