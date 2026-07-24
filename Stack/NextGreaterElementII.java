import java.util.*;
class NextGreaterElementII {
    public static int[] nextGreaterElements(int[] nums) {
        return sol2(nums);
       
    }
    static int[] sol1(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        for(int i = 0; i< n; i++){
            ans[i] = -1;
            int j = (i+1)%n;
            while( j !=i){
                if(nums[i] >= nums[j]){
                    j = (j+1)%n;
                    
                }else{
                    ans[i] = nums[j];
                    break;
                }
            }
        }
        return ans;
    }
    static int[] sol2(int[] nums){
        int arr[] = new int[2*nums.length];
        int k = nums.length;
        for(int i=0; i< nums.length; i++){
            arr[i] = nums[i];
            arr[k++] = nums[i];
        }
        
        int ans[] = new int[arr.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i =arr.length - 1; i >=0; i--){
            if(stack.size()==0){
                ans[i] = -1;
            }else if(stack.size()>0 && stack.peek() > arr[i]){
                ans[i] = stack.peek();
            }else if(stack.size() > 0 && stack.peek() <= arr[i]){
                while(stack.size() >0 && stack.peek() <= arr[i]){
                    stack.pop();
                }
                if(stack.size()==0){
                    ans[i] = -1;
                }else{
                    ans[i] = stack.peek();
                }
            }
            stack.push(arr[i]);
        }
        int res[] = new int[nums.length];
        for(int i =0; i<res.length; i++){
            res[i] = ans[i];
        }
        return res;

    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1,2,3,4,3})));
    }
}