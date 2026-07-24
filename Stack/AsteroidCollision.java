import java.util.*;
class Solution {
    public static int[] asteroidCollision(int[] asteroids) {
         ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int x: asteroids){
            if(x>0){
                stack.push(x);
                
            }else{
                while(!stack.isEmpty() && stack.peek() >0 && stack.peek()< -x ){
                    stack.pop();
                }
                // all if else if are from while(.....) here
                if(stack.isEmpty()){
                    stack.push(x);
                }else if(stack.peek()<0){
                    stack.push(x);
                }else if(stack.peek() == -x){
                    stack.pop();
                    // current element should also destroy
                    // as stack contains ans, and we don't push it , therfore destroyed since we go in next iteration
                }else{
                    // stack.peek() > -a
                    // current element to be destroyed
                }
            }
        }
        int[] ans  = new int[stack.size()];
        for(int i=ans.length-1; i>=0; i--){
            ans[i] =stack.pop();
        }
        return ans;

    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{5,10,-5})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{3,5,-6,2,-1,4})));

    }
}
/*
Better Idea

You actually don't need ArrayList at all.

The stack itself is the answer.

Whenever an asteroid survives,

push it.

Whenever it explodes,

don't push.

At the end,

the stack already contains the remaining asteroids.

Standard Stack Logic

For every asteroid

Positive
push
Negative

Keep fighting while

top > 0
and
top < |current|
pop

After loop

Case 1

stack empty
push current

Case 2

top == |current|

Both explode

pop

Current disappears.

Case 3

top > |current|

Current disappears.

Case 4

Top is negative

push current

No collision possible.
*/