import java.util.*;
class LargestRectangleHistogram {
    public static int largestRectangleArea(int[] heights) {
        int l = heights.length;

        //both stores the indices;
        int nsl[] = new int[l];
        int nsr[] = new int[l];
        ArrayDeque<int[]> s1 = new ArrayDeque<>();
        ArrayDeque<int[]> s2 = new ArrayDeque<>();
        for(int i=0;i<l; i++){
            if(s1.size()==0){
                nsl[i] = -1;  //since next smaller left  ==-1
            }else if(s1.size() >0 && s1.peek()[0] < heights[i]){
                nsl[i] = s1.peek()[1];
            }else if(s1.size() > 0 && s1.peek()[0] >= heights[i]){
                while(s1.size() > 0 && s1.peek()[0] >= heights[i]){
                    s1.pop();
                }
                if(s1.size()==0){
                    nsl[i]=-1;
                }else {
                    nsl[i] = s1.peek()[1];
                }
            }
            s1.push(new int[]{heights[i], i});

        }

        for(int i = l-1; i>=0; i--){
            if(s2.size() == 0){
                nsr[i] = l;  //since next smaller right == l
            }
            else if(s2.size() >0 && s2.peek()[0] < heights[i]){
                nsr[i] = s2.peek()[1];
            }else if(s2.size() >0 && s2.peek()[0] >= heights[i]){
                while(s2.size() > 0 && s2.peek()[0] >= heights[i]){
                    s2.pop();
                }
                if(s2.size()==0){
                    nsr[i] = l;
                }else {
                    nsr[i] = s2.peek()[1];
                }
            }
            s2.push(new int[]{heights[i], i});
        }

        int ans = 0;
        for(int i =0; i<l; i++){
            ans = Math.max(ans, (nsr[i] - nsl[i] -1)*heights[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
/*
Formula

Rectangle starts

NSL + 1

Rectangle ends

NSR - 1

So

start = NSL + 1
end   = NSR - 1

How many indices lie between them?

The count from start to end (inclusive) is:

end - start + 1

Substitute the values:

= (NSR - 1) - (NSL + 1) + 1

Simplify:

= NSR - NSL - 1

This is the width formula.
*/