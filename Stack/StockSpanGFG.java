import java.util.*;
class StockSpanGFG {
    public static ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        ArrayDeque< int[]> stack = new ArrayDeque<>();
        
        for(int i =0; i<arr.length; i++){
            if(stack.size()==0){
                ans.add(i+1);
            }
            else if(stack.size() > 0 && stack.peek()[0] >arr[i]){
                ans.add(i-stack.peek()[1]);
            }
            else if(stack.size()> 0 && stack.peek()[0] <= arr[i]) {
                while(stack.size() > 0 && stack.peek()[0] <= arr[i]){
                    stack.pop();
                }
                if(stack.size()==0){
                    ans.add(i+1);
                }else{
                    ans.add(i- stack.peek()[1]);
                }
            }
            stack.push(new int[]{arr[i], i});
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(calculateSpan(new int[]{100,80,90,120}));
        System.out.println(calculateSpan(new int[]{10,4,5,90,120,80}));
        

    }
    
}