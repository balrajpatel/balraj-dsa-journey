import java.util.*;
public class MatchsticksToSquare473 {
    public static boolean makesquare(int[] matchsticks) {
        int sum =0;
        for(int x: matchsticks){
            sum += x;

        }
        if(sum%4!=0)return false;

        int target= sum/4;
        int[] buckets = new int[4];
        
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return solve(0, matchsticks, buckets, target);
    }

    static boolean solve(int index, int[] matchsticks, int[] buckets, int target){
        if(index == matchsticks.length){
            for(int x: buckets){
                if(x!=target){
                    return false;
                }
            }

            return true;
        }

        for(int b = 0; b<buckets.length; b++){
            if(isValidPlacement(matchsticks[index], buckets, b, target)){
                buckets[b] += matchsticks[index];

                if(solve(index + 1, matchsticks, buckets, target)){
                    return true;
                }


                buckets[b] -= matchsticks[index];


                if(buckets[b]==0){
                    break;
                }
            }
        }
        return false;
    }
    static boolean isValidPlacement(int x, int[] buckets, int b, int target){
        return x+buckets[b] <=target;
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
    public static void main(String[] args){
        int[] matchsticks1 = {1,1,2,2,2};
        int[] matchsticks2 = {3,3,3,3,4};
        System.out.println(makesquare(matchsticks1));
        System.out.println(makesquare(matchsticks2));

    }
}