import java.util.*;
class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

//
// stack stores
//  Only those elements that are still capable of becoming the next greater element for some future element.
// Every time an element loses this possibility
// it gets popped forever.


        for(int i = nums2.length-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek()<= nums2[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                map.put(nums2[i],-1);
            }else if(stack.peek()> nums2[i]){
                map.put(nums2[i], stack.peek());

            }


/*
            if(stack.isEmpty()){
                map.put(nums2[i], -1);
            }else if( !stack.isEmpty() && stack.peek()> nums2[i]){
                map.put(nums2[i], stack.peek());
            }else {
                while(!stack.isEmpty() && stack.peek()<= nums2[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    map.put(nums2[i],-1);
                }
                else {
                    map.put(nums2[i], stack.peek());
                }
            }
            */

            stack.push(nums2[i]); // at the end of every iteration push the current element
        }

        int ans[] = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;

    }
    public static void main(String[] args) {
        int a[] = new int[]{4,1,2};
        int b[] = new int[]{1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(a,b)));

    }
}