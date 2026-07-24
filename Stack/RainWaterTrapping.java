import java.util.*;
class Solution {
    public static int trap(int[] height) {
        int[] mxl = new int[height.length], mxr = new int[height.length];
        mxl[0] = height[0];
        mxr[height.length-1] = height[height.length-1];
        for(int i=1; i<mxl.length; i++){
            mxl[i] = Math.max(mxl[i-1], height[i]);
        }
        for(int j = height.length-2; j>=0; j--){
            mxr[j] = Math.max(mxr[j+1], height[j]);
        }

        int water[] = new int[height.length];

        int ans =0;
        for(int i =0; i< water.length; i++){
            water[i] = Math.min(mxl[i], mxr[i]) - height[i];
            ans += water[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}